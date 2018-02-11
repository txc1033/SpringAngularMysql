package com.javifast.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javifast.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * Guarda un usuario
	 * @param user
	 * @return el usuario guardado
	 */
	User save(User user);

	/*
	 * Recupera la lista de usuarios
	 * 
	 * @return lista de usuarios
	 */
	List<User> findAll();
}
