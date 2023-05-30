package com.denerol.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
/* criando uma lista de usuarios apartir do repository
 * para retornar no Resource	
 */
	public List<User> findAll(){
		return repo.findAll();
	}
	
}
