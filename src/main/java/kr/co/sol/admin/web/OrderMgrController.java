package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.shop.dto.OrderDTO;

@Controller
public class OrderMgrController {

  @Autowired
  OrderMgrService  orderMgrService;
	
   @RequestMapping(value="/orderMgr")
   public String oderMgr(HttpServletRequest request,
			  HttpServletResponse response,
			  OrderDTO odto, Model model) {
	    List<OrderDTO> orderList= 
	    		orderMgrService.getOrders(odto);
	    
	    model.addAttribute("orderList", orderList);
	   return "admin/OrderMgr";
   }
   
   
   @RequestMapping(value="/orderDetail")
   public String orderDetail(HttpServletRequest request,
		   HttpServletResponse response,
		   OrderDTO odto, Model model) {
	   String page=null;
	   HttpSession session = request.getSession();
	   MemberDTO adminDto= 
			   (MemberDTO) session.getAttribute("adminDto");
	   
	   MemberDTO mdto= 
			   (MemberDTO) session.getAttribute("mdto");
	   if(adminDto!=null) {
		   page = "admin/OrderDetail";
	   }
	   else if(mdto !=null && mdto.getM_roll()==null){
		   page = "OrderDetail";
	   }
	   List<OrderDTO> orderList= 
			   orderMgrService.getOrders(odto);
	   model.addAttribute("odto", orderList.get(0));
	   
	   return page;
   }
   
   @RequestMapping(value="/adminOrderProc")
   public String orderProc(HttpServletRequest request,
		   OrderDTO odto, Model model) {
	   HttpSession session = request.getSession();
	   MemberDTO adminDto= 
			   (MemberDTO) session.getAttribute("adminDto");
	   //수정이냐 삭제냐.. 구분
	    String flag = request.getParameter("flag");
	   String url = null; 
	   String msg = null;
	   int r=0;
	   if("U".equals(flag)) {
	   //수정일 때
	    r = orderMgrService.updateOrder(odto);
	   } else if("D".equals(flag)) {
		   //삭제일 때
	    r = orderMgrService.deleteOrder(odto);  
	   }
	   if(r>0) {
          msg="수정 또는 삭제 완료";
		  url  = "/orderMgr";
	   }else {
		  msg="수정 또는 삭제실패";
		  url  = "/orderMgr";
	   }
	   session.setAttribute("adminDto", adminDto);
	   model.addAttribute("msg", msg);
	   model.addAttribute("url", url);
	   return "MsgPage";
   }
}
