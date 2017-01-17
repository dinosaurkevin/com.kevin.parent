package com.kevin.toolweb.api.pojo;



import java.io.Serializable;

public class AuthorityInfo implements Serializable {

	private static final long serialVersionUID = -4706466732136695841L;

	private Long authId;

	    private String authCode; //权限编号

		public String getAuthLevel() {
			return authLevel;
		}

		public void setAuthLevel(String authLevel) {
			this.authLevel = authLevel;
		}

		public Long getParentAuthId() {
			return parentAuthId;
		}

		public void setParentAuthId(Long parentAuthId) {
			this.parentAuthId = parentAuthId;
		}

		public String getSubSystemCode() {
			return subSystemCode;
		}

		private String authName; //权限名称
		
		private String authLevel; //权限层数

	    private Integer functionNo;

	    private String url;//访问url

	    private String authType;//权限类型

	    private String authStatus;

	    private Integer sortNum;//排序值

	    private String openType;//打开方式
	    
	    private String subSystemCode;//所属子系统代码

	    private Long parentAuthId;
	    
	    private String sysRoleCode; //默认系统角色
		  public String getSysRoleCode() {
			return sysRoleCode;
		}

		public void setSysRoleCode(String sysRoleCode) {
			this.sysRoleCode = sysRoleCode;
		}

		private String memCode;

	    public String getMemCode() {
			return memCode;
		}

		public void setMemCode(String memCode) {
			this.memCode = memCode;
		}

		private String remark1;

	    private Long gmtCreate;

	    private Long gmtModify;

	    private String reserve1;

	    private String parentCode;//父类CODE
	    
	  
	    public Long getAuthId() {
	        return authId;
	    }

	    public void setAuthId(Long authId) {
	        this.authId = authId;
	    }

	    public String getAuthCode() {
	        return authCode;
	    }

	    public void setAuthCode(String authCode) {
	        this.authCode = authCode == null ? null : authCode.trim();
	    }

	    public String getAuthName() {
	        return authName;
	    }

	    public void setAuthName(String authName) {
	        this.authName = authName == null ? null : authName.trim();
	    }

	    public Integer getFunctionNo() {
	        return functionNo;
	    }

	    public void setFunctionNo(Integer functionNo) {
	        this.functionNo = functionNo;
	    }

	    public String getUrl() {
	        return url;
	    }

	    public void setUrl(String url) {
	        this.url = url == null ? null : url.trim();
	    }

	    public String getAuthType() {
	        return authType;
	    }

	    public void setAuthType(String authType) {
	        this.authType = authType == null ? null : authType.trim();
	    }

	    public String getAuthStatus() {
	        return authStatus;
	    }

	    public void setAuthStatus(String authStatus) {
	        this.authStatus = authStatus == null ? null : authStatus.trim();
	    }

	    public Integer getSortNum() {
	        return sortNum;
	    }

	    public void setSortNum(Integer sortNum) {
	        this.sortNum = sortNum;
	    }

	    public String getOpenType() {
	        return openType;
	    }

	    public void setOpenType(String openType) {
	        this.openType = openType == null ? null : openType.trim();
	    }

	    public void setSubSystemCode(String subSystemCode) {
	        this.subSystemCode = subSystemCode == null ? null : subSystemCode.trim();
	    }

	    public String getRemark1() {
	        return remark1;
	    }

	    public void setRemark1(String remark1) {
	        this.remark1 = remark1 == null ? null : remark1.trim();
	    }

	    public Long getGmtCreate() {
			return gmtCreate;
		}

		public void setGmtCreate(Long gmtCreate) {
			this.gmtCreate = gmtCreate;
		}

		public Long getGmtModify() {
			return gmtModify;
		}

		public void setGmtModify(Long gmtModify) {
			this.gmtModify = gmtModify;
		}

		public String getReserve1() {
	        return reserve1;
	    }

	    public void setReserve1(String reserve1) {
	        this.reserve1 = reserve1 == null ? null : reserve1.trim();
	    }

	    public String getParentCode() {
	        return parentCode;
	    }

	    public void setParentCode(String parentCode) {
	        this.parentCode = parentCode == null ? null : parentCode.trim();
	    }
}
