package com.innowise.springhibernate.mappers;

import com.innowise.springhibernate.dto.PassportDto;
import com.innowise.springhibernate.entities.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    PassportDto passportToPassportDto(Passport passport);

    Passport passportDtoToPassport(PassportDto passportDto);
}