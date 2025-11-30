package com.MyProjects.E_Commerce.DAO;

import com.MyProjects.E_Commerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends  JpaRepository<User,Integer>
{

  Optional<User>  findByEmail(String email) ;



//    void create (User user) ;
//    void update (User user) ;
//    User getUser (int id);


}
