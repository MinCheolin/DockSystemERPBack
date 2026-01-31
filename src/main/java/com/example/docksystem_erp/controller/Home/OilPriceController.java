package com.example.docksystem_erp.controller.Home;

import com.example.docksystem_erp.service.Home.OilPriceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OilPriceController {

    private final OilPriceService oilPriceService;

    public OilPriceController(OilPriceService oilPriceService) {
        this.oilPriceService = oilPriceService;
    }

    @GetMapping("/api/oil-price/latest-all")
    public Map<String, Object> getLatestOilPrices() {
        return oilPriceService.getLatestOilPrices();
    }
}
