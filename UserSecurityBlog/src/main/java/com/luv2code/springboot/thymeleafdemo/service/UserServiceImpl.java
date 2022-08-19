package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.UserRepository;
import com.luv2code.springboot.thymeleafdemo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAllByOrderByUsernameAsc();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);

		User theUser = null;

		if (result.isPresent()) {
			theUser = result.get();
		} else {
			// we didn't find the User
			throw new RuntimeException("Did not find User id - " + theId);
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}

}
