package com.example.controller;


import com.example.common.Result;
import com.example.controller.Request.CompanyPageRequest;
import com.example.dao.CompanyDao;
import com.example.entity.Company;

import com.example.service.Imp.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        return companyservice.addCompany(company);
    }

    @PutMapping("/updateCompany")
    public Result updateCompany(@RequestBody Company company)
    {
        return companyservice.updateCompany(company);
    }

    @DeleteMapping("/deleteCompanyById/{cID}")
    public Result deleteCompany(@PathVariable long cID){
        return  companyservice.deleteCompanyById(cID);
    }


    @PostMapping("/searchCompany")
    public Result searchCompany(@RequestBody CompanyPageRequest companypagerequest)
    {
        PageHelper.startPage(companypagerequest.getPageNum(),companypagerequest.getPageSize());
        List<Company> companies=companyservice.searchCompany(companypagerequest);
        return Result.success(new PageInfo<>(companies));
    }
}
