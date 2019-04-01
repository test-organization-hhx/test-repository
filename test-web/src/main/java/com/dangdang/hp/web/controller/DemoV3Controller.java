package com.dangdang.hp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dangdang.hp.web.request.JspRequest;
import com.dangdang.hp.web.response.JsonResponse;

@Controller
public class DemoV3Controller {
	
	@RequestMapping(value = "/testjson", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response, Model model, JspRequest reqObj){
		
		String name = reqObj.getName();
		
//		model.addAttribute("aa", "哈哈");
//		
//		model.addAttribute("bb", name);
		
		JsonResponse jsonResponse = new JsonResponse();
		
		jsonResponse.setId(123456);
		jsonResponse.setName(name);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject(jsonResponse);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/v2/testjson", method = { RequestMethod.POST, RequestMethod.GET })
	public JsonResponse testV2(HttpServletRequest request, HttpServletResponse response, Model model, JspRequest reqObj){
		
		String name = reqObj.getName();
		
//		model.addAttribute("aa", "哈哈");
//		
//		model.addAttribute("bb", name);
		
		JsonResponse jsonResponse = new JsonResponse();
		
		jsonResponse.setId(123456);
		jsonResponse.setName(name);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject(jsonResponse);
		
		return jsonResponse;
	}

}
