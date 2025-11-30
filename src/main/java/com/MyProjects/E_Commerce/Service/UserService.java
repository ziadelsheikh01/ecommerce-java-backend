package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DTO.UserDto.UpdatedUserDto;
import com.MyProjects.E_Commerce.DTO.UserDto.CreateUserReqDto;
import com.MyProjects.E_Commerce.Entity.User;

public interface UserService {
    void create (CreateUserReqDto user) ;
    void update (UpdatedUserDto user , int id) ;
    User getUser (int id) ;
}
