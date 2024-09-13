package com.eureka.liveAndMove.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.liveAndMove.dto.UserDto;
import com.eureka.liveAndMove.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Spring 연결 확인 
	@GetMapping("/api/connection")
	public String checkConnection() {
		return "[ connectecd ] user controller";
	}
	
	// 로그인
	@PostMapping("/api/user/login")
	public HashMap<String, Object> userLogin(
			@RequestBody UserDto user, HttpSession session
			){
		HashMap<String, Object> result = new HashMap<>();
		result.put("code", "ok");
		System.out.println("=== [ 로그인 실행 ] ===");
		System.out.println(user);
		
		UserDto response = userService.getLogin(user);
		System.out.println("=== [ SQL 결과 ] ===");
		System.out.println(response);
		
		// 존재하지 않은 아이디 
		if(response==null){ 
			result.put("code", "fail");
			result.put("message", "미등록 아이디");
			return result;
		}
		
		// 비밀번호 틀린 경우 
		if(!response.getPassword().equals(user.getPassword())) {
			result.put("code", "fail");
			result.put("message", "암호가 틀림");
			return result;
		}
		
		// 로그인 성공 ( 아이디 O, 비밀번호 O ) 
		if("ok".equals(result.get("code"))) {
			System.out.println("[로그인 성공]");
			// 세션에 user이름으로 유저정보 저장 
			// user이름을 저장이 없으면 로그인 안한것임
			session.setAttribute("user", response);

			System.out.println("=== [ HTTP 세션 ] ===");
			System.out.println(session);
		}
		
		response.setPassword(null);		// 비밀 번호를 가리기 위함 
		result.put("data", response); 	// 로그인 성공시 사용자 정보 넘겨줌		
		
		return result;
	}
	
	
	// 회원 가입 
	@PostMapping("/api/user/signup")
	public HashMap<String, Object> addUser(@RequestBody UserDto user){
		System.out.println("addUser : "+user);
		HashMap<String, Object> result=new HashMap<>();
		
		// 회원가입 실패 => 이미 존재하는 아이디 
		if ( userService.addUser(user) == null ) {
			result.put("code", "fail");
			result.put("data", null);
		}
		else {
			result.put("code", "ok");
			result.put("data", user);			
		}
		return result;
	}
	
}
