package com.gzk.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@EnableHystrixDashboard
@FeignClient(value = "service-hi",fallback=FeignServiceHystric.class)
public interface FeignService {

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String hiFeignService(@RequestParam(value = "name") String name);
	
}
