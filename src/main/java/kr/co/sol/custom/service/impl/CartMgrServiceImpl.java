package kr.co.sol.custom.service.impl;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import kr.co.sol.custom.service.CartMgrService;
import kr.co.sol.shop.dto.OrderDTO;

@Service
public class CartMgrServiceImpl implements CartMgrService{
  
 private Hashtable<Integer, OrderDTO> hCartList;
  
 public void setCartList(Hashtable<Integer, OrderDTO> hCartList) {
	this.hCartList=hCartList;
 }
  
 public Hashtable<Integer, OrderDTO> getCartList() {
      return hCartList;
  }
  
 public Hashtable<Integer, OrderDTO> updateCart(OrderDTO odto) {
	  int product_no = odto.getProduct_no();
     int quantity = odto.getQuantity();
         if (hCartList.containsKey(product_no)) {
       	  OrderDTO tempOrder = (OrderDTO) hCartList.get(product_no);
             tempOrder.setQuantity(quantity);
             hCartList.put(product_no, tempOrder);
         }
     return  hCartList;
 }
 
 public Hashtable<Integer, OrderDTO> deleteCart(OrderDTO odto) {
     int product_no = odto.getProduct_no();
     hCartList.remove(product_no);
     return  hCartList;
 }
 
  public Hashtable<Integer, OrderDTO> addCart(OrderDTO odto) {
     int product_no = odto.getProduct_no();
     int quantity = odto.getQuantity();
     if (quantity > 0) {
         if (hCartList.containsKey(product_no)) {
       	  OrderDTO tempOrder = (OrderDTO) hCartList.get(product_no);
             quantity += tempOrder.getQuantity();
             tempOrder.setQuantity(quantity);
             hCartList.put(product_no, tempOrder);
         } else {
       	  hCartList.put(product_no, odto);
         }
     }
     return  hCartList;
    }
}
