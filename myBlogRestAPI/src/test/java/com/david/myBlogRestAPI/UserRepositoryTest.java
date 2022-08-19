package com.david.myBlogRestAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.david.myBlogRestAPI.dao.UserRepository;
import com.david.myBlogRestAPI.entity.User;

@Transactional
@Rollback
@SpringBootTest(classes = MyBlogRestApiApplication.class)
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;

	@Test
	void testUserRepositoryIsNotNull() {
		Assertions.assertNotNull(userRepository);
	}

	// find user by their username
	@Test
	void findUserById() {
		User user = new User();
		user.setUsername("username1");
		userRepository.save(user);
		User user2 = userRepository.findById(user.getId()).get();
		Assertions.assertNotNull(user2);
		Assertions.assertEquals("username1", user2.getUsername());
	}

	@Test
	void testDeleteUser() {
		User user = new User();
		userRepository.save(user);
		int id = user.getId();
		userRepository.deleteById(id);
		Assertions.assertFalse(userRepository.findById(id).isPresent());
	}

}
