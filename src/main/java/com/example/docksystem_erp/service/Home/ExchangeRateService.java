package com.example.docksystem_erp.service.Home;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ExchangeRateService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String authKey = "HibFSPlEZX9lIoTwiRJJ8ZDhS7rG1hiy";

    public Map<String, Object> getExchangeRateSummary() {
        // 최근 8일치 데이터를 가져옵니다 (오늘/어제 비교 및 주간 최고/최저 계산용).
        List<Map<String, String>> historicalData = getHistoricalExchangeRates(8);

        if (historicalData == null || historicalData.size() < 2) {
            return Map.of("error", "통계 정보를 계산하기에 데이터가 충분하지 않습니다.");
        }

        historicalData.sort(Comparator.comparing(m -> m.get("date")));

        Map<String, String> todayData = historicalData.get(historicalData.size() - 1);
        Map<String, String> yesterdayData = historicalData.get(historicalData.size() - 2);

        double currentRate = Double.parseDouble(todayData.get("rate"));
        double previousRate = Double.parseDouble(yesterdayData.get("rate"));
        double change = currentRate - previousRate;

        double weeklyHigh = historicalData.stream()
                .mapToDouble(d -> Double.parseDouble(d.get("rate")))
                .max()
                .orElse(0.0);
        double weeklyLow = historicalData.stream()
                .mapToDouble(d -> Double.parseDouble(d.get("rate")))
                .min()
                .orElse(0.0);

        Map<String, Object> summary = new HashMap<>();
        summary.put("currentRate", currentRate);
        summary.put("change", change);
        summary.put("weeklyHigh", weeklyHigh);
        summary.put("weeklyLow", weeklyLow);
        summary.put("last_updated", todayData.get("date"));
        // 차트용 과거 데이터를 summary 결과에 포함
        summary.put("historicalData", historicalData);

        return summary;
    }

    public List<Map<String, String>> getHistoricalExchangeRates(int days) {
        List<Map<String, String>> historicalData = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (int i = 0; i < days; i++) {
            LocalDate date = today.minusDays(i);
            String searchDate = date.format(formatter);
            try {
                URI uri = UriComponentsBuilder
                        .fromUriString("https://oapi.koreaexim.go.kr")
                        .path("/site/program/financial/exchangeJSON")
                        .queryParam("authkey", authKey)
                        .queryParam("searchdate", searchDate)
                        .queryParam("data", "AP01")
                        .encode(StandardCharsets.UTF_8)
                        .build()
                        .toUri();

                String response = restTemplate.getForObject(uri, String.class);
                JsonNode root = objectMapper.readTree(response);

                if (root.isArray() && !root.isEmpty()) {
                    for (JsonNode item : root) {
                        if ("USD".equals(item.path("cur_unit").asText())) {
                            Map<String, String> dayData = new HashMap<>();
                            dayData.put("date", date.toString());
                            dayData.put("rate", item.path("deal_bas_r").asText().replace(",", ""));
                            historicalData.add(dayData);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println(searchDate + " 데이터 조회 실패: " + e.getMessage());
            }
        }
        return historicalData;
    }
}
