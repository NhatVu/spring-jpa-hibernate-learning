package org.example.controller;

import org.example.entity.CompanyEntity;
import org.example.entity.StudentEntity;
import org.example.repository.CompanyRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @PostMapping
    public CompanyEntity createStudent(@RequestBody CompanyEntity entity){
        CompanyEntity res = companyRepository.save(entity);
        return res;
    }

    @GetMapping
    public List<CompanyEntity> getCompanies(){
        List<CompanyEntity> res = companyRepository.findAll();
        return res;
    }
}
