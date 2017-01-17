package com.kevin.toolweb.constant;


public enum IconEnum {
     ADD("add","fa-plus");
	
	
	
	


	IconEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	
	private String code;
	private String desc;
	
	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
