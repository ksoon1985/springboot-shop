package kr.co.sol.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.shop.dto.OrderDTO;
import kr.co.sol.shop.dto.ProductDTO;

@Mapper
public interface ProcutMgrDAO {

	List<ProductDTO> getProducts(ProductDTO pdto);

	int insertProduct(ProductDTO pdto);

	int updateProduct(ProductDTO pdto);

	int deleteProduct(ProductDTO pdto);

	void updateStocks(List<OrderDTO> list);

}
