package com.project.util.service;

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

}
