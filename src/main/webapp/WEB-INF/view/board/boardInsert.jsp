<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<%
	request.setCharacterEncoding("utf-8");
%>
<head>
<script type="text/javascript" src="/Project/framework/js/fileinput.js"></script>
<link rel="stylesheet" href="/Project/framework/css/fileinput.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
      <form name="boardWrite" method="post" enctype="multipart/form-data" action="boardWrite.do"> <!-- 업로드 설정  enctype="multipart/form-data"-->
      <table class="table">
      <thead class="htable">
      <tr>
      	<th colspan="2" style="font-size:50px; font-style: italic; ">글쓰기</th>
      </tr>
         <tr>
            <th style="font-size: x-large; text-align: center;">제목</th>
            <th><input type="text" name="boardTitle" class="form-control" style="border: 0px;" data-ng-model-options="{ updateOn: 'blur' }" >
            	<input type="hidden" name="memberId" value="${member.memberId }">
            	<input type="hidden" name="categoryNo" value="{{cNo}}">
            	<input type="hidden" name="menuNo" value="{{mNo}}">
            </th>
         </tr>
      </thead>
      <tbody class="btable">
         <tr >
            <td colspan="2"><textarea class="form-control" name="boardContent" data-ng-model-options="{ updateOn: 'blur' }"  rows="20" cols="130" style="background-color: #aaa; border: 0px; color:black;"></textarea>
            </td>
         </tr>
         <tr>
	         <td colspan="2">
				         <div class="form-group">
			      <div class="col-lg-10 col-lg-offset-2">
						<input  name="originalFileName" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
			      </div>
			    </div>
	         </td>
         </tr>
         <tr >
         	<td colspan="2"style="border:0px; background-color: #000;" >
         	<div align="right">
         	<span><input type="button" data-ng-click="back()" class="btn btn-success weight"  value="목록"></span>
         	<span ><input type="submit"  class="btn btn-warning weight" value="등록"></span>
         	</div>
         	</td>
         </tr>
      </tbody>
   </table>
         
      </form>
      
      
</div>
</body>
</html>