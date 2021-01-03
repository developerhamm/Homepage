<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url("images/back01.jpg");}
#memberForm{
  position: absolute; 
  top:300px;left:800px;
  width:400px;
  border: 1px solid orange;
}
ul{list-style-type: none;}
.kh01{
    width:100px; height:50px;
}
.reset{
   font-size: 25px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

<div id="memberForm">
<h1>회원가입</h1>
  <form action="memberRegister.mb" method="get">
  <ul>
      <li><label for="아이디">아 이 &nbsp;디</label>
          <input type="text" name="id" size="20" maxlength="10" autofocus="autofocus" required="required" placeholder="아이디입력하세요"> 
      </li>
      <li><label for="패스워드">패스워드</label>
          <input type="password" name="pw" size="20" maxlength="10" placeholder="패스워드입력">
      </li>
      <li><label for="주소">주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</label>
          <input type="text" name="addr" size="20" maxlength="100" placeholder="주소입력">
      </li>
      <li><label for="핸드폰번호">핸&nbsp;드&nbsp;&nbsp;폰</label>
          <input type="text" name="tel" placeholder="000-0000-0000">
      </li>
      <li><input type="image" src="images/member.png" class="kh01">
      <input type="reset" value="되돌리기" class="reset">
      </li>
  </ul>
  </form>
</div>
</body>
</html>