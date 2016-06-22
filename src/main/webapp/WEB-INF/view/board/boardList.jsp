<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="table-responsive">
   <table class="table table-striped table-hover" >
      <thead >
      <tr><td></td></tr>
         <tr style="color:#ffffff;">
            <th>NO</th>
            <th>제목</th>
            <th>ID</th>
            <th>작성자</th>
            <th>수정</th>
            <th>삭제</th>
         </tr>
      </thead>
      <tbody style="background-color:#ffffff">
         <tr data-ng-repeat="notice in list.board">
            <td>{{notice.RN}}</td>
            <td><a href="#/boardDetail/{{notice.BOARD_NO}}{{categoryNo}}">{{notice.BOARD_TITLE}}</a></td>
            <td>{{notice.MEMBER_ID}}</td>
            <td>{{notice.MEMBER_NAME}}</td>
            <td><a href="#/shareModify/{{share.boardNum}}" class="btn btn-success">Edit...</a></td>
            <td><a href="#/shareDelete/{{share.boardNum}}" class="btn btn-info">Delete...</a></td>
         </tr>
         <tr><td class="text-center" colspan="6" >
         <div 
                data-uib-pagination 
                data-total-items="list.page.totalItem" style="width:800px;" 
                data-ng-model="pageNo"
                data-max-size="10"
                data-ng-change="selectPage()"
                data-boundary-links="true">
            </div> 
            </td>
           
         </tr>
      </tbody>
   </table>
   <div align="right">
   <a href="#/boardDetail" class="btn btn-primary">게시글등록</a></th>
   </div>
</div>

</body>
</html>