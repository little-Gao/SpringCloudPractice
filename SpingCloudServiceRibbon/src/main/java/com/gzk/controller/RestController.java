package com.gzk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	RestService service;

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return service.hiService(name)+", Ribbon";
	}
}
