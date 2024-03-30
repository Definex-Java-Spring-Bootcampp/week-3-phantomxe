package com.patika.akbankservice.entity;

import java.time.LocalDate;

import com.patika.akbankservice.enums.SectorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Campaign {
    private String title;
    private String content;
    private LocalDate dueDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private SectorType sector;
}
