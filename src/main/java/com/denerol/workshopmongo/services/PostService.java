package com.denerol.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denerol.workshopmongo.domain.Post;
import com.denerol.workshopmongo.repository.PostRepository;
import com.denerol.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Optional<Post> findById(String id) {
		Optional<Post> user = repo.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
// metodo para usar o metodo do repository
	public List<Post> findByTitle(String text){
		return repo.serchTitle(text);
	}
	
/* metodo de consulta da Query full	
 * tenho que transformar a dataMax em um dia 
 */
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
