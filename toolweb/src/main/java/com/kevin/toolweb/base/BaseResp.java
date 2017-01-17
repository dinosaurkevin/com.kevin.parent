package com.kevin.toolweb.base;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 功能说明: 响应基类<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: <br>
 * 开发时间: <br>
 */
@SuppressWarnings("serial")
public class BaseResp implements Serializable {

	private int errorNo = 0;
	private String errorInfo = "操作成功!";

	/**
	 * 对象转json，用于hsadmin使用xml配置paramJson转换成对象时对应的属性名称
	 */
	private String objectParamName;
	/**
	 * 对象转json,用于参数转json，不为空时替换param参数对象
	 */
	private String paramJson;
	/**
	 * 对象转json，用于结果转json
	 */
	private String resultJson;
	
	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.setErrorNo(errorNo, new Object[] {});
	}

	public void setErrorNo(int errorNo, Object... params) {
		this.errorNo = errorNo;
		this.setErrorInfo(getErrorInfo());
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * 判断是否出错<br>
	 * true - 出错<br>
	 * false - 未出错
	 * 
	 * @return b
	 */
	@JsonIgnore
	public boolean isError() {
		return this.errorNo != BaseErrorNoConstants.OK_SUCCESS;
	}

	/**
	 * 判断是否成功<br>
	 * true - 成功<br>
	 * false - 未成功
	 * 
	 * @return b
	 */
	@JsonIgnore
	public boolean isSuccess() {
		return !this.isError();
	}

	/**
	 * 判断是否是系统错误
	 */
	@JsonIgnore
	public boolean isSysError() {
		return this.errorNo < 0;
	}

	/**
	 * 将其他的resp转换成当前的resp
	 * 
	 * @param resp
	 */
	public void transferFrom(BaseResp resp) {
		if (resp != null) {
			this.setErrorNo(resp.getErrorNo());
			this.setErrorInfo(resp.getErrorInfo());
		} else {
			this.setErrorNo(BaseErrorNoConstants.ERR_RESP_TRANSFOR_ERR);
		}
	}

	/**
	 * 将业务异常转换成当前的resp
	 * 
	 * @param ex
	 */
	public void transferFrom(Exception ex) {
		if (ex != null) {
			this.setErrorNo(-1);
			this.setErrorInfo(ex.getMessage());
		} else {
			this.setErrorNo(BaseErrorNoConstants.ERR_RESP_TRANSFOR_ERR);
		}
	}

	public String getParamJson() {
		return paramJson;
	}

	public void setParamJson(String paramJson) {
		this.paramJson = paramJson;
	}

	public String getResultJson() {
		return resultJson;
	}

	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}
	
	public String getObjectParamName() {
		return objectParamName;
	}

	public void setObjectParamName(String objectParamName) {
		this.objectParamName = objectParamName;
	}

	// 过滤密码显示 
	public String toShowParameter() {
		return (new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE) {
			protected boolean accept(Field f) {
				return super.accept(f) && !f.getName().equals("password") && !f.getName().equals("payPwd") && !f.getName().equals("loginPwd");   
			}
		}).toString();
		
	}

}