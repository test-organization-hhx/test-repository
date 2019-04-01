package com.dangdang.hp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dangdang.hp.web.request.JspRequest;

@Controller
public class DemoV2Controller {
	
	@RequestMapping(value = "/testjsp", method = { RequestMethod.POST, RequestMethod.GET })
	public String test(HttpServletRequest request, HttpServletResponse response, Model model, JspRequest reqObj){
		
		String name = reqObj.getName();
		
		model.addAttribute("aa", "哈哈");
		
		model.addAttribute("bb", name);
		
		return "test";
	}
	
	
	public static void main(String[] args){
		
		System.out.println(System.currentTimeMillis());
		
	}

}
