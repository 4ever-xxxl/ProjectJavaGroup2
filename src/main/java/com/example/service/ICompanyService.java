package com.example.service;

import com.example.common.Result;
import com.example.entity.Company;

public interface ICompanyService {
    Result addCompany(Company company);
    Result updateCompany(Company company);
    Result deleteCompanyById(long cID);
}
