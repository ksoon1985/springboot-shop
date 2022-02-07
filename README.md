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
# 서버 재실행시 세션 정리
server.servlet.session.persistent=false

## fileupload path 
# @Value("${resources.location}")로 불러옴 
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

## jsp 변경시 바로적용 
server.servlet.jsp.init-parameters.development=true

## banner mode
spring.main.banner-mode=off

## dto 위치
mybatis.type-aliases-package=kr.co.sol.custom.dto, kr.co.sol.shop.dto, kr.co.sol.admin.dto

## mapper 위치
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

### WebConfig.java
업로드한 이미지 로딩할 때  
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
    		'리소스 등록' 및 '핸들러를 관리'하는 객체인
    		ResourceHandlerRegistry 를 통해 
    		리소스 위치와 이 리소스와 매칭될 url 등록 
    */
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//외부 경로는 서버가 아닌 경로(shop) 일때는 file:///이 필요
    	registry.addResourceHandler(resourcesUriPath + "/**")  //   /upload/**
    	.addResourceLocations("file:///" + resourcesLocation); //   file:///C:/study/upload

    }

}
```

### GlobalExceptionAdvice.java
전역에서 발생하는 예외를 잡아 처리 
```java
// @ControllerAdvice : 모든 Controller, 즉 전역에서 발생하는 예외를 잡아 처리해주는 애노테이션
@ControllerAdvice
public class GlobalExceptionAdvice {
	// @ExceptionHandler : 한개의 클래스에서도 사용 가능 
	@ExceptionHandler(Exception.class)
	public String exeptionHandler(Model model, Exception e) {
		System.out.println("GlobalExceptionAdvice 호출 ");
		model.addAttribute("erMsg", "Handdler: "+e.getMessage());
		return "error/Error";
	}
}
```

### GlobalExceptionAOP.java
Exception 처리 AOP 
```java
@Component
@Aspect
public class GlobalExceptionAOP {

	// 핵심코드의 어느 부분까지 공통 기능을 사용하겠다고 명시 
	@Around("execution(public String kr.co.sol..*Controller.*(..))")
    public String around(ProceedingJoinPoint pjp) {

    	System.out.println("GlobalExceptionAOP start");
		ModelAndView mav = null;
        String view = "error/Error";
        try {
        	// proceed 호출전 : 비즈니스 호출 전 , 호출 후 : 비즈니스 호출 후 
        	// return : Object(비즈니스 에서 실행한 후 결과 값, or null)
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
