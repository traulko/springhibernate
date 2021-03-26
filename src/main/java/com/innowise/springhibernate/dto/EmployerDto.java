package com.innowise.springhibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployerDto {
    private Long id;
    private String name;
    private String company;
}
