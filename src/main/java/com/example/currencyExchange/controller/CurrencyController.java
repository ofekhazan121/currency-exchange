package com.example.currencyExchange.controller;


import com.example.currencyExchange.model.Currency;
import com.example.currencyExchange.model.Result;
import com.example.currencyExchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping("/convert")
    public Result getResults(@RequestBody Currency currency) {
        return currencyService.getResult(currency);
    }
}
