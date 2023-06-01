package com.denerol.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.dto.UserDTO;
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
	
/* metodos para inserir um usuario no banco.
 * recebo a requisição do front como DTO converto para User
 * e assim insiro no banco de dados
 */
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
