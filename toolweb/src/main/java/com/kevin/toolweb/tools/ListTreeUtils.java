package com.kevin.toolweb.tools;  
  
import java.util.ArrayList;
import java.util.List;

import com.kevin.toolweb.api.pojo.AuthorityInfo;
import com.kevin.toolweb.constant.IconEnum;  
  
public class ListTreeUtils {  

    public static List<AuthorityInfo>  getAuthTree(List<AuthorityInfo> data) {  
    	List<AuthorityInfo> resultList = new ArrayList<AuthorityInfo>();  
        long start = System.currentTimeMillis();  
        for (AuthorityInfo authorityInfo : data) {  
            if (authorityInfo.getParentAuthId()==-1) {//父级菜单开始添加  
            	resultList.add(authorityInfo);  
                if (ifChilds(data, authorityInfo.getAuthId())) {//存在子集  
                    List<AuthorityInfo> childs = new ArrayList<AuthorityInfo>();  
                    childs = getChildList(data,authorityInfo.getAuthId(),childs);  
                    resultList.addAll(childs);  
                }  
            }  
        }  
        long end = System.currentTimeMillis();  
        System.out.println("查询后集合大小:"+resultList.size());  
        System.out.println("查询耗时:"+(end-start)+"毫秒");  
        
        return resultList;
    }  
    
    public static String  getAuthTree1(List<AuthorityInfo> data) {  
    	List<Long> lists = new ArrayList<Long>();
    	String menuStr = "";
    	StringBuilder sb = new StringBuilder("");
        for (AuthorityInfo authorityInfo : data) {  
            if (authorityInfo.getParentAuthId()==-1) {//父级菜单开始添加  
            	boolean flagifChilds = ifChilds(data, authorityInfo.getAuthId());
                 sb.append("<li class=\"\">")	
             	.append("<a href=\"#\" class=\"dropdown-toggle\">")
             	.append("<i class=\"menu-icon fa fa-list \"></i>")
             	.append("<span class=\"menu-text\">")
             	.append(authorityInfo.getAuthName())
             	.append("</span>");
                 if (flagifChilds) {//存在子集  
                	 sb.append("<b class=\"arrow fa fa-angle-down\"></b>");
                 }  
                 sb.append("</a>");
              	
            
                if (flagifChilds) {//存在子集  
          
                 sb.append("<ul class=\"submenu\">");
                    menuStr  = getChildList(data,authorityInfo.getAuthId(),sb,lists).toString();  
                  sb.append("</ul>");
                }  
                sb.append("</li>");
            }  
        }    
        return menuStr;
    }  
      
    //获取父id下的子集合  
    private static List<AuthorityInfo> getChildList(List<AuthorityInfo> list,long pId,List<AuthorityInfo> reList) { 
    
        for (AuthorityInfo authorityInfo : list) {  
            if (authorityInfo.getParentAuthId()==pId) {//查询下级菜单  
                reList.add(authorityInfo);  
                if (ifChilds(list, authorityInfo.getAuthId())) {  
                    getChildList(list, authorityInfo.getAuthId(), reList);  
                }  
            }  
        }  
        return reList;  
    }  
    
    //获取父id下的子集合  
    private static StringBuilder getChildList(List<AuthorityInfo> list,long pId,StringBuilder sb,List<Long> authFlagList) { 
    
        for (AuthorityInfo authorityInfo : list) {  
            if (authorityInfo.getParentAuthId()==pId) {//查询下级菜单  
            	boolean flagifChilds = ifChilds(list, authorityInfo.getAuthId());
            	if (flagifChilds) { 
                sb.append("<li class=\"\">")	
         	    .append("<a href=\"#\" class=\"dropdown-toggle\">")
         	    .append("<i class=\"menu-icon fa fa-caret-right \"></i>")
         	    .append(authorityInfo.getAuthName())
         	    .append("<b class=\"arrow fa fa-angle-down\"></b>")
                .append("</a>");
                sb.append("<ul class=\"submenu\">");
            	}
                if (flagifChilds) { 
                	getChildList(list, authorityInfo.getAuthId(),sb,authFlagList);  
                }else{
                	 authFlagList.add(pId);
                	 sb.append("<li class=\"\">")	
                	.append("<a href=\"")
                	.append(authorityInfo.getUrl())
                	.append("\">")
                	.append("<i class=\"menu-icon fa ").append(getIcon(authorityInfo.getUrl())).append(" \"></i>")
                	.append(authorityInfo.getAuthName())
                	.append("</a>")
                	.append("<b class=\"arrow\"></b>")
                	.append("</li>");
                }
                if (flagifChilds) { 
                	  sb.append("</ul>");	
                	  sb.append("</li>");
         	    }
            }  
        }  
        return sb;  
    }  
      
    //判断是否存在子集  
    private static boolean ifChilds(List<AuthorityInfo> list,long pId) {  
        boolean flag = false;  
        for (AuthorityInfo AuthorityInfo : list) {  
            if (AuthorityInfo.getParentAuthId()==pId) {  
                flag=true;  
                break;  
            }  
        }  
        return flag;  
    }  
    
    private static String getIcon(String url) {  
      if(url.contains(IconEnum.ADD.getCode())){
    	  return  IconEnum.ADD.getDesc();
      }else{
          return  "";  
      }
    }  
  
}  