package com.patika.akbankservice.entity;

import java.math.BigDecimal;

import com.patika.akbankservice.enums.LoanType;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@RequiredArgsConstructor
public class Loan implements Product {
    private BigDecimal amount;
    private Integer installment;
    private final String bank = "akbank";
    private Double interestRate;
    private LoanType loanType;
}
