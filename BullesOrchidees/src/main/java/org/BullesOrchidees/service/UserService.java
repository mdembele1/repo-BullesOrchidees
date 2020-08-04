package org.BullesOrchidees.service;

import org.BullesOrchidees.model.User;
import org.BullesOrchidees.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public Integer createUser(User user) {
		User newUser = userRepository.save(user);
		return newUser.getUserId();
	}
	
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

}
