package com.kevin.toolweb.base;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;


@SuppressWarnings("serial")
public abstract class BasePageQueryMap extends BasePageQuery {

	private Map<String, Object> paramMap;
	
	private List<String> splitKey;

	public abstract Object getQuery();

	@SuppressWarnings("unchecked")
	public Map<String, Object> getParamMap() {
		if (paramMap == null) {
			paramMap = new HashMap<String, Object>();
		}
		try {
			@SuppressWarnings("rawtypes")
			Map beanMap = null;
			if (this.getQuery() == null) {
				beanMap = new HashMap<String, Object>();
			}else {
				beanMap = PropertyUtils.describe(this.getQuery());
			}
			this.paramMap.putAll(beanMap);
			
			String key = "class";
			if (this.paramMap.containsKey(key)) {
				this.paramMap.remove(key);
			}
			
			transferWhenSplit(this.paramMap);
			return this.paramMap;
		} catch (Exception e) {
			LOG.error("查询对象转换出错！", e);
			throw new RuntimeException("查询对象转换出错！", e);
		}
	}

	/**
	 * 描述：把需要转换的参数split成list<br>
	 * 参数：@param paramMap2<br>
	 * 返回值：void<br>
	 */
	private void transferWhenSplit(Map<String, Object> map) {
		for (String temp : this.getSplitKey()) {
			if (map.containsKey(temp)) {
				if (!(map.get(temp) instanceof String)) {
					continue;
				}
				String tempVal = (String)map.get(temp);
				if (StringUtils.isBlank(tempVal)) {
					map.put(temp, null);
				}else {
					//约定，入参时用','分割
					map.put(temp, Arrays.asList(tempVal.split(",")));
				}
			}
		}
	}

	@Override
	public void setTotalCount(Integer totalCount) {
		super.setTotalCount(totalCount);
		this.getParamMap().put("pageFirstItem", super.getPageFirstItem());
		this.getParamMap().put("pageLastItem", super.getPageLastItem());
	}

	public List<String> getSplitKey() {
		if (splitKey == null) {
			splitKey = new ArrayList<String>();
		}
		return splitKey;
	}

	public void setSplitKey(List<String> splitKey) {
		this.splitKey = splitKey;
	}

}
