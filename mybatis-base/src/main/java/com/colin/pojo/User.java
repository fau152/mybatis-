package com.colin.pojo;

import lombok.Value;

@Value
public class User {
    private Integer id;
    private String username;
    private String password;
}
