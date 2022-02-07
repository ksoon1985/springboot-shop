package kr.co.sol.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

//@MapperScan(basePackages = "kr.co.sol.**.mapper")
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);
	private static final int TX_METHOD_TIMEOUT = 3;
    
	@Autowired
    private ApplicationContext applicationContext;
    
    @Bean
    public DataSourceTransactionManager transactionManager(){
    	return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean(destroyMethod = "close")
    @ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:kr/co/sol/mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:**/mapper/*Mapper.xml"));
		return sqlSessionFactory.getObject();
	}
	
	@Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public TransactionInterceptor txAdvice() {
    	TransactionInterceptor txAdvice = new TransactionInterceptor();
    	Properties txAttributes = new Properties();
    	List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
    	rollbackRules.add(new RollbackRuleAttribute(Exception.class));
    	DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED);
    	readOnlyAttribute.setReadOnly(true);
    	readOnlyAttribute.setTimeout(TX_METHOD_TIMEOUT);
        RuleBasedTransactionAttribute writeAttribute = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
        writeAttribute.setTimeout(TX_METHOD_TIMEOUT);

		String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
		String writeTransactionAttributesDefinition = writeAttribute.toString();
		LOGGER.info("Read Only Attributes :: {}", readOnlyTransactionAttributesDefinition);
		LOGGER.info("Write Attributes :: {}", writeTransactionAttributesDefinition);
		// read-only
		txAttributes.setProperty("retrieve*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("select*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("get*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("list*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("search*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("find*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("count*", readOnlyTransactionAttributesDefinition);

		// write rollback-rule
		txAttributes.setProperty("*", writeTransactionAttributesDefinition);
		txAdvice.setTransactionAttributes(txAttributes);
		txAdvice.setTransactionManager(transactionManager());
        return txAdvice;

    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("(execution(* *..*.service.impl.*ServiceImpl.*(..)) || execution(* *..*.wrapper.*Wrapper.*(..)))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice());

    }

	
 
}


