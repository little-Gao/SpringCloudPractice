package com.gzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestPostController {
	@Autowired
	PostService service;

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return service.hiPostService(name)+", Ribbon";
	}
}
