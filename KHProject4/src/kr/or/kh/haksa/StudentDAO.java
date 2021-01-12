package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends HaksaDAO implements IStudentDAO{

	public StudentDAO() throws ClassNotFoundException { // 생성자함수 HaksaDAO에서 ClassNotFoundException

	}
	@Override
	public void studentRegisterSql(StudentDTO studentDTO) throws SQLException {
		sql = "insert into studentzhen(age,irum,hakbun) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, studentDTO.getAge());
		pstmt.setString(2, studentDTO.getIrum());
		pstmt.setString(3, studentDTO.getHakbun());
	}// 준비

	
	@Override
	public ResultSet studentListSql() throws SQLException {

		conn = getConnection();
		sql = "select no,age,irum,hakbun from studentzhen";
		pstmt = conn.prepareStatement(sql);
		rs = studentExecuter(rs);
		rs = pstmt.executeQuery();

		return rs;
	}
	
	@Override
	public int studentDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from studentzhen where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = studentExecuter();
		return cnt;

	}
	@Override
	public ResultSet studentSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no, age, irum, hakbun from studentzhen where irum = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		pstmt.executeQuery();
		rs = studentExecuter(rs);
		return rs;

	}
	@Override
	public int studentUpdateSql(String irumUpdate, StudentDTO studentDTO) throws SQLException {
		conn = getConnection();
		sql = "update studentzhen set age=?, irum=?, hakbun=? where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, studentDTO.getAge());
		pstmt.setString(2, studentDTO.getIrum());
		pstmt.setString(3, studentDTO.getHakbun());
		pstmt.setString(4, irumUpdate);
		cnt = studentExecuter();
		return cnt;

	}

}