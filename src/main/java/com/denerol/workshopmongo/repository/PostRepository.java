package com.denerol.workshopmongo.repository;

import java.util.Date;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.denerol.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

/*metodo para buscar no post um titulo que contém
 * uma String recebida 	
 */
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> serchTitle(String text);
	
	
/*buscando post contendo um dado String em qualquer luga
 * 	no titulo, no corpo ou cometário e um periodo de 
 * datas 
 */
			
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
