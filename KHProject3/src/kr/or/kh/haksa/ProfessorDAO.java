package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends HaksaDAO {
	
	public ProfessorDAO()throws ClassNotFoundException {		
					    
	}
	
	public void professorRegisterSql(ProfessorDTO professorDTO)throws SQLException {		
		sql = "insert into professor(age,irum,subject) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, professorDTO.getNai());
		pstmt.setString(2, professorDTO.getIrum());
		pstmt.setString(3, professorDTO.getSubject());
	}
	
	public ResultSet professorListSql()throws SQLException {
		 conn = getConnection(); 
		 sql = "select no,age,irum,subject from professor";
		 pstmt = conn.prepareStatement(sql);
		 rs=professorExecuter(rs);		 
		 return rs; 		
	}
	public int professorDeleteSql(String irumDelete)throws SQLException {
		conn = getConnection();
		sql = "delete from professor where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt=professorExecuter();
		return cnt;		
	}
	public ResultSet professorSearchSql(String irumSearch)throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,subject from professor where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		rs=professorExecuter(rs);
		return rs;
	}
	public int professorUpdateSql(String irumUpdate,ProfessorDTO professorDTO)throws SQLException {
		conn = getConnection();
		sql = "update professor set age=?,irum=?,subject=? where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, professorDTO.getNai());
		pstmt.setString(2, professorDTO.getIrum());
		pstmt.setString(3, professorDTO.getSubject());
		pstmt.setString(4, irumUpdate);
		cnt=professorExecuter();
		return cnt;
	}
}
