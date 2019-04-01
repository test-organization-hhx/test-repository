package com.dangdang.hp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dangdang.hp.web.request.JspRequest;
import com.dangdang.hp.web.response.UserInfoResponse;

@Controller
public class XmlOrJsonController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(XmlOrJsonController.class);
	
	@RequestMapping(value = "/xmlOrJson", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response, Model model, JspRequest reqObj){
		
		LOGGER.info("开始请求:/xmlOrJson,请求参数reqObj:{}", reqObj);
		
		String name = reqObj.getName();
		
//		model.addAttribute("aa", "哈哈");
//		
//		model.addAttribute("bb", name);
		
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		
		userInfoResponse.setId(123456);
		userInfoResponse.setName(name);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject(userInfoResponse);
		
		return mv;
	}

}
