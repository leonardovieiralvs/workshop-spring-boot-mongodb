package com.leosouza.workshopmongo.config;


import com.leosouza.workshopmongo.domain.Post;
import com.leosouza.workshopmongo.domain.User;
import com.leosouza.workshopmongo.dto.AuthorDTO;
import com.leosouza.workshopmongo.repository.PostRepository;
import com.leosouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User leo = new User(null, "leo", "leonardo@gmail.com");
        User bira = new User(null, "bira", "bira@gmail.com");
        User magro = new User(null, "magro", "magro@gmail.com");
        userRepository.saveAll(Arrays.asList(leo, bira, magro));

        Post post1 = new Post(null, sdf.parse("18/09/2025"), "Excelente", "Vou viajar para SP. Abraços", new AuthorDTO(leo));
        Post post2 = new Post(null, sdf.parse("28/09/2025"), "Excelenix", "Vou viajar para RJ. Abraços", new AuthorDTO(leo));
        Post post3 = new Post(null, sdf.parse("15/02/2024"), "Receba", "Vou viajar para ES. Abraços", new AuthorDTO(bira));
        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        leo.getPosts().addAll(Arrays.asList(post1, post2));
        bira.getPosts().add(post3);
        userRepository.saveAll(Arrays.asList(leo, bira));

    }
}
