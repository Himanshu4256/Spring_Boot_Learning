package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.UserDTO;
import com.learn.service.UserService;

@RestController
@RequestMapping("/api")
public class UserDtoController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public void saveUserData(@RequestBody UserDTO userDTO) {
		service.saveData(userDTO);
	}

}
