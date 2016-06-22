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
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-animate.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-cookies.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-resource.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-route.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-route.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-sanitize.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-touch.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular-touch.js"></script>
		<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.3.3/ui-bootstrap.js"></script>
		<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.3.3/ui-bootstrap-tpls.js"></script>
	
<!-- cdn -->
<script src='http://codepen.io/andytran/pen/vLmRVp.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js'></script>


<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- CSS -->
<c:url var="bootstrap_css" value="/framework/css/bootstrap.css" />
<c:url var="bootstrap_min_css" value="/framework/css/bootstrap.min.css" />
<c:url var="landing_page_css" value="/framework/css/landing-page.css" />
<c:url var="font_awesome_css"
	value="/framework/font-awesome/css/font-awesome.css" />
<c:url var="reset_css" value="/framework/css/reset.css" />
<c:url var="style_css" value="/framework/css/style.css" />

<link rel="stylesheet" href="${bootstrap_css}" />
<link rel="stylesheet" href="${bootstrap_min_css}" />
<link rel="stylesheet" href="${landing_page_css}" />
<link rel="stylesheet" href="${font_awesome_css}" />
<link rel="stylesheet" href="${reset_css}" />
<link rel="stylesheet" href="${style_css}" />


<!-- JavaScripte -->
<c:url var="bootstrap_js" value="/framework/js/bootstrap.js" />
<c:url var="jquery_js" value="/framework/js/jquery.js" />
<c:url var="mainController_js" value="/js/mainController.js" />
<c:url var="joinController_js" value="/js/joinController.js" />
<c:url var="loginController_js" value="/js/loginController.js" />
<c:url var="boardMainController_js" value="/js/boardMainController.js" />
<c:url var="boardListController_js" value="/js/boardListController.js" />
<c:url var="boardDetailController_js" value="/js/boardDetailController.js" />
<!-- URL경로 설정 -->


<script type="text/javascript" src="${bootstrap_js}"></script>
<script type="text/javascript" src="${jquery_js}"></script>
<script type="text/javascript" src="${mainController_js}"></script>
<script type="text/javascript" src="${joinController_js}"></script>
<script type="text/javascript" src="${loginController_js}"></script>
<script type="text/javascript" src="${boardMainController_js}"></script>
<script type="text/javascript" src="${boardListController_js}"></script>
<script type="text/javascript" src="${boardDetailController_js}"></script>
