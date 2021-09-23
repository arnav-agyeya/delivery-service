package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserDao extends JpaRepository<LoginUser, Long> {
    @Query("select u from #{#entityName} u where u.username= :username")
    LoginUser findLoginUserByUsername(@Param("username") String username);
}