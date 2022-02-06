package kr.co.sol.custom.web;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.custom.service.CartMgrService;
import kr.co.sol.custom.service.MemberService;
import kr.co.sol.custom.wrapper.CustomWrapper;
import kr.co.sol.shop.dto.OrderDTO;

@Controller
public class CustomController {
	private static final Logger logger = LoggerFactory.getLogger(CustomController.class);

	@Autowired
	 MemberService memberService;

	@Autowired
     OrderMgrService  orderMgrService;
	
	@Autowired
	CartMgrService cartMgrService;
	
	 //트랜잭션 처리를 위해 만든 서비스
	@Autowired
	CustomWrapper customWrapper;
	
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String idKey = (String)session.getAttribute("idKey");
        session.setAttribute("idKey", idKey);
		return "Index";
	}

	@GetMapping("/register")
	public String register(HttpServletRequest request, Model model, HttpServletResponse response) {
		return "Register";
	}
	
	
	 @RequestMapping(value = "/idcheck")
	  @ResponseBody
	  public int idCheck(MemberDTO mdto, HttpServletRequest request, HttpServletResponse response,Model model ) {
		  int cnt = 0;
		  String id = mdto.getMem_id();
		  if(mdto.getMem_id()!=null) {
	 	  cnt = memberService.idCheck(id);
		  }
		  return cnt;
	  }
	 
	  @RequestMapping(value="/registerProc")
		 public String registerProc(MemberDTO mdto, 
				  HttpServletRequest request, 
				  HttpServletResponse response,
				  Model model ) {
			  //memberJoin
			//  logger.info("멤버: "+mdto.toString());
		      model.addAttribute("url", "/");
			  int r = memberService.memberJoin(mdto);
			  if(r>0)
			  model.addAttribute("msg", "회원가입 성공");//저장결과 등을 확인
			  else
			  model.addAttribute("msg", "회원가입 실패");//저장결과 등을 확인
			  //회원가입을 하면 바로 로그인이되는 사이트이면 session 저장
			  //회원가입을 하고 다시로그인 하게하려면 session 저장 없음
			return "MsgPage"; 
		 }

	  @RequestMapping(value="/login")
	  public String login() {
		  return "Login"; 
	  }
	  
	  @RequestMapping(value="/loginProc")
		 public String loginProc(MemberDTO mdto, 
				  HttpServletRequest request, 
				  HttpServletResponse response,
				  Model model ) {
		  
	      mdto=memberService.logonProc(mdto);
	      
	      HttpSession session = request.getSession();
	      
		  String mem_id= null;
		  String url="/";
		  
		  if(mdto!=null) {
			  mem_id= mdto.getMem_id();
		    if(mdto.getM_roll()!=null) {
		    	//해당 롤에 해당 메뉴로 갖고 온다
		    	//관리자인경우 해당되는 관리자용 세션 만들기
		    	session.setAttribute("adminDto", mdto);
		    	url="/admin/index";
			  }else {
				  //일반 회원정보	  
				  session.setAttribute("mdto", mdto);
			  }
		  }
		  
		  if(mem_id==null) 
			  model.addAttribute("msg", "id 또는 password 오류 입니다.");
		  
		  if(mem_id!=null) {
			  //세션객체
			  session.setAttribute("idKey", mem_id);
		  }
		  
		  session.setAttribute("url", url);
		  return "MsgPage";
		 }

	  @RequestMapping(value="/logout")
	  public String logout( HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  session.removeAttribute("idKey");
		  session.invalidate();//세션 취소, 또는 초기화
		  return "redirect:/"; 
	  }

	  
	  @RequestMapping(value="/memberUpdate")
	  public String memberUpdate( MemberDTO mdto, 
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Model model) {
		  
		  System.out.println(mdto.getMem_id());
		  
		  HttpSession session = request.getSession();
		  //세션에 저장된 객체
		  //세션에 저장된 amin의 데이터
		  MemberDTO adminDto = (MemberDTO) session.getAttribute("adminDto");
		  MemberDTO sdto = (MemberDTO) session.getAttribute("mdto");
		  //amin에서 들어온 경우 해당 id를 보내야 됨
		  //service 호출
		  if(mdto.getMem_id()==null) mdto=sdto;
		   mdto = memberService.memberSelect(mdto);
		   // 받은 정보 저장하고 (모델)
		   model.addAttribute("mdto",mdto);
//		   if(adminDto!=null)
//		   System.out.println("adminDto==>"+adminDto.toString());
           session.setAttribute("adminDto", adminDto);
		   session.setAttribute("mdto", mdto); //
		   session.setAttribute("idKey", mdto.getMem_id()); //
		  return "Update"; 
	  }
	  
	  @RequestMapping(value="/memberUpdateProc")
	  public String memberUpdateProc( MemberDTO mdto, 
			  HttpServletRequest request, 
			  HttpServletResponse response,
			  Model model) {
		  HttpSession session = request.getSession();
		  //일반 회원에서 들어오는 경우 처리
		  //세션에 저장된 객체
	      MemberDTO sdto = (MemberDTO) session.getAttribute("mdto");
	      MemberDTO adminDto = (MemberDTO) session.getAttribute("adminDto");
		  //service 호출
			  // 받은 정보 DB저장
		  int r= memberService.memberUpdate(mdto);
		  //메시지 저장, 이동할 페이지 저장해서 
		   if(r>0) {model.addAttribute("msg", "회원정보수정완료");
		   }else {
			   model.addAttribute("msg", "회원정보수정실패");
		   }
		   if(sdto.getM_roll()==null) {
			   model.addAttribute("url","/");
		   }
		   if(adminDto!=null) {
			   model.addAttribute("url","/mamberMgr");
		   }
		   session.setAttribute("mdto", mdto);
		   session.setAttribute("idKey", mdto.getMem_id());
		   session.setAttribute("adminDto", adminDto);
		  return "MsgPage"; 
	  } 
	
	  @RequestMapping(value="/idCheck")
		public String idCheck(HttpServletRequest request) {
		     HttpSession session = request.getSession();
		     session.setAttribute("mdto", (MemberDTO)session.getAttribute("mdto"));
			return "idCheck";
		}
		
	  @RequestMapping(value="/memberDelete")
	  public String memberDelete(HttpServletRequest request,
			  MemberDTO mdto, Model model) {
		   HttpSession session = request.getSession();
		   MemberDTO adminDto = (MemberDTO) session.getAttribute("adminDto");
		     int r= memberService.memberDelete(mdto);
		     
			 //메시지 저장, 이동할 페이지 저장해서 
			   if(r>0) {
				   model.addAttribute("msg", "회원탈퇴완료");
				   
			   }else {
				   model.addAttribute("msg", "회원탈퇴실패");
			   }
			   if(adminDto==null && mdto.getM_roll()==null) {
				   model.addAttribute("url","/");
				   session.removeAttribute("mdto");
				   session.invalidate();
			   }
			   if(adminDto!=null) {
				   model.addAttribute("url","/mamberMgr");
				   session.setAttribute("adminDto", adminDto);
			   }
		   
		  return "MsgPage";
	  }
	  
	  
	  @RequestMapping(value="/orderList")
	  public String orderList(HttpServletRequest request,
			 Model model) {
		  HttpSession session = request.getSession(true);
		  String idKey = (String) session.getAttribute("idKey");
		  OrderDTO odto = new OrderDTO();
		  odto.setId(idKey);
		  List<OrderDTO> odtoList
		     = orderMgrService.getOrders(odto);
		  model.addAttribute("orderList", odtoList);
		  session.setAttribute("idKey", idKey);
		  return "OrderList";
	  }
	  
	  @RequestMapping(value="/orderProc")
	  //@Transactional
	  public String orderProc(HttpServletRequest request,
			  OrderDTO odto,
			  Model model) throws Exception{
		  HttpSession session = request.getSession(true);
		  String idKey = (String) session.getAttribute("idKey");
		  odto.setId(idKey);
		  Hashtable<Integer, OrderDTO> hCartList 
		      = cartMgrService.getCartList();
		  //sate는 1~6까지 부여 
		  //1:접수중, 2:접수, 3:입금확인, 4: 배송준비
		  //5:배송중, 6:완료
		  HashMap<String, String> map 
		      = customWrapper.orderProc(odto, hCartList);
		  
		  model.addAttribute("url", map.get("url"));
		  model.addAttribute("msg", map.get("msg"));
		  session.setAttribute("idKey", idKey);
		  return "MsgPage";
	  }
	  
	  
}
