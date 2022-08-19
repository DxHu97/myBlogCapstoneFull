package com.david.myBlogRestAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.myBlogRestAPI.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Override
	public List<User> findAll();

	public User findUserById(int theId);

	public User deleteById(int theId);
}
