<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
   <table class="table">
      <thead class="htable">
      <tr data-ng-repeat="b in board">
      	<th colspan="6" style="font-size:50px; font-style: italic; ">{{b.CATEGORY_NAME}}</th>
      </tr>
         <tr data-ng-repeat="b in board">
         	 <th>작성자</th>
            <td>{{b.MEMBER_NAME}}</td>
            <th>제목</th>
            <td>{{b.BOARD_TITLE}}</td>
            <th>등록일</th>
            <td>{{b.BOARD_REGDATE | date : "medium"}}</td>
         </tr>
      </thead>
      <tbody class="btable">
         <tr data-ng-repeat="b in board">
            <td colspan="6">{{b.BOARD_CONTENT}}</td>
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
				 <div  data-ng-repeat="b in board">
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

<div class="form-group" >
	<label  class="col-lg-2 cLabel">댓글입력</label>
	   <div  class="col-lg-7">
	   <textarea name="comment" cols='50' rows='5' data-ng-model="content.content" required>
	   </textarea>
	   <span style="color:red" data-ng-show="commentForm.comment.$dirty && commentForm.comment.$invalid">
		<span data-ng-show="commentForm.comment.$error.required">내용을 입력해주세요.</span>
		</span></div>
	   <div class="help-block with-errors"></div>
	   <div class="col-lg-2"><input name="button" type="button" data-ng-click="click()" class="btn btn-info btnalign"  value="입력"
	   data-ng-disabled="commentForm.comment.$invalid"> </div>
	</div>


</body>
</html>