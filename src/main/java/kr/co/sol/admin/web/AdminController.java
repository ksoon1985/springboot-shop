package kr.co.sol.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.admin.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
//logger.
	@RequestMapping("/admin/index")
	public String adminLogin(HttpServletRequest request,
			  HttpServletResponse response,Model model,
			  AdminDTO adto) {
		return "admin/Index";
	}
	
//	@RequestMapping("/adloginProc")
//	public String adloginProc(HttpServletRequest request,
//			HttpServletResponse response,
//			AdminDTO adto) {
//		//받아온 id와 password를 갖기고 로그인 처리하기
//	   String adminIdKey = adminService.logon(adto);
//		//세션에저장하기
//	   HttpSession session = request.getSession();
//	   session.setAttribute("adminIdKey", adminIdKey);
//		return "admin/Index";
//	}

}
