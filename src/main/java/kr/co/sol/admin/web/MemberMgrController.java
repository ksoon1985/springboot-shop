package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.service.AdminService;
import kr.co.sol.custom.dto.MemberDTO;

@Controller
public class MemberMgrController {
   
	@Autowired
    AdminService adminService;
    
    @RequestMapping("/mamberMgr")
    public String mamberMgr(HttpServletRequest request,
			  HttpServletResponse response,
			  MemberDTO mdto, Model model) {
    	List<MemberDTO> memberList = adminService.getMemers(mdto);
    	model.addAttribute("memberList", memberList);
    	return "admin/MemberMgr";
    }
}
