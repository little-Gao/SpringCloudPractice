package com.gzk.controller;

import org.springframework.web.client.RestTemplate;

public class RestTest {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String forObject = restTemplate.getForObject("http://localhost:8772/hi?name=123", String.class);
		System.out.println(forObject);
	}
}
