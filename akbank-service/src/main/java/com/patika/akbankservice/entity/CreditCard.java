package com.patika.akbankservice.entity;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreditCard implements Product {
    private BigDecimal fee;
    private List<Campaign> campaignList;
    private final String bank = "akbank";
}
