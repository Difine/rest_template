/*
 * @author Dmitry Komarov
 * Created 20.07.2024
 */


package com.rest_template.temp.controllers;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Rest {

    private static final String GET_ALL_USERS = "http://94.198.50.185:7081/api/users";
    private static final String ADD_USER = "http://94.198.50.185:7081/api/users";
    private static final String UPDATE_USER = "http://94.198.50.185:7081/api/users";
    private static final String DELETE_USER = "http://94.198.50.185:7081/api/users/{id}";
    private static RestTemplate restTemplate = new RestTemplate();

    private void getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS, HttpMethod.GET, entity,
                String.class);

        System.out.println(result);
    }








}
