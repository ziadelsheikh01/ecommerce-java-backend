package com.MyProjects.E_Commerce.DTO.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserReqDto
{
    @NotBlank(message = "name must not be blank")
   private String name ;
    @Email
    @NotBlank(message = "invalid email")
    private String Email ;
    @Size(min = 2 , max = 15,message = "invalid password")
    private String password ;

    public CreateUserReqDto(String name, String email, String password) {
        this.name = name;
        Email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CreateUserReqDto{" +
                "name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
