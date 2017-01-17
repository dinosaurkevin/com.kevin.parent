package com.kevin.toolweb.service;

import java.util.List;

import com.kevin.toolweb.api.dto.AuthorityInfoReq;
import com.kevin.toolweb.api.pojo.AuthorityInfo;

public interface AuthorityInfoService {

	List<AuthorityInfo> getAllAuthority(AuthorityInfoReq authorityInfoReq);

}
