package com.resttemplate.service;

import com.resttemplate.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultRestService implements RestService {

    @Override
    public List<Post> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8089/posts";
        ResponseEntity<List<Post>> response = restTemplate.exchange(resourceUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
                });
        return response.getBody();
    }
}
