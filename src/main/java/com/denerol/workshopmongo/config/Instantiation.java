package com.denerol.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.denerol.workshopmongo.domain.Post;
import com.denerol.workshopmongo.domain.User;
import com.denerol.workshopmongo.dto.AuthorDTO;
import com.denerol.workshopmongo.repository.PostRepository;
import com.denerol.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll( Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll( Arrays.asList(post1, post2));
		
	}

}
