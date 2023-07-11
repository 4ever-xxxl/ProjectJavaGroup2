package com.example.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String usrName;
    private String token;
    private String usrClass;
    private long usrPermission;
}
