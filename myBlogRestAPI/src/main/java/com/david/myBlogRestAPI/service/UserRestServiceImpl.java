package com.david.myBlogRestAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.myBlogRestAPI.dao.UserRepository;
import com.david.myBlogRestAPI.entity.User;

@Service
public class UserRestServiceImpl implements UserRestService {
	private UserRepository userRepository;

	@Autowired
	public UserRestServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
