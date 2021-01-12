package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO extends HaksaDAO implements IManagerDAO{

	public ManagerDAO() throws ClassNotFoundException {

	}
	@Override
	public void managerRegisterSql(ManagerDTO managerDTO) throws SQLException {
		sql = "insert into managerzhen(age,irum,hakbun) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, managerDTO.getAge());
		pstmt.setString(2, managerDTO.getIrum());
		pstmt.setString(3, managerDTO.getPart());
	}// 준비

	
	@Override
	public ResultSet managerListSql() throws SQLException {

		conn = getConnection();
		sql = "select no,age,irum,hakbun from managerzhen";
		pstmt = conn.prepareStatement(sql);
		rs = managerExecuter(rs);
		rs = pstmt.executeQuery();

		return rs;
	}
	@Override
	public int managerDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from managerzhen where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = managerExecuter();
		return cnt;

	}
	@Override
	public ResultSet managerSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no, age, irum, hakbun from managerzhen where irum = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		pstmt.executeQuery();
		rs = managerExecuter(rs);
		return rs;

	}
	@Override
	public int managerUpdateSql(String irumUpdate, ManagerDTO managerDTO) throws SQLException {
		conn = getConnection();
		sql = "update managerzhen set age=?, irum=?, hakbun=? where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, managerDTO.getAge());
		pstmt.setString(2, managerDTO.getIrum());
		pstmt.setString(3, managerDTO.getPart());
		pstmt.setString(4, irumUpdate);
		cnt = managerExecuter();
		return cnt;

	}
}
