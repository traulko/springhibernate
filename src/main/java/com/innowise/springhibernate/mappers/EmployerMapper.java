package com.innowise.springhibernate.mappers;

import com.innowise.springhibernate.dto.EmployerDto;
import com.innowise.springhibernate.entities.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerMapper INSTANCE = Mappers.getMapper(EmployerMapper.class);

    EmployerDto employerToEmployerDto(Employer employer);

    Employer employerDtoToEmployer(EmployerDto employerDto);
}

