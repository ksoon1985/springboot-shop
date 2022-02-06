package kr.co.sol.admin.service;

import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.shop.dto.OrderDTO;
import kr.co.sol.shop.dto.ProductDTO;

public interface ProductMgrService {

	List<ProductDTO> getProducts(ProductDTO pdto);

	int insertProduct(ProductDTO pdto, MultipartFile file);

	int updatetProduct(ProductDTO pdto, MultipartFile file);

	int deleteProduct(ProductDTO pdto);

	void updateStocks(Hashtable<Integer, OrderDTO> hCartList) throws Exception;;

}
