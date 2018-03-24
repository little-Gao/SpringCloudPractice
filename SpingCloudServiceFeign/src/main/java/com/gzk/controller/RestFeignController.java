package com.gzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestFeignController {
	@Autowired
	FeignService service;

	@RequestMapping(value = "/hi")
	public String hiFeign(@RequestParam String name) {
		return service.hiFeignService(name)+", Feign";
	}
}
