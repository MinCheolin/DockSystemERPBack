package com.example.docksystem_erp.controller.Home;

import com.example.docksystem_erp.service.Home.ExchangeRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/api/exchange-rate/summary")
    public Map<String, Object> getExchangeRateSummary() {
        return exchangeRateService.getExchangeRateSummary();
    }
}
