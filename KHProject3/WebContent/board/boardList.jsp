<%@page import="kr.or.kh.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background-image: url("images/back01.jpg");}
#boardlist{
  position: absolute;
  top:300px;left:400px;
}
table{
   border: 1px solid white; border-collapse: collapse;
}
th{background-color: black; color: white;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardlist">
<h1>커뮤니티 목록</h1>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
    <th>번호</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
    <th>날짜</th>
    <th>조회수</th>
    <th>&nbsp;</th>
</tr>
<%    
    ArrayList<BoardDTO> boardList=(ArrayList<BoardDTO>)request.getAttribute("boardList");
    for(int i=0;i<boardList.size();i++){
       BoardDTO boardDTO = boardList.get(i);    	
%>
<tr>
   <td><%= boardDTO.getNo() %></td>
   <td><%= boardDTO.getTitle() %></td>
   <td><%= boardDTO.getContent() %></td>
   <td><%= boardDTO.getAuthor() %></td>
   <td><%= boardDTO.getNal() %></td>
   <td><%= boardDTO.getReadcount() %></td>
   <td><a href="boardDelete.bo?no=<%=boardDTO.getNo()%>">삭제</a></td>
</tr>
<%} %>
</table>
<a href="index.jsp?page=board/boardWrite">글쓰기</a>&nbsp;
<a href="index.jsp?page=board/boardSearchForm">검색</a>&nbsp;
<a href="index.jsp?page=board/boardUpdateForm">수정</a>&nbsp;
</div>
</body>
</html>