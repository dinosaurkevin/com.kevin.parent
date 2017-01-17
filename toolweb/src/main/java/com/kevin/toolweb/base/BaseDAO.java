package com.kevin.toolweb.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;


public class BaseDAO extends SqlSessionDaoSupport {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BaseDAO.class);
	
	protected static final String NAMESPACE_PRE = "mybatis.mysql.";
	@Lazy
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
	    super.setSqlSessionFactory(sqlSessionFactory);
	}

	protected final BasePageQuery getPagination(BasePageQuery query,
			String qTotalCount, String qPagination) {
		if (logger.isDebugEnabled()) {
			logger.debug("getPagination(BasePageQuery, String, String) - start");
		}
		int totalCount = ((Integer) getSqlSession().selectOne(
				qTotalCount, query)).intValue();
		query.setTotalCount(Integer.valueOf(totalCount));
		if (totalCount > 0) {
			@SuppressWarnings({ "rawtypes" })
			List items = getSqlSession().selectList(qPagination,
					query);
			try {
				// 约定，每个query对象中必须定义成员变量"items"
				FieldUtils.writeField(query, "items", items, true);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getPagination(BasePageQuery, String, String) - end");
		}
		return query;
	}
	
	public BaseResp mysqlBulkLoad() {
		BaseResp baseResp = new BaseResp();
		return baseResp;
	}
	
	public BaseResp oracleSqlldr() {
		BaseResp baseResp = new BaseResp();
		return baseResp;
	}
	
	public BaseResp oracleExportTxt() {
		BaseResp baseResp = new BaseResp();
		return baseResp;
	}
}
