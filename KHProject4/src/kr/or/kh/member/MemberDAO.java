package kr.or.kh.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kh.board.BoardDAO;
import kr.or.kh.board.BoardDTO;

public class MemberDAO {
   private Connection conn;
     private MemberDTO memberDTO;
     private MemberDAO memberDAO;
     private ResultSet rs;
     private PreparedStatement pstmt;
     private String sql;
     private ArrayList<MemberDTO> memberList;
     private int cnt;
   
   public MemberDAO() {
       memberDTO = new MemberDTO();
         try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      }
      public Connection getConnection() throws SQLException {
            conn = DriverManager.getConnection("jdbc:mysql://inputstream.cafe24.com:3306/inputstream", "inputstream","outputStream1");
            return conn;
         }
      public int memberRegister(MemberDTO memberDTO) throws SQLException{
           conn=getConnection();
           sql="insert into memberzhen(id,pw,addr,tel) values(?,?,?,?)";
           pstmt=conn.prepareStatement(sql);
           pstmt.setString(1,memberDTO.getId());
           pstmt.setString(2,memberDTO.getPw());
           pstmt.setString(3,memberDTO.getAddr());
           pstmt.setString(4,memberDTO.getTel());
           cnt=pstmt.executeUpdate();
           return cnt;
      }
      public ArrayList<MemberDTO> memberList() throws SQLException{
           conn=getConnection();
           sql="select id,pw,addr,tel from memberzhen";//번호로 오름차순정렬
           pstmt=conn.prepareStatement(sql);
           rs=pstmt.executeQuery();
           memberList = new ArrayList<MemberDTO>();
           while(rs.next()) {
              memberDTO= new MemberDTO();
              memberDTO.setId(rs.getString("id"));
              memberDTO.setPw(rs.getString("pw"));
              memberDTO.setAddr(rs.getString("addr"));
              memberDTO.setTel(rs.getString("tel"));
              memberList.add(memberDTO);
        }
        return memberList;
   }
      public int memberDelete(String idDelete, String pwDelete) throws SQLException{
    	conn = getConnection();
    	sql = "delete from member where id=? and pw=?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, idDelete);
    	pstmt.setString(2, pwDelete);
    	cnt=pstmt.executeUpdate();
    	return cnt;
        
      }
      
      public MemberDTO memberLogin(String id,String pw)throws SQLException {
         conn=getConnection();
      sql = "select id,pw from memberzhen where id=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs=pstmt.executeQuery();
      while(rs.next()){
         memberDTO.setId(rs.getString("id"));
         memberDTO.setPw(rs.getString("pw"));     
      }
      return memberDTO;
}
      public String memberIdcheck(String telSearch) throws SQLException{
         conn=getConnection();
        sql="select id from memberzhen where tel=?";
       pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, telSearch);
         rs=pstmt.executeQuery();
         String id = null;
         while(rs.next()){
            id = rs.getString("id");
         }
         return id;
      }
      public String memberPwcheck(String idSearch)throws SQLException{
         conn=getConnection();
         sql="select pw from memberzhen where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, idSearch);
         rs=pstmt.executeQuery();
         String pw = null;
         while(rs.next()){
               pw = rs.getString("pw");
            }
         return pw;
      }
      public MemberDTO memberUpdateConfirm(String idSearch) throws SQLException{
         conn=getConnection();
         sql="select id,pw,addr,tel from memberzhen where id=?";
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1, idSearch);
         rs=pstmt.executeQuery();
         while(rs.next()){
            memberDTO.setId(rs.getString("id"));
            memberDTO.setPw(rs.getString("pw"));
            memberDTO.setAddr(rs.getString("addr"));
            memberDTO.setTel(rs.getString("tel"));
            }
         return memberDTO;
      }
      public int memberUpdateFinal(MemberDTO memberDTO,String idSearch) throws SQLException {
         conn=getConnection();
         sql="update memberzhen set id=?,pw=?,addr=?,tel=? where id=?";
         pstmt=conn.prepareStatement(sql);
         pstmt.setString(1, memberDTO.getId());
         pstmt.setString(2, memberDTO.getPw());
         pstmt.setString(3, memberDTO.getAddr());
         pstmt.setString(4, memberDTO.getTel());
         pstmt.setString(5, idSearch);
         cnt=pstmt.executeUpdate();
         return cnt;
      }
      
      public ResultSet memberIdCheckall(String id)throws SQLException {
    	  conn = getConnection();
    	  String sql = "select id from memberzhen where id=?";
    	  PreparedStatement pstmt = conn.prepareStatement(sql);
    	  pstmt.setString(1,id);
    	  rs = pstmt.executeQuery();
    	  
    	  return rs;
      }
      
}