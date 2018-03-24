package com.gzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PostService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="hiPostSorry")
	public String hiPostService(String name) {
		System.out.println(name);
//        return restTemplate.getForObject("http://172.17.32.11/hi?name="+name,String.class);
//        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
		String forObject = restTemplate.getForObject("http://service-hi/hi?name="+name, String.class);
		System.out.println(forObject);
        return forObject;
    }
	
	public String hiPostSorry(String name){
		System.out.println("~~~~"+name);
		return "hi "+name+",i am sorry"+", Ribbon";
	}
	
}
