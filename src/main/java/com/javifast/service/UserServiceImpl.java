package com.javifast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javifast.model.User;
import com.javifast.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}
}
