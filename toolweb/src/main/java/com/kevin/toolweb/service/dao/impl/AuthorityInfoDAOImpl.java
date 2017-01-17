package com.kevin.toolweb.service.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kevin.toolweb.api.pojo.AuthorityInfo;
import com.kevin.toolweb.base.BaseDAO;
import com.kevin.toolweb.service.dao.AuthorityInfoDAO;



@Service("authorityInfoDAO")	
public class AuthorityInfoDAOImpl  extends BaseDAO implements AuthorityInfoDAO{
	private static final String SQLMAP_SPACE = NAMESPACE_PRE + "AUTHORITY_INFO.";
	public List<AuthorityInfo> getAllAuthorityInfo(){
		return getSqlSession().selectList(SQLMAP_SPACE+"getAllAuthorityInfo");
	}
}