package kr.co.sol.admin.service;

import java.util.Hashtable;
import java.util.List;

import kr.co.sol.shop.dto.OrderDTO;

public interface OrderMgrService {

	List<OrderDTO> getOrders(OrderDTO odto);

	int insertOrders(Hashtable<Integer, OrderDTO> hCartList);

	int updateOrder(OrderDTO odto);

	int deleteOrder(OrderDTO odto);


}
