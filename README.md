# springboot-shop

springboot basic shopping mall project (maven)


## structure

* src.main.java.kr.co.sol
  * SpringbootShopApplication  
  * admin
    * dao - AdminDAO, OrderMgrDAO, ProductMgrDAO
    * dto - AdminDTO
    * service - AdminService, OrderService, ProductMgrService
      * impl - AdminServiceImpl, OrderServiceImpl, ProductMgrServiceImpl
    * web - AdminController, MemberMgrController, OrderMgrController, ProductMgrController
  
  * common
    * dto - ZipcodeDTO
    * exception
      * advice - GlobalExceptionAdvice
      * aop - GlobalExceptionAOP
    * handler - ShopGlobalExceptionHandler
    * web - ZipSercheController
    * ServletUpload
    * WebConfig 
    * DatabaseConfig
    
  * custom
    * dao - MemberDAO
    * dto - MemberDTO
    * service - CartMgrService, MemberService
      * impl - CartMgrServiceImpl, MemberServiceImpl
    * web - CartMgrController, CustomController
    * wrapper - CustomWrapper
  
  * shop
    * dto - OrderDTO, ProductDTO
  
* src.main.resources
  * application.properties
  * logback.xml
  * kr.co.sol
    * mybatis-config.xml
    * admin.mapper - AdminMapper.xml, MemberMgrMapper.xml, OrderMgrMapper.xml, ProductMgrMapper.xml
    * custom.mapper - MemberMappler.xml
  
* src.main.webapp
  * css
  * data - image
  * js
  * WEB-INF
    * views
  

## setting
* pom.xml
* application.properties
* mybatis-config.xml
* logback.xml

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>kr.co.sol</groupId>
	<artifactId>shop</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>springboot-shop</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<!-- spring web -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- spring web services -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web-services</artifactId>
		</dependency>
		<!-- mybatis -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.2.2</version>
		</dependency>
			
		<!-- devtools -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<!-- oracle -->
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
		<!-- lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<!-- jsp, jstl -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		
		<!-- aspectj start -->
		<dependency>
		    <groupId>org.aspectj</groupId>
		    <artifactId>aspectjrt</artifactId>
		    <version>1.9.4</version>
		</dependency>
		<dependency>
		    <groupId>org.aspectj</groupId>
		    <artifactId>aspectjweaver</artifactId>
		    <version>1.9.4</version>
		</dependency>
		<dependency>
		    <groupId>org.aspectj</groupId>
		    <artifactId>aspectjtools</artifactId>
		    <version>1.9.4</version>
		</dependency>
		
		<!-- Logback -->
	    <dependency>
	    	<groupId>ch.qos.logback</groupId>
	    	<artifactId>logback-classic</artifactId>
	    	<version>1.2.3</version>
	    </dependency>
	    <dependency>
	    	<groupId>ch.qos.logback</groupId>
	    	<artifactId>logback-core</artifactId>
	    	<version>1.2.3</version>
	    </dependency>
	    <!-- append -->    
		<dependency>
			<groupId>org.bgee.log4jdbc-log4j2</groupId>
			<artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
			<version>1.16</version>
		</dependency>
		
		<!-- by upload start -->
		<dependency>
		    <groupId>commons-io</groupId>
		    <artifactId>commons-io</artifactId>
		    <version>2.7</version>
		</dependency>
		<dependency>
	       <groupId>javax.validation</groupId>
	       <artifactId>validation-api</artifactId>
	       <version>1.1.0.Final</version>
	       <scope>runtime</scope>
		</dependency>
		<dependency> 
		   <groupId>servlets.com</groupId>
		   <artifactId>cos</artifactId>
		   <version>05Nov2002</version>
		</dependency>
		
		<!-- session -->
		<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-core</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

### application.properties

```

## server setting
server.port = 9999
server.servlet.context-path=/
server.servlet.timeout=30m
# ?????? ???????????? ?????? ??????
server.servlet.session.persistent=false

## fileupload path 
# @Value("${resources.location}")??? ????????? 
resources.location=C:/study/upload/ 
resources.uri_path=/upload

## db
spring.datasource.username= username
spring.datasource.password= password
spring.datasource.url= jdbc:log4jdbc:oracle:thin:ip:port:xe
spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy

## logging append
#logging.level.jdbc.sqlonly=INFO
#logging.level.org.springframework.web=INFO
#logging.level.com.zaxxer.hikari.HikariDataSource: INFO

## viewResolver
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

## jsp ????????? ???????????? 
server.servlet.jsp.init-parameters.development=true

## banner mode
spring.main.banner-mode=off

## dto ??????
mybatis.type-aliases-package=kr.co.sol.custom.dto, kr.co.sol.shop.dto, kr.co.sol.admin.dto

## mapper ??????
mybatis.config-location=classpath:/kr/co/sol/mybatis-config.xml
mybatis.mapper-locations=classpath:**/mapper/*Mapper.xml
logging.level.net.chndol.study.mybatissample.mapper=INFO


```

### logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="30 seconds">
    <appender name="ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>C:\Users\kwons\Desktop\study\log\springboot-shop\dailylog\boardLog.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>C:\Users\kwons\Desktop\study\log\springboot-shop\dailylog\boardLog-%d{yyyy-MM-dd}.%i.log.zip</fileNamePattern>
            <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <!-- or whenever the file size reaches 100MB -->
                <maxFileSize>100MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>%d{HH:mm:ss.SSS} [%-5level] - %msg%n</Pattern>
        </layout>
    </appender>
    
    <!-- Loggers -->
    <logger name="org.apache.catalina" level="ERROR">
    </logger>
    
    <logger name="org.apache.commons" level="ERROR">
    </logger>
    
    <logger name="org.springframework" level="info" >
    </logger>
    
    <logger name="java.sql" level="ERROR">
    </logger>
    
     <logger name="org.springframework.boot.autoconfigure.logging" level="INFO">
     </logger>
    <logger name="org.mybatis.spring" level="INFO">
    </logger>
    
    <root level="INFO">
       <appender-ref ref="ROLLING"/>
       <appender-ref ref="STDOUT" />
    </root>

</configuration>

```

### mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
   <settings>
      <setting name="cacheEnabled" value="false" />
      <setting name="useGeneratedKeys" value="true" />
      <setting name="defaultExecutorType" value="REUSE" />
   </settings>
   <!-- aliaes -->
   <typeAliases>
      <typeAlias alias="hashMap" type="java.util.HashMap" />
      <typeAlias alias="list" type="java.util.List" />
      <typeAlias alias="map" type="java.util.Map" />
      <typeAlias alias="string" type="java.lang.String" />
      
      <typeAlias alias="mdto"    type="kr.co.sol.custom.dto.MemberDTO" />
      <typeAlias alias="pdto"    type="kr.co.sol.shop.dto.ProductDTO" />
      <typeAlias alias="odto"    type="kr.co.sol.shop.dto.OrderDTO" />
      <typeAlias alias="adto"    type="kr.co.sol.admin.dto.AdminDTO" />
   </typeAliases>
</configuration>
```

## etc
* WebConfig
* GlobalExceptionAdvice
* GlobalExceptionAOP
* DatabaseConfig

### WebConfig.java
???????????? ????????? ????????? ???  
ex) ./upload/onion.png -> localhost:9999/upload/onion.png -> file:///C:/study/upload/onion.png
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.uri_path}")
    private String resourcesUriPath;
    
	/*
    	addResourceHandlers :
    		'????????? ??????' ??? '???????????? ??????'?????? ?????????
    		ResourceHandlerRegistry ??? ?????? 
    		????????? ????????? ??? ???????????? ????????? url ?????? 
    */
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//?????? ????????? ????????? ?????? ??????(shop) ????????? file:///??? ??????
    	registry.addResourceHandler(resourcesUriPath + "/**")  //   /upload/**
    	.addResourceLocations("file:///" + resourcesLocation); //   file:///C:/study/upload

    }

}
```

### GlobalExceptionAdvice.java
???????????? ???????????? ????????? ?????? ?????? (AOP ??????)
```java
// @ControllerAdvice : ?????? Controller, ??? ???????????? ???????????? ????????? ?????? ??????????????? ???????????????
@ControllerAdvice
public class GlobalExceptionAdvice {
	// @ExceptionHandler : ????????? ?????????????????? ?????? ?????? 
	@ExceptionHandler(Exception.class)
	public String exeptionHandler(Model model, Exception e) {
		System.out.println("GlobalExceptionAdvice ?????? ");
		model.addAttribute("erMsg", "Handdler: "+e.getMessage());
		return "error/Error";
	}
}
```

### GlobalExceptionAOP.java
Exception ?????? AOP  
?????? GlobalExceptionAdvice??? ??? ???????????? ????????????. 

```java
@Component
@Aspect
public class GlobalExceptionAOP {

	// ??????????????? ?????? ???????????? ?????? ????????? ?????????????????? ?????? 
	@Around("execution(public String kr.co.sol..*Controller.*(..))")
    public String around(ProceedingJoinPoint pjp) {

    	System.out.println("GlobalExceptionAOP start");
		ModelAndView mav = null;
        String view = "error/Error";
        try {
        	// proceed ????????? : ???????????? ?????? ??? , ?????? ??? : ???????????? ?????? ??? 
        	// return : Object(???????????? ?????? ????????? ??? ?????? ???, or null)
             view = (String) pjp.proceed();
        } catch(Exception e){
            mav = new ModelAndView();
            e.printStackTrace();
            Map<String, Object> result = new HashMap<String, Object>();
 
            result.put("erCd", e.getCause());
            result.put("erMsg", e.getMessage());
            
            mav.addAllObjects(result);
            mav.addObject("view", view);
        } catch (Throwable e) {
            mav = new ModelAndView();
            System.out.println("2222 "+view);
            e.printStackTrace();
            Map<String, Object> result = new HashMap<String, Object>();
 
            result.put("erCd", 0);
            result.put("erMsg", e.getMessage());
            mav.addAllObjects(result);
          }
        System.out.println("GlobalExceptionAOP end");
        return view;
    }
}
```

### DatabaseConfig.java
Db transaction, mybatis ?????? 
```java

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

```


## ????????? ?????? ?????? ?????????

### mapper.xml, mybatis-config.xml ??????
```
classpath:/kr/co/sol/mybatis-config.xml  
classpath:**/mapper/*Mapper.xml
```
src.main.java??? ????????? ??? ???????????? ???????????? ????????? ??????!  
-> src.main.resources ????????? ?????? ????????????  
(?????? ???????????? ??? ??? src.main.java ?????? ????????? ?????? ??????????? -- ??? ??????????????? ? )

### DatabaseConfig.java ?????? 
* @MapperScan(basePackages = "kr.co.sol.**.mapper")

??? ?????????????????? ????????? ???????????? ???????????? ???????????? ?????????...  
ex) Field adminDao in kr.co.sol.admin.service.impl.AdminServiceImpl required a bean of type 'kr.co.sol.admin.dao.AdminDAO' that could not be found.  

-> ??????????????? ?????? ????????? ????????? ?????? ?????? (????????? ?????? ??????)

* ???????????? ?????? 

???????????? ????????? ???????????? ????????? ??? ???????????? ?????? ??????  
????????? ???????????? ????????? ?????? ??????  
```java
@Autowired
private DataSourceTransactionManager transactionManager;
// ->
@Bean
public DataSourceTransactionManager transactionManager(){
    return new DataSourceTransactionManager(dataSource());
}
```
