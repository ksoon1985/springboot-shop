package kr.co.sol.custom.wrapper;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.admin.service.OrderMgrService;
import kr.co.sol.admin.service.ProductMgrService;
import kr.co.sol.shop.dto.OrderDTO;

@Service
public class CustomWrapper {
	@Autowired
	private  OrderMgrService  orderMgrService;
    @Autowired
    private ProductMgrService productMgrService;
	
	public HashMap<String, String> orderProc(OrderDTO odto, 
			        Hashtable<Integer, OrderDTO> hCartList) 
			        		throws Exception{
		String url;
		String msg;
		  int r =orderMgrService.insertOrders(hCartList);
		  if(r>0) {
			  productMgrService.updateStocks(hCartList);
			  msg = "주문완료하였습니다.";
			  url="orderList";
			  hCartList=null;
		  }else {
			  msg = "주문실패했습니다.";
			  url="cartList";
		  }
		  HashMap <String, String> map = 
				   new HashMap<String, String>();
		  map.put("url", url);
		  map.put("msg", msg);
		return map;
	}
	
	   
}
