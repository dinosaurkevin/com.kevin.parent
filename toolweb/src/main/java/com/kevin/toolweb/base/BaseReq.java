package com.kevin.toolweb.base;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;




@SuppressWarnings("serial")
public class BaseReq implements Serializable {

	/**
	 * 对象转json，用于hsadmin使用xml配置paramJson转换成对象时对应的属性名称
	 */
	private String objectParamName;
	/**
	 * 对象转json，不为空时替换param参数对象
	 */
	private String paramJson;
	
	
	private String tokenKey;
	private String tokenValue;


	public String getParamJson() {
		return paramJson;
	}

	public void setParamJson(String paramJson) {
		this.paramJson = paramJson;
	}

	public String getObjectParamName() {
		return objectParamName;
	}

	public void setObjectParamName(String objectParamName) {
		this.objectParamName = objectParamName;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}
	

	
}