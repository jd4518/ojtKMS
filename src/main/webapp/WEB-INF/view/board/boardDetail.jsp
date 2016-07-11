<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    <%
	request.setCharacterEncoding("utf-8");
%>
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
         	<tr >
      		<th colspan="1" style="text-align: center; font-weight: bold; vertical-align: middle;">첨부파일 </th>
      		<td colspan="1" ><div data-ng-repeat = "f in files"><a class="aTag"
      		href="/Project/board/fileDown.do?fileRealName={{f.FILES_REALNAME}}&fileFakeName={{f.FILES_FAKENAME}}">{{f.FILES_REALNAME}}
      		<input type="hidden" data-ng-model="fileNa" ></a></div>
      		</td>
      		<th colspan="4">
      		<div data-ng-show="cNo!=1">
      		<div align="right" class="col-lg-12" data-ng-show="board.memberId!='${member.memberId }'">
      		<a href="/Project/board/boardMain.do#/reportInsert/{{mNo}}/{{cNo}}/{{bNo}}" class="btn" style="color:red; background-color: #fff;" ><i class="fa fa-bell" aria-hidden="true"></i>신고하기</a></div>
      		</div>
      		</th>
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
         	<td colspan="4"> 
			    <div class="col-lg-6">
				  <label class="control-label">{{c.REPLY_CONTENT}}</label>
				 </div>
				  <div class="col-lg-6" align="right">
				  {{c.REPLY_REGDATE | date : "yyyy-MM-dd hh:mm:ss a"}}
				  </div>
			 </td>
			 <td >
			 <sec:authorize access="hasRole('ROLE_USER')">
			 	<div align="right" class="col-lg-12" data-ng-show="'${member.memberId }'==c.MEMBER_ID">
			 	<a   data-ng-click="replyDelete(c.REPLY_NO)" class="btn btn-warning">삭제</a>
			 	</div>
			 </sec:authorize>
			 	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
			 	<div align="right" class="col-lg-12" ><a   data-ng-click="replyDelete(c.REPLY_NO)" class="btn btn-warning">삭제</a></div>
	</sec:authorize>
			 </td>
         </tr>


      </tbody>
   </table>
</div>
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_MANAGER')">
<div  class="form-group" >
	<label  class="col-lg-2 cLabel">댓글입력</label>
	   <div  class="col-lg-7">
	   <textarea name="content" cols='50' rows='5' data-ng-model="content"  required>
	   </textarea>
	   <span style="color:red" data-ng-show="detailForm.content.$touched && detailForm.content.$invalid">
		<div>내용을 입력해주세요.</div>
		</span>
		</div>
	   <div class="help-block with-errors">
	   <div class="col-lg-3" align="right"><a   data-ng-click="reply('${member.memberId}')" class="btn btn-primary"  
	   data-ng-disabled="detailForm.content.$invalid">입력</a>
	    <a data-ng-show="board.memberId!='${member.memberId }'" class="custom btn-custom" data-ng-click="recommand('${member.memberId}')"
	   >좋아요 <i class="fa fa-heart"  aria-hidden="true"> ({{board.boardRecommandPoint}})</i></a></div>
	</div>
	</div>
	<table class="table"  >
	<tr>
	<td style="border: 0px;">
	<div align="right"><input name="button" type="button" data-ng-click="list()" class="btn btn-success" value="목록" >
	<span data-ng-show="checkId('${member.memberId }')">
	<a href="#/boardModify/{{board.boardNo}}{{board.categoryNo}}" class="btn btn-warning">수정</a>
	<sec:authorize access="hasRole('ROLE_USER')">
	<a href="#/boardDelete/{{board.boardNo}}{{board.categoryNo}}{{mNo}}" class="btn btn-danger">삭제</a>
	</sec:authorize>
	</span>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
	<span data-ng-show="cNo==1">
	<a href="#/boardModify/{{board.boardNo}}{{board.categoryNo}}" class="btn btn-warning">수정</a>
	</span>
	<a href="#/boardDelete/{{board.boardNo}}{{board.categoryNo}}{{mNo}}" class="btn btn-danger">삭제</a>
	</sec:authorize>
	</div>
	</td>
	</tr>

</table>
</sec:authorize>
</form>
</body>
</html>