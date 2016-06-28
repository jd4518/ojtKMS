<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="detailForm">
<div align="center">
   <table class="table">
      <thead class="htable">
      <tr >
      	<th colspan="6" style="font-size:50px; font-style: italic; ">{{board.categoryName}}</th>
      </tr>
         <tr>
         	 <th>작성자</th>
            <td>{{board.memberId}}</td>
            <th>제목</th>
            <td>{{board.boardTitle}}</td>
            <th>등록일</th>
            <td>{{board.boardRegDate | date : "medium"}}</td>
         </tr>
      </thead>
      <tbody class="btable">
         <tr >
            <td colspan="6">{{board.boardContent}}</td>
         </tr>
         <tr>
         	<th colspan="6">댓글</th>
         	</tr>
         <tr data-ng-repeat="c in comment">
         	<td>
         		<div>{{c.MEMBER_ID}}</div>
         	</td>
         	<td colspan="5"> 
			    <div class="col-lg-10">
				 <div >
				  <label class="control-label">{{c.REPLY_CONTENT}}</label>
				  <div align="right">
				  {{c.REPLY_REGDATE | date : "yyyy-MM-dd hh:mm:ss a"}}
				  </div>
				 </div>
				 </div>
			 </td>
         </tr>


      </tbody>
   </table>
</div>
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
<div  class="form-group" >
	<label  class="col-lg-2 cLabel">댓글입력</label>
	   <div  class="col-lg-7">
	   <textarea name="content" cols='50' rows='5' data-ng-model="content"  required>
	   </textarea>
	   <span style="color:red" data-ng-show="detailForm.content.$touched && detailForm.content.$invalid">
		<div>내용을 입력해주세요.</div>
		</span>
		</div>
	   <div class="help-block with-errors"></div>
	   <div class="col-lg-3" align="right"><a   data-ng-click="reply('${member.memberId}')" class="btn btn-primary"  
	   data-ng-disabled="detailForm.content.$invalid">입력</a> <a class="custom btn-custom" data-ng-click="recommand('${member.memberId}')"
	   >좋아요 <i class="fa fa-heart"  aria-hidden="true"> ({{board.boardRecommandPoint}})</i></a></div>
	</div>
	<table class="table"  >
	<tr>
	<td style="border: 0px;">
	<div align="right"><input name="button" type="button" data-ng-click="list()" class="btn btn-success" value="목록" >
	<span data-ng-show="checkId('${member.memberId }')">
	<a href="#/boardModify/{{board.boardNo}}{{board.categoryNo}}" class="btn btn-warning">수정</a>
	<a href="#/boardDelete/{{board.boardNo}}{{board.categoryNo}}{{mNo}}" class="btn btn-danger">삭제</a>
	</span>
	</div>
	</td>
	</tr>

</table>
</sec:authorize>
</form>
</body>
</html>