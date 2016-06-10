<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="/Project/js/test.js"></script>
<%@ include file="/WEB-INF/view/include/common.jsp" %>
	
</head>
<body>
<article class="container">
   <div class="pen-title">
  <h1>Login <small><span> <i class='fa fa-paint-brush'></i></span></small></h1>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle">
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form>
      <input type="text" id="id" placeholder="Username"/>
      <input type="password" placeholder="Password"/>
      <input type="button" text="on" value="on" onclick="pop1();"/>
      
      <p id="demo">JavaScript can change HTML content.</p>
	<input type="button" onclick="rr()">click me</button>
	
	<p id="demo1">JavaScript can change HTML content.</p>

<button type="button"
onclick="document.getElementById('demo1').innerHTML = 'Hello JavaScript!'">
Click Me!</button>
	
	
      <button>Login</button>
    </form>
  </div>

  <div class="cta"><a href="http://andytran.me">Forgot your password?</a></div>
</div>
      </article>

</body>
</html>