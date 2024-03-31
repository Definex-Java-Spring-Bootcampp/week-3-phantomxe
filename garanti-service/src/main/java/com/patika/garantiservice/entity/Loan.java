package com.patika.garantiservice.entity;

import java.math.BigDecimal;

import com.patika.garantiservice.enums.LoanType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Loan implements Product {
    private BigDecimal amount;
    private Integer installment;
    private final String bank = "garanti";
    private Double interestRate;
    private LoanType loanType;
}
