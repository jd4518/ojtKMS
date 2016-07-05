<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
th {
	text-align: center;
	background-color: #5cb85c;
	color: white;
}
td {
	valign:top;
	text-align: center;
}
</style>
</head>
<body>

	<div class="table-responsive">
   <table class="table table-striped table-hover" >
      <thead >
           <tr >
      	<th colspan="9" style="font-size:50px; font-style: italic; ">신고자 관리 페이지</th>
      	</tr>
         <tr style="color:#ffffff;">
            <th>NO</th>
            <th>게시판 제목</th>
            <th>신고제목</th>
            <th>신고사유</th>
            <th>첨부파일</th>
            <th>글쓴이</th>
            <th>신고자</th>
            <th>정지하기</th>
            <th>풀어주기</th>
         </tr>
      </thead>
      <tbody style="background-color:#ffffff">
         <tr data-ng-repeat="b in list.stop">
            <td>{{b.rn}}</td>
            <td><a class="aTag" href="/Project/board/boardMain.do#/boardDetail/{{b.boardNo}}{{b.categoryNo}}{{b.menuNo}}">{{b.boardTitle}}</a></td>
            <td>{{b.stopTitle}}</td>
            <td>{{b.stopReason}}</td>
            <td><div data-ng-repeat = "f in list.files"><a class="aTag" data-ng-if="f.stopNo==b.stopNo"
      		href="/Project/board/reportFileDown.do?fileRealName={{f.fileRealName}}&fileFakeName={{f.fileFakeName}}">{{f.fileRealName}}
      		<input type="hidden" data-ng-model="fileNa" ></a></div></td>
            <td>{{b.wMemberId}}</td>
            <td>{{b.sMemberId}}</td>
            <td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <input type="button" class="btn btn-warning" value="경고" data-ng-click="memberWarning(b.wMemberId)">
            <input type="button" class="btn btn-danger" value="영구" data-ng-click="memberStop(b.wMemberId)">
            </sec:authorize>         
            </td>
            <td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <input type="button" class="btn btn-success" data-ng-click="memberSave(b.wMemberId)" value="용서하기">
            </sec:authorize>
            </td>
         </tr>
         <tr><td class="text-center" colspan="7" >
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
            </td>
         </tr>
      </tbody>
   </table>
   
</div>

</body>
</html>