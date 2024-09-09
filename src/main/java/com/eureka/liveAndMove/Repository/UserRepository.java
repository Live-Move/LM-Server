package com.eureka.liveAndMove.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.liveAndMove.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Integer>{

	Optional<UserDto> findByLoginId(String loginId);

}
