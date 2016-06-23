<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
   <table class="table">
      <thead class="htable">
      <tr>
      	<th colspan="2" style="font-size:50px; font-style: italic; ">글쓰기</th>
      </tr>
         <tr>
            <th style="font-size: x-large; text-align: center;">제목</th>
            <th><input type="text" data-ng-model="title" class="form-control" style="border: 0px;" data-ng-model-options="{ updateOn: 'blur' }"></th>
         </tr>
      </thead>
      <tbody class="btable">
         <tr >
            <td colspan="2"><textarea class="form-control" data-ng-model-options="{ updateOn: 'blur' }" data-ng-model="content" rows="20" cols="130" style="background-color: #aaa; border: 0px; color:black;"></textarea>
            </td>
         </tr>
         <tr >
         	<td colspan="2"style="border:0px; background-color: #000;" >
         	<div align="right">
         	<span><input type="button" data-ng-click="back()" class="btn btn-success weight"  value="목록"></span>
         	<span ><input type="button" data-ng-click="board(${member.memberId})" class="btn btn-warning weight" value="등록"></span>
         	</div>
         	</td>
         </tr>
      </tbody>
   </table>
</div>
</body>
</html>