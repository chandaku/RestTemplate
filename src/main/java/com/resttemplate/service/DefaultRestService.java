package com.resttemplate.service;

import com.resttemplate.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultRestService implements RestService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Post> getPosts() {
        String resourceUrl
                = "http://localhost:8089/posts";
        ResponseEntity<List<Post>> response = restTemplate.exchange(resourceUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
                });
        return response.getBody();
    }

    @Override
    public Flux<Post> getPostsWebClient() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("http://localhost:8089")
                /*.defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))*/
                .build();
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);
    }


}
