package com.newproject.repository;

import com.newproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    //  User findByFirstname(String firstName);
   // User findBYFirstNameAndLastName (String lastName);



}
