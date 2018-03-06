package com.resttemplate.service;

import com.resttemplate.model.Post;
import reactor.core.publisher.Flux;

import java.util.List;

public interface RestService {

    List<Post> getPosts();
    Flux<Post> getPostsWebClient();
}
