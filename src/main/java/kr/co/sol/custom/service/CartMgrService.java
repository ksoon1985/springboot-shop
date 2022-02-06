package kr.co.sol.custom.service;

import java.util.Hashtable;

import kr.co.sol.shop.dto.OrderDTO;

public interface CartMgrService {

	  public void setCartList(Hashtable<Integer, OrderDTO> hCartList);
	  
	  public Hashtable<Integer, OrderDTO> getCartList() ;
	  
	  public Hashtable<Integer, OrderDTO> updateCart(OrderDTO odto);
	  
	  public Hashtable<Integer, OrderDTO> deleteCart(OrderDTO odto);
	  
	  public Hashtable<Integer, OrderDTO> addCart(OrderDTO odto);
}

