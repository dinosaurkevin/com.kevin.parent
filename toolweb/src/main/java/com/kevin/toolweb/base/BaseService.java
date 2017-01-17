package com.kevin.toolweb.base;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;


public abstract class BaseService {

	protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);
	@Autowired
	private TransactionTemplate transactionTemplate;
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
}
