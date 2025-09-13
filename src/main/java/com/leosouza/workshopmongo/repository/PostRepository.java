package com.leosouza.workshopmongo.repository;

import com.leosouza.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
