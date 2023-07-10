package com.example.entity;

import lombok.Data;

@Data
public class Company {
    private long cID;
    private String cSocialCreditCode;
    private String cAddress;
    private String cName;
    private String cRegion;

    public Company(long cID, String cSocialCreditCode, String cAddress, String cName, String cRegion){
        this.cSocialCreditCode=cSocialCreditCode;
        this.cRegion=cRegion;
        this.cID=cID;
        this.cAddress=cAddress;
        this.cName=cName;
    }
}
