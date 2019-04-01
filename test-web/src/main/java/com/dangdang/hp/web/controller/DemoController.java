package com.dangdang.hp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody String test(HttpServletRequest request, HttpServletResponse response){
		return "hello world!";
	}
	
	@RequestMapping(value = "/test2", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody String test2(HttpServletRequest request, HttpServletResponse response){
		return "哈哈!";
	}

}
