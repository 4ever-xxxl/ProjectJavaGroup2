package com.example.controller.Request;

import lombok.Data;

@Data
public class UserPageRequest extends BaseRequest{
    private String username;
    private String userclass;
    private int userpermission;
}
