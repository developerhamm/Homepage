<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%-- <%
ResultSet rs = null;
String idSearch = request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://inputstream.cafe24.com:3306/inputstream", "inputstream","outputStream1");
String sql = "select id from memberzhen where id=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1,idSearch);
rs = pstmt.executeQuery();
String id = null;
if(rs.next()){
    id= rs.getString("id");
    if(id.equals(idSearch)){
       out.print("아이디 중복으로 사용불가능합니다.<br>");
    }
 }
 
 else{
    out.print("사용가능한 아읻니다.<br>");
 }
%> --%>

<input type="button" value="종료" onclick="self.close()">

</body>
</html>