package com.arvs.epgs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arvs.epgs.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
