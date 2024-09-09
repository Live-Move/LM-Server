package com.eureka.liveAndMove.service;

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
	
	
}
