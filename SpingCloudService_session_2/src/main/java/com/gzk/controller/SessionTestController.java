package com.gzk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionTestController {

    @Value("${server.port}")
    String port;
	
	@RequestMapping("getSessionParam")
	public String getSessinoParam(HttpServletRequest request,String name){
		Object attribute = request.getSession().getAttribute(name);
		if(null == attribute){
			return "time out---"+port;
		}else{
			return attribute.toString()+"---"+port;
		}
	}
	
	@RequestMapping("setSessionParam")
	public String setSessionParam(HttpServletRequest request,String name,String value){
		request.getSession().setAttribute(name, value);
		return port;
	}
}
