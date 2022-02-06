package kr.co.sol.admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sol.admin.dao.ProcutMgrDAO;
import kr.co.sol.admin.service.ProductMgrService;
import kr.co.sol.shop.dto.OrderDTO;
import kr.co.sol.shop.dto.ProductDTO;

@Service
public class ProcutMgrServiceImpl implements ProductMgrService {
    @Autowired
    ProcutMgrDAO productMgrDao;
	@Override
	public List<ProductDTO> getProducts(ProductDTO pdto) {
		return productMgrDao.getProducts(pdto);
	}
	@Override
	public int insertProduct(ProductDTO pdto, 
			MultipartFile file) {
		 String sourceFileName = file.getOriginalFilename();
		 //확장자
		 //String sourceFileNameExtension 
		 //   = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		 //파일명 Random처리(다른 이름으로)
		 //  String destinationFileName;

		 File destinationFile; 
		 if (sourceFileName == null || 
				 sourceFileName.length()==0) { 
		      pdto.setImage("ready.gif");
		   } else {
		     pdto.setImage(sourceFileName);
			 //파일명 Random처리(다른 이름으로)
//		     destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
//	         destinationFile = new File(pdto.getPath()+ destinationFileName); 
	         destinationFile = new File(pdto.getPath()+ sourceFileName); 
	         destinationFile.getParentFile().mkdirs(); 
		        try {
					file.transferTo(destinationFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
				 	e.printStackTrace();
			 }
			} 
		return productMgrDao.insertProduct(pdto);
	}
	@Override
	public int updatetProduct(ProductDTO pdto, MultipartFile file) {
		String sourceFileName = file.getOriginalFilename();
		 File destinationFile; 
		 if (sourceFileName == null || 
				 sourceFileName.length()==0) { 
		      pdto.setImage("ready.gif");
		   } else {
		     pdto.setImage(sourceFileName);
	         destinationFile = new File(pdto.getPath()+ sourceFileName); 
	         destinationFile.getParentFile().mkdirs(); 
		        try {
					file.transferTo(destinationFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
				 	e.printStackTrace();
			 }
			} 
		return productMgrDao.updateProduct(pdto);
	}
	
	@Override
	public int deleteProduct(ProductDTO pdto) {
		return productMgrDao.deleteProduct(pdto);
	}
	@Override
	public void updateStocks(Hashtable<Integer, OrderDTO> hCartList) 
			   throws Exception {
		 Set<Integer> keys = hCartList.keySet();
		 List<OrderDTO> list = new ArrayList<OrderDTO>(keys.size());
		 Iterator<Integer> iterKeys = keys.iterator();
		/*
		 * if(true) throw new Exception("연습으로 만든 에러");
		 */
		 while(iterKeys.hasNext()) {
		    list.add(hCartList.get(iterKeys.next()));
		 }
		productMgrDao.updateStocks(list);
		
	}
}
