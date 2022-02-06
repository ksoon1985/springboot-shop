package kr.co.sol.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.service.ProductMgrService;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.custom.web.CustomController;
import kr.co.sol.shop.dto.ProductDTO;

@Controller
public class ProductMgrController {
	private static final Logger logger = LoggerFactory.getLogger(CustomController.class);
    @Autowired
    ProductMgrService productMgrService;
    //업로드 경로 주입
    @Value("${resources.location}")
     String resourcesLocation;
  
	 @RequestMapping("/productMgr")
	 public String productMgr(HttpServletRequest request, HttpServletResponse response,
			  ProductDTO pdto, Model model) {
		 List<ProductDTO> pdtoList = productMgrService.getProducts(pdto);
		 model.addAttribute("pdtoList", pdtoList);
		return "admin/ProductMgr";
		 
	 }
	 
	 @RequestMapping("/productInsert")
	 public String productInsert() {
		 return "admin/ProductInsert";
	 }
	 
	 @RequestMapping("/productMgrProc")
		public String productInsert(
				HttpServletRequest request, @RequestParam("image2") MultipartFile file,
			 HttpServletResponse response,
			 ProductDTO pdto, Model model) {
		 HttpSession session = request.getSession();
		 MemberDTO adminDto= (MemberDTO) session.getAttribute("adminDto");
		 int r = 0;
		  String flag = request.getParameter("flag");
		  String msg=null;
		  String url=null;
		  if(flag.equals("insert")) {//등록
			  pdto.setPath(resourcesLocation);
		     r = productMgrService.insertProduct(pdto, file);
		     if(r>0) {
			   msg="상품등록성공";
		       url="/productMgr";
		     } else {
			    msg="상품등록성공실패";
			    url="/";
		     }
		 } else if(flag.equals("update")) {
			  pdto.setPath(resourcesLocation); 
			  r = productMgrService.updatetProduct(pdto, file);
		      if(r>0) {
			   msg="상품수정성공";
		       url="/productMgr";
		      } else {
			    msg="상품수정실패";
			    url="/";
		      }
		  }
		 model.addAttribute("msg", msg);
		 model.addAttribute("url",url);
		 session.setAttribute("adminDto", adminDto);
		 return "MsgPage";
	 }
	 
	 @RequestMapping("/productMgrProcDelete")
		public String productMgrProcDelete(
				HttpServletRequest request,
			 HttpServletResponse response,
			 ProductDTO pdto, Model model) {
		 HttpSession session = request.getSession();
		 MemberDTO adminDto= (MemberDTO) session.getAttribute("adminDto");
		 int r = 0;
		  String flag = request.getParameter("flag");
		  String msg=null;
		  String url=null;
		  if(flag.equals("delete")) {
			  r = productMgrService.deleteProduct(pdto);
		      if(r>0) {
			   msg="상품수정성공";
		       url="/productMgr";
		      } else {
			    msg="상품수정실패";
			    url="/";
		      }
		  }
		 model.addAttribute("msg", msg);
		 model.addAttribute("url",url);
		 session.setAttribute("adminDto", adminDto);
		 return "MsgPage";
	 }
	 
	 
	 @RequestMapping(value = "/productDetail")
	 public String productDetail(HttpServletRequest request,
			  HttpServletResponse response,
			  ProductDTO pdto, Model model) {
		 List<ProductDTO> pdto2= productMgrService.getProducts(pdto);
		 model.addAttribute("pdto", pdto2.get(0));
		 HttpSession session = request.getSession();
		 if(session.getAttribute("idKey")!=null)
		    session.setAttribute("idKey", session.getAttribute("idKey"));
		 if(session.getAttribute("adminDto")!=null) {
			 session.setAttribute("adminDto", session.getAttribute("adminDto"));  
		 }
		 String  customYn=null;
		 if(request.getParameter("custom")!=null) {
		      customYn= request.getParameter("custom").trim();
		 }
		 if(customYn!=null && request.getParameter("custom").equals("YES"))
		    {
			 return "ProductDetail";
		    }
		 else {
		     return "admin/ProductDetail";
		     }
	 }
	 
	 @RequestMapping(value = "/productUpdate")
	 public String productUpdate(HttpServletRequest request,
			 HttpServletResponse response,
			 ProductDTO pdto, Model model) {
		 
		 List<ProductDTO> pdto2= productMgrService.getProducts(pdto);
		 model.addAttribute("pdto", pdto2.get(0));
		 return "admin/ProductUpdate";
	 }
	 
	 //사용자 용 product
	 @RequestMapping("/productList")
	 public String productList(HttpServletRequest request,
			  HttpServletResponse response,
			  ProductDTO pdto, Model model) {
		 List<ProductDTO> pdtoList = productMgrService.getProducts(pdto);
		 model.addAttribute("pdtoList", pdtoList);
		 return "ProductList";
	 }
}
