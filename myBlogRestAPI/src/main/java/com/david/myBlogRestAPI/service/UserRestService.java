package com.david.myBlogRestAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.david.myBlogRestAPI.entity.User;

@Service
public interface UserRestService {

	List<User> getUsers();

}
