//package com.MyProjects.E_Commerce.DAO;
//
//import com.MyProjects.E_Commerce.Entity.User;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.swing.text.html.parser.Entity;
//
//@Repository
//public class UserDaoImp implements  UserDao
//{
//   private EntityManager entityManager ;
//
//    UserDaoImp(EntityManager entityManager)
//    {
//        this.entityManager = entityManager ;
//    }
//
//    @Override
//    public void create(User user)
//    {
//        entityManager.persist(user);
//
//    }
//
//    @Override
//    public void update(User user )
//    {
//        entityManager.merge(user) ;
//    }
//
//    @Override
//    public User getUser(int id) {
//        return entityManager.find(User.class,id) ;
//    }
//}
