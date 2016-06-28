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
      <tr >
      	<th style="font-size:50px; font-style: italic; "><div align="center">정말로 삭제 하시겠습니까?</div></th>
      </tr>
      <tr>
      <td>
      <div align="center"> 
      <input type="button" class="btn btn-danger " style="width: 100px; font-weight: bold;" data-ng-click="yClick()" value="예  ">
      <input type="button" class="btn btn-success " style="width: 100px; font-weight: bold;" data-ng-click="nClick()" value="아니오">
      </div>
      </td>
      </tr>

      </tbody>
   </table>
</div>
</body>
</html>