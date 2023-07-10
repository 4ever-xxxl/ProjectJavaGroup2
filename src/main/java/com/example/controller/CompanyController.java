package com.example.controller;


import com.example.common.Result;
import com.example.dao.CompanyDao;
import com.example.entity.Company;
import com.example.service.Imp.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    @Resource
    private CompanyService companyservice;
    @Resource
    private CompanyDao companydao;

    @GetMapping("/getCompanyById/{cID}")
    public Result getCompanyById(@PathVariable long cID){
        return Result.success(companydao.getCompanyById(cID));
    }
    @GetMapping("/getCompanyByName/{cName}")
    public Result getCompanyById(@PathVariable String cName){
        return Result.success(companydao.getCompanyByName('%'+cName+'%'));
    }

    @GetMapping("/getAllCompany")
    public Result getCompanyById(){
        return Result.success(companydao.getAllCompany());
    }


    @PostMapping("/addCompany")
    public Result addCompanyStuff(@RequestBody Company company)
    {
        return Result.success(companyservice.addCompany(company));
    }

    @PutMapping("/updateCompany")
    public Result updateCompany(@RequestBody Company company)
    {
        return Result.success(companyservice.updateCompany(company));
    }

    @DeleteMapping("/deleteCompanyById/{cID}")
    public Result deleteCompany(@PathVariable long cID){
        return  Result.success(companyservice.deleteCompanyById(cID));
    }
}
