package com.learn.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.UserDTO;
import com.learn.entity.User;
import com.learn.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User saveData(UserDTO dto) {
		
		User convertDtoToEntity = convertDtoToEntity(dto);
		
		return userRepository.save(convertDtoToEntity);
	}
	
	
	//entity to DTO
	private UserDTO convertEntityToDto(User user) {
		modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDTO dto = new UserDTO();
		dto = modelMapper.map(user, UserDTO.class);
		return dto;
	}
	
	
	//DTO to entity
	private User convertDtoToEntity(UserDTO userDto) {
		modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		User user = new User();
		user = modelMapper.map(userDto, User.class);
		return user;
	}
	
	private UserDTO dtoas(User user) {
		modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		UserDTO dto = new UserDTO();
		modelMapper.map(user, dto);
		return dto;
	}
	
}
