package com.project.aspect;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAspect {
	
	static Log log = LogFactory.getLog(TransactionAspect.class);
	
	DataSource dataSource;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}
	
	//스프링의 Transaction 매커니즘
	@Around("execution(public * com.project.*.service.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = tm.getTransaction(td);
		log.info("### transaction start");
		Object rtn=null;
		try {
			rtn = pjp.proceed();
			tm.commit(ts);
			log.info("### commit");
		} catch (Throwable t) {
			tm.rollback(ts);
			log.info("### rollback");
			throw t;
		} finally {
			
		}
		
		return rtn;
	}
}