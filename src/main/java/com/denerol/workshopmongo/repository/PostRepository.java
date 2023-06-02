package com.denerol.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.denerol.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

/*metodo para buscar no post um titulo que contém
 * uma String recebida 	
 */
	List<Post> findByTitleContainingIgnoreCase(String text);
}
