package com.practice.ctl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.entities.User;
import com.practice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	private UserService userService;

	@Autowired
	public UserCtrl(UserService userService) {
		this.userService = userService;
	}

// search the user in a List
	@GetMapping("/find")
	public ResponseEntity<List<User>> getUser() {
		List<User> list = userService.getAllUser();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(list));
	}
//search the user by using his id

	@GetMapping("/find/{id}")
	public ResponseEntity<User> getBook(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}
// delete the user by using his id 

	@DeleteMapping("/del/{userId}")
	public User deleteUser(@PathVariable("userId") int userId) {

		return this.userService.deleteUser(userId);
	}
	
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User b= null;
		try {b=	this.userService.addUser(user);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
			
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userId") int userId){
		try {
			this.userService.updateUser(user, userId);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
}}
