package com.phantomxe.customerservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CustomerRequest { 
    private String name;
    private String email;
    private LocalDate dateOfBirth; 
}
