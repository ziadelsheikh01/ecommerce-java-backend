package com.MyProjects.E_Commerce.Mapper;

import com.MyProjects.E_Commerce.DTO.ProductDto.ProductResponse;
import com.MyProjects.E_Commerce.DTO.UserDto.UserResponseDto;
import com.MyProjects.E_Commerce.Entity.Product;
import com.MyProjects.E_Commerce.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
{

    public UserResponseDto toDto(User user);
}
