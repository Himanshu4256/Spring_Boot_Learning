package com.task.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.User;


public interface UserRepo extends JpaRepository<User, Integer> //JpaRepository- used for CRUD operstions, User- Class, Integer- primary key ka datatype
{
}
