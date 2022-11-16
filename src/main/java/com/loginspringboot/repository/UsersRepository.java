package com.loginspringboot.repository;

import com.loginspringboot.model.UsersModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
	
	Optional<UsersModel> findByLoginAndPassword(String login, String password);
	
	Optional<UsersModel> findFirstByLogin(String login);
	
	Optional<UsersModel> findByEmail(String email);
}


