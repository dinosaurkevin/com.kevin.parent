package com.kevin.toolweb.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.kevin.toolweb.api.dto.AuthorityInfoReq;
import com.kevin.toolweb.security.UserAuths;
import com.kevin.toolweb.service.AuthorityInfoService;
import com.kevin.toolweb.tools.ListTreeUtils;



@Controller
public class IndexAction  {
	 
	@Autowired
	private AuthorityInfoService authorityInfoService;

	
	@UserAuths(value=111,name="1rrr",address="yuuuu")
	@RequestMapping(value="/index.htm")
	public String index(Model model, HttpServletRequest request){
		AuthorityInfoReq authorityInfoReq = new AuthorityInfoReq();
		String menu = ListTreeUtils.getAuthTree1(authorityInfoService.getAllAuthority(authorityInfoReq));
		model.addAttribute("menuStr",menu);
		return "index/index";
	}
	
	@RequestMapping(value="/getAllAuth.htm")
	public String getAllAuth(Model model, HttpServletRequest request){
		
		
		
		
		return "index/index";
	}
	
	
}
