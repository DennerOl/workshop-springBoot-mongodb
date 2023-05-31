package com.denerol.workshopmongo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.dto.UserDTO;
import com.denerol.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

// retorna uma lista de usuarios do Service
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
// converto a lista do tipo user para userDTO
		List<UserDTO> listDto = 
		list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
// retorna um usuario pelo Id	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public UserDTO findById(@PathVariable String id) {
		Optional<User> obj = service.findById(id);
		User user = obj.get();
		UserDTO dto = new UserDTO(user);
		return dto;
	}
	
}
