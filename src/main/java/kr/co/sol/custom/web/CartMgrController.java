package kr.co.sol.custom.web;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sol.custom.service.CartMgrService;
import kr.co.sol.shop.dto.OrderDTO;

@Controller
public class CartMgrController {
	@Autowired
	CartMgrService cartMgrService;
	
	@RequestMapping(value="/cartList")
	public String cartList(HttpServletRequest request,
			  HttpServletResponse response,
			  OrderDTO odto, Model model) {
		HttpSession session = request.getSession(true);
		Hashtable<Integer, OrderDTO> hCartList = 
			 (Hashtable<Integer, OrderDTO>)session.getAttribute("hCartList");
		//연습용
		/*Hashtable<Integer, OrderDTO> hCartList =new Hashtable<Integer, OrderDTO>();
		OrderDTO or = new OrderDTO();
		or.setId("m1234");
		or.setNo(1);
		or.setProduct_no(1);
		or.setMname("나그네");
		or.setPrice(10000);
		or.setOr_date("20/07/14");
		or.setQuantity(2);
		or.setPname("모자");
        hCartList.put(1, or);
        hCartList.put(2, or);
           */
		if(hCartList==null || hCartList.size()==0) {
			hCartList = new Hashtable<Integer, OrderDTO>();
		}
		session.setAttribute("hCartList", hCartList);
		return "CartList";
	}
	
	@RequestMapping(value="/cartProc")
	public String cartProc(HttpServletRequest request,
			HttpServletResponse response,
			OrderDTO odto, Model model) {
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession(true);
		Hashtable<Integer, OrderDTO> hCartList  = 
				(Hashtable<Integer, OrderDTO> ) session.getAttribute("hCartList");
		String idKey = (String) session.getAttribute("idKey");
		if(hCartList==null ) 
			hCartList = new Hashtable<Integer, OrderDTO>();
		System.out.println(request.getParameter("flag"));
		//해당 장바구니 내용을 저장 해 두기
		 cartMgrService.setCartList(hCartList);
		//해시테이블 이용한 CRUD
		 odto.setId(idKey);
		if("add".equals(flag)) {
			hCartList = cartMgrService.addCart(odto);
		}else if("update".equals(flag)) {
			hCartList= cartMgrService.updateCart(odto);
		}else if("delete".equals(flag)) {
			hCartList=cartMgrService.deleteCart(odto);
		}
		session.setAttribute("hCartList", hCartList);
		session.setAttribute("idKey", idKey);
		return "CartList";
	}
	
	
	
}
