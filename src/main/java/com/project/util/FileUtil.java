package com.project.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class FileUtil {


	    public static String getRandomString(){
	        return UUID.randomUUID().toString().replaceAll("-", "");
	    }
	    
	    public static String getRandomString(int length){
	      StringBuffer buffer = new StringBuffer();
	      Random random = new Random();
	     
	      String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
	     
	      for (int i=0 ; i<length ; i++){
	        buffer.append(chars[random.nextInt(chars.length)]);
	      }
	      return buffer.toString();
	    }
	    
	    public static Date getDate(String parseDate){
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       
	       Date date = new Date();
	       try {
	         date = simpleDateFormat.parse(parseDate);
	      } catch (ParseException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	       
	       return date;
	    }
	    public static String cutString(String title, int n){
	        String result = "";
	        if(title.length() > n)
	            result = (new StringBuilder(String.valueOf(title.substring(0, n)))).append("...").toString();
	        else
	            result = title;
	        return result;
	    }
}
