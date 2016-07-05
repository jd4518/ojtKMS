<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>    
<html lang="ko" data-ng-app="projectApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><sitemesh:write property='title'/></title>
<%@ include file="/WEB-INF/view/include/common.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<sitemesh:write property='head'/>
<script type="text/javascript">

var currenttime = new Date();
//var montharray=new Array("01","02","03","04","05","06","07","08","09","10","11","12")
var serverdate=new Date(currenttime)

function padlength(what){
var output=(what.toString().length==1)? "0"+what : what
return output
}

function displaytime(){

serverdate.setSeconds(serverdate.getSeconds()+1)

var timeOfDay = ( serverdate.getHours() < 12 ) ? "AM" : "PM";
var servertimeHours = serverdate.getHours();

// Convert the hours component to 12-hour format if needed
servertimeHours = ( servertimeHours > 12 ) ? servertimeHours - 12 : servertimeHours;

// Convert an hours component of "0" to "12"
servertimeHours = ( servertimeHours == 0 ) ? 12 : servertimeHours;

//var datestring=serverdate.getFullYear()+"."+montharray[serverdate.getMonth()]+"."+padlength(serverdate.getDate())
var timestring=padlength(servertimeHours)+":"+padlength(serverdate.getMinutes())+":"+padlength(serverdate.getSeconds())+" "+timeOfDay
document.getElementById("servertime").innerHTML=timestring
}

window.onload=function(){
setInterval("displaytime()", 1000)
}

</script>
</head>
<body data-ng-controller="boardMainCtrl" style="background-color:#000000;"  >

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
     <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_MANAGER')">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#menu-toggle" id="menu-toggle"><span class="glyphicon glyphicon-list" aria-hidden="true"></span></a>
        </div>
        </sec:authorize>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
				<li><a href="/Project/board/boardMain.do#/bMain"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span> Home </a></li>
             	<li><a href="#"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span> Help</a></li>
             	<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                <li><a href="/Project/member/memberMain.do#/login"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Log In</a></li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_MANAGER')">
                <li>
		      <a href="${pageContext.request.contextPath}/logout.do"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> Log Out</a>
		      </li>
        </sec:authorize>
            </ul>
            <form class="navbar-form navbar-right" action="#" method="GET">
           		<div class="input-group">
					<input type="text" class="form-control" placeholder="Search..." id="query" name="search" value="">
                  	<div class="input-group-btn">
                    	<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-search"></span></button>
                  	</div>
				</div>
            </form>
        </div>
    </div>
</nav>

<div id="wrapper" class="toggled">
    <div class="container-fluid">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
              	<li class="sidebar-brand">
                    <br>
                </li>
                <li class="sidebar-brand">
                    <a href="/Project/board/boardMain.do#/memberInfo" class="navbar-brand" style="font-weight: bold;">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 내 정보
                    </a>
                </li>
                <li>
					<div class="at-header"><div class="container">
					<div class="col-lg-3 col-sm-4 col-10 header-logo text-center">
					                                            <div class="clockStyle"><span id="servertime"></span></div>
					                                        </div>
					</div></div>
                </li>
                  <li>
                    <a style="font-weight: bold;" href="/Project/board/boardMain.do#/bMain"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a>
                </li>
                
                <li >
                <div data-ng-mouseover="mOver(menu.menu[0].MENU_NO)" data-ng-mouseleave="mLeave()">
                    <a style="font-weight: bold;" ><span class="glyphicon glyphicon-home" aria-hidden="true" ></span> {{menu.menu[0].MENU_NAME}}</a>
                    <div data-ng-show="n1" data-ng-repeat="x in menu.cateogry"> <a href="/Project/board/boardMain.do#/boardList/{{x.CATEGORY_NO}}{{menu.menu[0].MENU_NO}}" data-ng-show="{{x.MENU_NO==menu.menu[0].MENU_NO}}" style="color:#fff; font-weight: bold; padding-left: 25px;"> <span  class="glyphicon glyphicon-tasks" ></span> {{x.CATEGORY_NAME}}</a></div>
                    </div>
                    <div data-ng-mouseover="mOver(menu.menu[1].MENU_NO)" data-ng-mouseleave="mLeave()">
                    <a style="font-weight: bold;" ><span class="glyphicon glyphicon-home" aria-hidden="true" ></span> {{menu.menu[1].MENU_NAME}}</a>
                    <div data-ng-show="n2" data-ng-repeat="x in menu.cateogry"> <a href="/Project/board/boardMain.do#/boardList/{{x.CATEGORY_NO}}{{menu.menu[1].MENU_NO}}" data-ng-show="{{x.MENU_NO==menu.menu[1].MENU_NO}}" style="color:#fff; font-weight: bold; padding-left: 25px;"> <span  class="glyphicon glyphicon-tasks" ></span> {{x.CATEGORY_NAME}}</a></div>
                    </div>
                    <div data-ng-mouseover="mOver(menu.menu[2].MENU_NO)" data-ng-mouseleave="mLeave()">
                    <a style="font-weight: bold;" ><span class="glyphicon glyphicon-home" aria-hidden="true" ></span> {{menu.menu[2].MENU_NAME}}</a>
                    <div data-ng-show="n3" data-ng-repeat="x in menu.cateogry"> <a href="/Project/board/boardMain.do#/boardList/{{x.CATEGORY_NO}}{{menu.menu[2].MENU_NO}}" data-ng-show="{{x.MENU_NO==menu.menu[2].MENU_NO}}" style="color:#fff;  padding-left: 25px;"> <span  class="glyphicon glyphicon-tasks" ></span> {{x.CATEGORY_NAME}}</a></div>
                    </div>
                </li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
                <li>
                <a style="font-weight: bold;" href="/Project/admin/adminMain.do#/memberList"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 회원목록</a>
                </li>
                <li>
                <a style="font-weight: bold;" href="/Project/admin/adminMain.do#/reportList"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 신고페이지</a>
                </li>
                </sec:authorize>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
    </div>
</div>
<!-- /#wrapper -->
	
	<sitemesh:write property='body'/>
</body>
</html>