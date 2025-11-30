package com.MyProjects.E_Commerce.DTO.UserDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdatedUserDto
{

    @NotBlank(message = "the name must be blank")
    @Size(min = 3 , max = 55 , message = "name size must be between 3 and 55")
   private String name ;

    public UpdatedUserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UpdatedUserDto{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;

    }
}
