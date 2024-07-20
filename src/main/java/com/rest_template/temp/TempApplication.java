package com.rest_template.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TempApplication {

	public static void main(String[] args) {
		SpringApplication.run(TempApplication.class, args);
		getUsers();
	}

	private static final String GET_ALL_USERS = "http://94.198.50.185:7081/api/users";
	private static final String ADD_USER = "http://94.198.50.185:7081/api/users";
	private static final String UPDATE_USER = "http://94.198.50.185:7081/api/users";
	private static final String DELETE_USER = "http://94.198.50.185:7081/api/users/{id}";
	private static RestTemplate restTemplate = new RestTemplate();

	private static void getUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS, HttpMethod.GET, entity,
				String.class);
		System.out.println(result.getHeaders());

		List<String> cookies = result.getHeaders().get("Set-Cookie");
		headers.set("Cookie", cookies.stream().collect(Collectors.joining(";")));
		HttpEntity<String> entity1 = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result_add = restTemplate.exchange(ADD_USER, HttpMethod.POST, entity1,
				String.class);
	}

}
