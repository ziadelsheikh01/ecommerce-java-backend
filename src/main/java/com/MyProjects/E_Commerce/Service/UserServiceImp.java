package com.MyProjects.E_Commerce.Service;

import com.MyProjects.E_Commerce.DAO.UserDao;
import com.MyProjects.E_Commerce.DTO.UserDto.UpdatedUserDto;
import com.MyProjects.E_Commerce.DTO.UserDto.CreateUserReqDto;
import com.MyProjects.E_Commerce.Entity.Role;
import com.MyProjects.E_Commerce.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp  implements  UserService
{

    private UserDao userDao ;
    private PasswordEncoder passwordEncoder;

    public UserServiceImp(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void create(CreateUserReqDto createUserReqDto)
    {
        createUserReqDto.setPassword(passwordEncoder.encode(createUserReqDto.getPassword()));
        User user = new User(createUserReqDto.getName(), createUserReqDto.getEmail(), createUserReqDto.getPassword(), Role.USER,true);
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(UpdatedUserDto user, int id) {
        User user1 = userDao.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        if (user.getName()!= null) {
            user1.setName(user.getName());
        }
        userDao.save(user1);
    }

    @Override
    public User getUser(int id) {
        return  userDao.findById(id).orElseThrow() ;
    }
}
