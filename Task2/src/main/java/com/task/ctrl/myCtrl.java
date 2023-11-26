package com.task.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.Task2Application;
import com.task.entities.User;
import com.task.service.UserService;
//import com.task.services.UserService;

@RestController
public class myCtrl {
	@Autowired
	private UserService userService;
	@GetMapping("/home") //Here we give request on this url Using Postman.
	public String home() {
		return "this is home";
	}
	@GetMapping("/result")
	public ResponseEntity<User> getUser(@RequestParam Integer id) //@RequestParam esse ham postman mai Id k through data ko search kr skte hai hai.
	{
		return new ResponseEntity <User>(userService.getUserById(id),HttpStatus.OK);
	}
}