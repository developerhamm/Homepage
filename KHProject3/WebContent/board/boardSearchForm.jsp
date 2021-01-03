<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
   background-image: url(images/back01.jpg);
}
#boardTitle{
   position: absolute;
   top:300px;left:600px;
   width:300px;
   border:1px solid black;
}
.kh01{
   width:100px; height:70px;
   border-radius: 20px;
}
#boardResult{
   position: absolute;
   top:500px;left:400px;
   border: 1px solid black;
}
table{border: 1px solid black; border-collapse: collapse;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardTitle">
<form action="boardSearch.bo" method="get">
<ul>
<li><input type="hidden" name="readcount" value="0"></li>
   <li><label for="제목">제목</label>
       <input type="text" name="titleSearch" autofocus="autofocus" required="required" placeholder="제목입력">
   </li>
   <li><input type="image" src="images/search.jpg" class="kh01"></li>
</ul>
</form>
	
<a href="index.jsp?page=board/boardList">게시판목록</a>&nbsp;<a href="index.jsp?page=board/boardWrite">게시판글쓰기</a>
</div>
</body>
</html>