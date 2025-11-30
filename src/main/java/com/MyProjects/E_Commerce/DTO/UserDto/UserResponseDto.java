package com.MyProjects.E_Commerce.DTO.UserDto;

import jakarta.validation.constraints.Email;

public class UserResponseDto
{
   private String Email ;
   private String Name ;

    public UserResponseDto(String email, String name) {
        Email = email;
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
