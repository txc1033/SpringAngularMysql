package com.javifast.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javifast.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@SuppressWarnings("unchecked")
	User save(User user);

}
