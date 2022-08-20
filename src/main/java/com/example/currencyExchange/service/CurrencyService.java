package com.example.currencyExchange.service;


import com.example.currencyExchange.model.Currency;
import com.example.currencyExchange.model.Result;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {

    private WebClient webClient = WebClient.create();

    private Currency currency;
    private JsonObjectDecoder JsonObject;
    private String baseUrl = "https://api.exchangerate.host/convert?";

    @Bean
    public Result getResult(Currency currency) {

        return webClient.method(HttpMethod.GET)
                .uri(baseUrl + "from=" + currency.getFrom() + "&to=" + currency.getTo() + "&amount=" + currency.getAmount())
                .retrieve()
                .bodyToMono(Result.class)
                .block();

    }
}
