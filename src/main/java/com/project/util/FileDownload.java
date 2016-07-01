package com.project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class FileDownload {
	 //다운로드
	   public void downloadFiles(String originalFile, String storedFile, String filePath,
	         HttpServletResponse response, HttpServletRequest request)throws Exception{
	      
	      System.out.println(":: => downloadFiles() start ...");
	      
	      String userAgent = request.getHeader("User-Agent");
	      
	      System.out.println(":: userAgent => "+userAgent);
	      System.out.println(":: originalFile => "+originalFile);
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
	      String tFilepath = filePath +"\\"+storedFile;
	      System.out.println("tFilePath ="+tFilepath);
	      
	        FileInputStream fis = new FileInputStream(tFilepath);
	        
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
