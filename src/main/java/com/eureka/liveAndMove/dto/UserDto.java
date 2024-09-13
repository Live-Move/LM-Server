package com.eureka.liveAndMove.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class UserDto {
	@Id
	private int user_id;
	private String loginId, password, name, address, phone;
	private Date birth;
}
