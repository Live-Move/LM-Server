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

	public UserDto getUserInfoById(UserDto user) {
		Optional<UserDto> response = userRepo.findByLoginId(user.getLoginId());
		System.out.println("[ getUserInfoById ] >> "+response);
		return response.isEmpty()? null: response.get();
	}
	
	public UserDto getUserInfoByPersonal(UserDto user) {
		Optional<UserDto> response = userRepo.findByAddress(user.getAddress());
		System.out.println("[ findByAddress ] >> "+response);
		if (!response.isEmpty()) {
			System.out.println("[** not empty chk **]");
			UserDto chk_info = response.get();
			if (chk_info.getName().equals(user.getName())
					&& chk_info.getPhone().equals(user.getPhone())) {
				return chk_info;
			}
		}
		return null;
	}
	
	public UserDto addUser(UserDto dto) {
		if( getUserInfoById(dto) != null) {
			return null;
		}
		return userRepo.save(dto);
	}
	
	public List<UserDto> listUser() {
		return userRepo.findAll();
	}
	
}
