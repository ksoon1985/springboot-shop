package kr.co.sol.common;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.sol.shop.dto.ProductDTO;

@Component("fileUtils")
public class ServletUpload {
      public static final String UPLOAD_DIR = "D:/apri_ncs/upload/";
	  private static final int MAX_FILE_SIZE      
	       = 1024 * 1024 * 5; // 5MB
    public Map<String, Object> parseInsertFileInfo(ProductDTO pdto, MultipartHttpServletRequest mpRequest) throws Exception{
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		Map<String, Object> fileMap = null;
		
		//int fileNo = pdto.getFileNo();
		
		File file = new File(UPLOAD_DIR);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				file = new File(UPLOAD_DIR + storedFileName);
				multipartFile.transferTo(file);
				fileMap = new HashMap<String, Object>();
				
				if(multipartFile.getSize()<=MAX_FILE_SIZE) {
				   // fileMap.put("fileNo", fileNo);
				    fileMap.put("org_file_name", originalFileName);
				    fileMap.put("stored_file_name", storedFileName);
					fileMap.put("fileSize", multipartFile.getSize());
				}
			}
		}
		return fileMap;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
