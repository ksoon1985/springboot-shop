package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.shop.dto.OrderDTO;

@Mapper
public interface OrderMgrDAO {

	List<OrderDTO> getOrders(OrderDTO odto);

	int insertOrders(List<OrderDTO> hCartList);

	int updateOrder(OrderDTO odto);

	int deleteOrder(OrderDTO odto);

}
