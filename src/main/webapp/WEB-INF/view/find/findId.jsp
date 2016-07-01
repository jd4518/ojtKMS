<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B I T</title>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>
<body > 
<h1>아이디 찾기</h1>

 <div align="center">
 가입하실때  입력한 이름과 이메일을 적어주세요.
 <form action ="/Project/find/findId.do" method="post">
<table>
 <tr>
 	<td>
 이름 : 
 	</td>
 	<td>
		 <input type="text" name="memberName" required="required"><br>
	 </td>
 </tr>
 <tr>
 	<td>
이메일 :
 	</td>
	 <td>
		 <input type="text" name="memberEmail" required="required"><br>
	 </td>
 </tr>
 </table>
 <br>
 <div align="center">
  <input type="submit" value="확인">
  <input type="button" onclick="back()" value="취소">
 </div>
      </form>
      </div>

<script type="text/javascript">
	function back(){
		history.back();
	}
</script>
</body>
</html>