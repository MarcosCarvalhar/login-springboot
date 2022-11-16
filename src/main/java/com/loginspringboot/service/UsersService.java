package com.loginspringboot.service;

import org.springframework.stereotype.Service;

import com.loginspringboot.model.UsersModel;
import com.loginspringboot.repository.UsersRepository;

@Service
public class UsersService {

	private UsersRepository usersRepository;
	
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public UsersModel registerUser(String login, String password, String email) {
		if(login == null || password == null) {			
			return null;
		}
		else {
			if(usersRepository.findFirstByLogin(login).isPresent()) {
				System.out.println("Duplicate login");
				return null;
			}			
			if(usersRepository.findByEmail(email).isPresent()) {
					System.out.println("Duplicate email");
					return null;
				
			}
			UsersModel usersModel = new UsersModel();
			usersModel.setLogin(login);
			usersModel.setPassword(password);
			usersModel.setEmail(email);
			return usersRepository.save(usersModel);
		}
	}
	
	public UsersModel authenticate(String login, String password) {
		return usersRepository.findByLoginAndPassword(login, password).orElse(null);
	}
}
