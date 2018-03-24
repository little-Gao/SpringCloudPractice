package com.gzk.controller;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystric implements FeignService{

	public String hiFeignService(String name) {
		return "Sorry Feign, "+name;
	}

}
