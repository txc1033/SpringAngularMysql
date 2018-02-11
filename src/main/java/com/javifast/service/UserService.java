package com.javifast.service;

import java.util.List;

import com.javifast.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

}
