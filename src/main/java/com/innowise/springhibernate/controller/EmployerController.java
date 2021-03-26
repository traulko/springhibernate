package com.innowise.springhibernate.controller;

import com.innowise.springhibernate.dto.EmployerDto;
import com.innowise.springhibernate.entities.Employer;
import com.innowise.springhibernate.mappers.EmployerMapper;
import com.innowise.springhibernate.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public void add(@RequestBody final EmployerDto employerDto) {
        Employer employer = EmployerMapper.INSTANCE.employerDtoToEmployer(employerDto);
        employerService.add(employerDto);
    }
}
