package com.innowise.springhibernate.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private PassportDto passport;
}
