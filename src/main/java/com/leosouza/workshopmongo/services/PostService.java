package com.leosouza.workshopmongo.services;

import com.leosouza.workshopmongo.domain.Post;
import com.leosouza.workshopmongo.repository.PostRepository;
import com.leosouza.workshopmongo.resource.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcpetion("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContaining(text);
    }
}
