package com.kevin.toolweb.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.toolweb.api.dto.AuthorityInfoReq;
import com.kevin.toolweb.api.pojo.AuthorityInfo;
import com.kevin.toolweb.security.UserAuths;
import com.kevin.toolweb.service.AuthorityInfoService;
import com.kevin.toolweb.service.dao.AuthorityInfoDAO;

@Service("authorityInfoService")
public class AuthorityInfoServiceImpl //extends BaseService 
		implements AuthorityInfoService {
	public AuthorityInfoServiceImpl(){
		
		System.out.print("++++++++++++++++++++++++++++");
	}
	
	@Autowired
	private AuthorityInfoDAO authorityInfoDAO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override
	public List<AuthorityInfo> getAllAuthority(AuthorityInfoReq authorityInfoReq){
    	return authorityInfoDAO.getAllAuthorityInfo();
	}
		

	public static void main(String[] args) {
		System.out.println("hello");  
	}
	
	
}
