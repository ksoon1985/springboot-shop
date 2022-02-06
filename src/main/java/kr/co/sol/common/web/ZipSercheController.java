package kr.co.sol.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.common.dto.ZipcodeDTO;

@Controller
public class ZipSercheController {
	
	@RequestMapping("/zipCheck")
	public String zipCheck(ZipcodeDTO zdto, HttpServletRequest request, HttpServletResponse response) {
		
		return "ZipCheck";
	}
	

}
