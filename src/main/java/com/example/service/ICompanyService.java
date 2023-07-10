package com.example.service;

import com.example.common.Result;
import com.example.controller.Request.CompanyPageRequest;
import com.example.entity.Company;


import java.util.List;

public interface ICompanyService {
    Result addCompany(Company company);
    Result updateCompany(Company company);
    Result deleteCompanyById(long cID);


    List<Company> searchCompany(CompanyPageRequest companypagerequest);
}
