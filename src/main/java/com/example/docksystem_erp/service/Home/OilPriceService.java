package com.example.docksystem_erp.service.Home;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OilPriceService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String apiKey = "3ad929ce029a94a2e6e8eef23a451c87c20d9aadb250fccb69293d724e99b30d";

    public Map<String, Object> getLatestOilPrices() {
        Map<String, Object> latestPrices = new HashMap<>();

        latestPrices.put("wti", getPriceForCode("WTI_USD"));
        latestPrices.put("brent", getPriceForCode("BRENT_CRUDE_USD"));
        latestPrices.put("dubai", getPriceForCode("DUBAI_CRUDE_USD"));
        latestPrices.put("tapis", getPriceForCode("TAPIS_CRUDE_USD"));
        return latestPrices;
    }

    private Map<String, Object> getPriceForCode(String oilCode) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Token " + apiKey);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            String url = "https://api.oilpriceapi.com/v1/prices/latest?by_code=" + oilCode;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            JsonNode data = objectMapper.readTree(response.getBody()).path("data");

            if (data.path("price").isMissingNode()) {
                return Map.of("price", "N/A");
            }

            return Map.of("price", data.path("price").asDouble());

        } catch (Exception e) {
            System.err.println(oilCode + " 가격 조회 실패: " + e.getMessage());
            return Map.of("price", "N/A");
        }
    }
}
