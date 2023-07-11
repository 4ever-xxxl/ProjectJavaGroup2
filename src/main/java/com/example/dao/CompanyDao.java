package com.example.dao;
import com.example.controller.Request.CompanyPageRequest;
import com.example.entity.Company;

import java.util.List;

public interface CompanyDao {
    Company getCompanyById(long cID);
    List<Company> getCompanyByName(String cName);
    List<Company> getAllCompany();

    Integer addCompany(Company company);
    Integer deleteCompanyById(long cID);

    Integer updateCompany(Company company);

    List<Company> searchCompany(CompanyPageRequest companypagerequest);

}
