package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void addUser(User user) {

		userRepository.save(user);
	}

	//	public String validateUser(String username, String password) {
	//		
	//		Optional<User> optional = userRepository.findById(username);
	//		
	//		User user = optional.get();
	//		
	//		if(user.getPassword().equals(password)) {
	//			return "valid";
	//		}
	//		else {
	//			return "invalid";
	//		}
	//	}

	public String validateUser(String username, String password) {

		Optional<User> optional = userRepository.findById(username);

		User user = optional.get();

		if(user.getPassword().equals(password)) {
			return "valid";
		}
		else {
			return "invalid";
		}
	}


}
