<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url(images/back01.jpg);}
#loginForm{
  position: absolute; 
  top:300px;left:800px;
  width:400px;
  border: 1px solid orange;
}
.kh01{
    width:100px; height:50px;
}
h1{text-align: center;color: orange;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="loginForm">
<h1>로그인</h1>
<form action="memberLogin.mb" method="get">
 <ul>
    <li><label for="아이디">아&nbsp;이&nbsp;&nbsp;디</label>
        <input type="text" name="id" maxlength="10" size="20" autofocus="autofocus" required="required" placeholder="아이디입력">
    </li>
    <li><label for="패스워드">패스워드</label>
        <input type="password" name="pw" maxlength="10" size="20" placeholder="패스워드입력">
    </li>
    <li><input type="image" src="images/login.jpg" class="kh01">
        <a href="index.jsp?page=member/memberForm"><img src="images/member.png" class="kh01"></a>        
    </li>
    <li><a href="member/idcheck.jsp">아이디찾기</a>&nbsp;<a href="member/passcheck.jsp">패스워드찾기</a>
    </li>
 </ul>
</form>
</div>
</body>
</html>