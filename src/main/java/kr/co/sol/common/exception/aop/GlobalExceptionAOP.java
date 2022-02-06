package kr.co.sol.common.exception.aop;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

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