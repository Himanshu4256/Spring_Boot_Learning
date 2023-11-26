package com.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.task.Repo.UserRepo;
import com.task.entities.User;

@SpringBootApplication
public class Task2Application implements CommandLineRunner //CommandLineRunner- Basically keh skte hai data to set krane k liye
{
	@Autowired
	private UserRepo user;

	public static void main(String[] args) {
	SpringApplication.run(Task2Application.class, args);
	System.out.println("Welcome");}
	
	@Override
	public void run(String... args) throws Exception {
	
	User user1=new User();
	user1.setName("Gajal");
	user1.setAge(4);
	user1.setSalary(54000);
	user.save(user1);
	}
}