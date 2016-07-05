<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("utf-8");
%>
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
            <th>조회수</th>
            <th>추천수</th>
         </tr>
      </thead>
      <tbody style="background-color:#ffffff">
         <tr data-ng-repeat="b in list.board">
            <td>{{b.rn}}</td>
            <td><a class="aTag" href="#/boardDetail/{{b.boardNo}}{{categoryNo}}{{menuNo}}">{{b.boardTitle}}
             <span style="color: #A566FF" data-ng-show="{{b.num}}!=0"> <i class="fa fa-comment-o" aria-hidden="true"></i> {{b.num}}</span></a></td>
            <td>{{b.memberId}}</td>
            <td>{{b.memberName}}</td>
            <td>{{b.boardHit}}</td>
            <td>{{b.boardRecommandPoint}}</td>
         </tr>
         <tr><td class="text-center" colspan="4" >
         <div 
                data-uib-pagination 
                data-total-items="list.page.totalItem" style="width:800px;" 
                data-ng-model="pageNo"
                data-max-size="10"
                data-ng-change="selectPage()"
                data-boundary-links="true">
            </div> 
            </td>
           <td colspan="2">
            <span>
   <a href="#/boardInsert/{{categoryNo}}{{menuNo}}" class="btn btn-primary">게시글등록</a>
   </span>
            </td>
         </tr>
      </tbody>
   </table>
   
</div>

</body>
</html>