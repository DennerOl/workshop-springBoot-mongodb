package com.denerol.workshopmongo.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.denerol.workshopmongo.domain.Post;
import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.dto.UserDTO;
import com.denerol.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;


// retorna um post pelo id	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Optional<Post> findById(@PathVariable String id) {
		Optional<Post> obj = service.findById(id);
		return obj;
	}
	

}
