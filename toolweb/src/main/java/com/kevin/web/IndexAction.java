package com.kevin.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevin.web.base.BaseController;



@Controller
public class IndexAction extends BaseController {
	

	@RequestMapping(value="/index.htm")
	public String index(Model model, HttpServletRequest request){
		return "index/index";
	}
	
	
}
