package com.resttemplate.resources;

import com.resttemplate.service.RestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.resttemplate.model.Post;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class RestResources {

    RestService restService;

    public RestResources(final RestService restService) {
        this.restService = restService;
    }

    @GetMapping()
    public List<Post> getPosts(){
        List<Post> posts =  restService.getPosts();
        return posts;
    }

    @GetMapping("/web-client")
    public Flux<Post> getPostsWebClient(){
        return   restService.getPostsWebClient();
    }
}
