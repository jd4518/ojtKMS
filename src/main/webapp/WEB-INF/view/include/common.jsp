<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- angularJs -->	


<!-- cdn -->


<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- CSS -->
<c:url var="bootstrap_css" value="/framework/css/bootstrap.css" />
<c:url var="bootstrap_min_css" value="/framework/css/bootstrap.min.css" />
<c:url var="fileinput_css" value="/framework/css/fileinput.css" />
<c:url var="landing_page_css" value="/framework/css/landing-page.css" />
<c:url var="font_awesome_css"
	value="/framework/font-awesome/css/font-awesome.css" />
<c:url var="reset_css" value="/framework/css/reset.css" />
<c:url var="style_css" value="/framework/css/style.css" />

<link rel="stylesheet" href="${bootstrap_css}" />
<link rel="stylesheet" href="${bootstrap_min_css}" />
<link rel="stylesheet" href="${fileinput_css}" />
<link rel="stylesheet" href="${landing_page_css}" />
<link rel="stylesheet" href="${font_awesome_css}" />
<link rel="stylesheet" href="${reset_css}" />
<link rel="stylesheet" href="${style_css}" />


<!-- JavaScripte -->
<c:url var="jquery_js" value="/framework/js/jquery.js" />
<c:url var="bootstrap_js" value="/framework/js/bootstrap.js" />
<c:url var="fileinput_js" value="/framework/js/fileinput.js" />
<c:url var="angular_js" value="/framework/js/angular.js" />
<c:url var="angular_route_js" value="/framework/js/angular-route.js" />
<c:url var="ui_bootstrap_min_js" value="/framework/js/ui-bootstrap.min.js" />
 <c:url var="mainController_js" value="/js/mainController.js" />
<c:url var="joinController_js" value="/js/joinController.js" />
<c:url var="loginController_js" value="/js/loginController.js" />
<c:url var="boardMainController_js" value="/js/boardMainController.js" />
<c:url var="boardListController_js" value="/js/boardListController.js" />
<c:url var="boardDetailController_js" value="/js/boardDetailController.js" />
<c:url var="boardInsertController_js" value="/js/boardInsertController.js" />
<c:url var="boardModifyController_js" value="/js/boardModifyController.js" />
<c:url var="boardDeleteController_js" value="/js/boardDeleteController.js" />
<c:url var="memberInfoController_js" value="/js/memberInfoController.js" />
<c:url var="changePasswordController_js" value="/js/changePasswordController.js" />
<c:url var="reportInsertController_js" value="/js/reportInsertController.js" />
<c:url var="reportListController_js" value="/js/reportListController.js" />
<c:url var="memberListController_js" value="/js/memberListController.js" />

<!-- URL경로 설정 -->


<script type="text/javascript" src="${jquery_js}"></script>
<script type="text/javascript" src="${bootstrap_js}"></script>
<script type="text/javascript" src="${fileinput_js}"></script>
<script type="text/javascript" src="${angular_js}"></script>
<script type="text/javascript" src="${angular_route_js}"></script>
<script type="text/javascript" src="${ui_bootstrap_min_js}"></script>
<script type="text/javascript" src="${mainController_js}"></script>
<script type="text/javascript" src="${joinController_js}"></script>
<script type="text/javascript" src="${loginController_js}"></script>
<script type="text/javascript" src="${boardMainController_js}"></script>
<script type="text/javascript" src="${boardListController_js}"></script>
<script type="text/javascript" src="${boardDetailController_js}"></script>
<script type="text/javascript" src="${boardInsertController_js}"></script>
<script type="text/javascript" src="${boardModifyController_js}"></script>
<script type="text/javascript" src="${boardDeleteController_js}"></script>
<script type="text/javascript" src="${memberInfoController_js}"></script>
<script type="text/javascript" src="${changePasswordController_js}"></script>
<script type="text/javascript" src="${reportInsertController_js}"></script>
<script type="text/javascript" src="${reportListController_js}"></script>
<script type="text/javascript" src="${memberListController_js}"></script>

	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-touch.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-animate.js"></script>
	
<script src='http://codepen.io/andytran/pen/vLmRVp.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js'></script>

