package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;


    public UserForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }
}
