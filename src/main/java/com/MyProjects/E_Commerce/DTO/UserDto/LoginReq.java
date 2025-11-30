package com.MyProjects.E_Commerce.DTO.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginReq {
    @Email
    @NotBlank
    private String email ;
    @Size(min = 2  ,max = 15 , message = "password size must be between 2 and 15 ")
    private String password ;

    public LoginReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
