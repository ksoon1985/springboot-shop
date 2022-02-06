package kr.co.sol.common.exception.advice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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