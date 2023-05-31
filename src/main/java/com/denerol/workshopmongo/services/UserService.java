package com.denerol.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.repository.UserRepository;
import com.denerol.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
/* criando uma lista de usuarios apartir do repository
 * para retornar no Resource ou seja para o usuario
 */
	public List<User> findAll(){
		return repo.findAll();
	}
/* retornando um usuario pelo Id informado 
 * 
 */
	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
}
