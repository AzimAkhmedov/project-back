package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @PostMapping("/add_company")
    public Company createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @DeleteMapping("/company/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyRepository.deleteById(id);
    }

    @PutMapping("/company/{id}")
    public void updateCompany(@PathVariable Long id, @RequestBody Company company){
        Company oldCompany = companyRepository.findById(id).get();

        oldCompany.setCompanyName(company.getCompanyName());
        oldCompany.setCountryID(company.getCountryID());

        companyRepository.save(oldCompany);
    }
}
