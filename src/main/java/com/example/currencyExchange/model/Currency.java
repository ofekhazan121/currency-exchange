package com.example.currencyExchange.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
public class Currency {

    private String from;
    private String to;
    private float amount;
}
