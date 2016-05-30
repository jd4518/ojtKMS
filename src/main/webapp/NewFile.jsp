<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">


.neon {

  -webkit-animation-name: blinker;  

  -webkit-animation-iteration-count: infinite;  

  -webkit-animation-duration: 2s; 

}
@-webkit-keyframes blinker {  

  0% { opacity: 0; }

  50% { opacity: 1; }

  100% { opacity: 0.5; }
}

.blink {

    -webkit-animation: blink 2.5s linear infinite;

} 

@-webkit-keyframes blink {

    0% { background-color: red; }

    33% { background-color: yellow; }

    66% { background-color: blue; }

    100% { background-color: green; }

/*    from { background-color: red;}

    to {background-color: green;}  */

 

</style>
왕<span class="neon"> 야 호</span>ㄹㄹㄹ
</body>
</html>