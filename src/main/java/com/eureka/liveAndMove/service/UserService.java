package com.eureka.liveAndMove.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.liveAndMove.Repository.UserRepository;
import com.eureka.liveAndMove.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public UserDto getLogin(UserDto user) {
		Optional<UserDto> response = userRepo.findByLoginId(user.getLoginId());
		return response.isEmpty()? null: response.get();
	}
	
	public UserDto addUser(UserDto dto) {
		if( getLogin(dto) != null) {
			return null;
		}
		return userRepo.save(dto);
	}
	
	public List<UserDto> listUser() {
		return userRepo.findAll();
	}
	
}
