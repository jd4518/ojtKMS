package com.project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.file.model.Files;

@Component
public class FileUpload {
	   
	   /**
	    * 단일 파일 업로드
	    * @param request
	    * @param filePath
	    * @return
	    * @throws Exception
	    */
	   
	   
	   /**
	    * 다중 파일 업로드
	    * @param request
	    * @param filePath
	    * @return
	    * @throws IllegalStateException
	    * @throws IOException
	    * @throws Exception
	    */
	   public List<Files> fileUploads(HttpServletRequest request, String filePath) throws IllegalStateException, IOException, Exception{
	      
	      System.out.println(":: => fileUploads() start ...");
	      MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
	      List<MultipartFile> fileList = multipartHttpServletRequest.getFiles("originalFileName"); //originalFileName => input="file" 의 name
	      
	      MultipartFile multipartFile = null;
	      Files files = null;
	      List<Files> filesList = new ArrayList<Files>();
	      
	      String originalFileName = null;
	      String originalFileExtension = null;
	      String storedFileName = null;
	      
	      //String filePath = application.getRealPath("/upload");
	      System.out.println(":: filePath => "+filePath);
	      
	      File file = new File(filePath);
	        if(file.exists() == false){
	            file.mkdirs();
	        }
	      
	        for(int i=0; i<fileList.size();i++){
	           multipartFile = fileList.get(i);
	           
	         if (!multipartFile.isEmpty()) {
	            
	            files = new Files();
	            
	            System.out.println("------------- file start -------------");
	            System.out.println("fileName : "+multipartFile.getOriginalFilename());
	            System.out.println("size : "+multipartFile.getSize());
	            System.out.println("-------------- file end --------------\n");
	            
	            originalFileName = multipartFile.getOriginalFilename();
	            originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
	            storedFileName = FileUtil.getRandomString()+originalFileExtension;
	            
	            /*files.setFileSize(multipartFile.getSize());*/
	            files.setFileRealName(originalFileName);
	            files.setFileFakeName(storedFileName);
	            System.out.println(":: => originalFileName = "+originalFileName);
	            System.out.println(":: => fileInfo = "+files);
	            
	            
	            file = new File(filePath+ File.separator +storedFileName);            
	            multipartFile.transferTo(file);
	            
	            filesList.add(files);
	         }
	         
	        }
	        System.out.println(":: => fileInfoList.size = "+filesList.size());
	        System.out.println(":: => fileInfoList = "+filesList);
	        System.out.println(":: => fileUploads() end ...");
	      return filesList;
	   }
	   
	   //다운로드
	   public void downloadFiles(String originalFile, String storedFile, String filePath,
	         HttpServletResponse response, HttpServletRequest request)throws Exception{
	      
	      System.out.println(":: => downloadFiles() start ...");
	      
	      String userAgent = request.getHeader("User-Agent");
	      
	      System.out.println(":: userAgent => "+userAgent);
	      
	      //브라우저 판별
	      //MSIE (IE 10 이하 버전), Trident (IE 11), Edge
	      if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
	          originalFile = URLEncoder.encode(originalFile,"UTF-8").replaceAll("\\+", "%20");
	          response.setHeader("Content-Disposition", "attachment;filename=" + originalFile + ";");
	      } else {
	         originalFile = new String(originalFile.getBytes("UTF-8"), "ISO-8859-1");
	           response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\"");
	      }
	      
	      response.setContentType("application/octet-stream");
	      
	      //originalFile = new String(originalFile.getBytes("UTF-8"), "iso-8859-1");
	      System.out.println(":: originalFile => "+originalFile);
	      
	      response.setHeader("Content-Disposition", "attachment; filename=\""+originalFile+"\"");
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      
	      OutputStream os = response.getOutputStream();
	      
	      
	      //String path = request.getRealPath("/upload");
	      
	      System.out.println(":: filePath => "+filePath);
	      
	        FileInputStream fis = new FileInputStream(filePath + File.separator + storedFile);
	        
	        int n = 0;
	        byte[] b = new byte[512];
	        while((n = fis.read(b)) != -1 ) {
	            os.write(b, 0, n);
	        }
	        fis.close();
	        os.close();
	        
	        System.out.println(":: => downloadFiles() end ...");
	   }

}
