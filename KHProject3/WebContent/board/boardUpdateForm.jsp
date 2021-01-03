<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url(images/back01.jpg);}
#boardUpdateForm{
   position: absolute;
   top:250px;left:650px;
   width:430px; height:100px;
   border: 1px solid black;   
}
.kh01{
    width:100px; height:50px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardUpdateForm">
<form action="boardUpdateSearch.bo" method="get">
  <ul>
      <li><label for="수정할제목">수정할제목</label>
          <input type="text" name="titleSearch" autofocus="autofocus" placeholder="수정할 제목을 입력" required="required">
      </li>
      <li><input type="image" src="images/update.png" class="kh01">
      </li>
  </ul>
</form>  
</div>
</body>
</html>