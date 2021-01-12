package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends HaksaDAO implements IProfessorDAO {

	public ProfessorDAO() throws ClassNotFoundException {

	}
	@Override
	public void professorRegisterSql(ProfessorDTO professorDTO) throws SQLException {
		sql = "insert into professorzhen(age,irum,hakbun) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, professorDTO.getAge());
		pstmt.setString(2, professorDTO.getIrum());
		pstmt.setString(3, professorDTO.getSubject());
	}// 준비

	@Override
	public ResultSet professorListSql() throws SQLException {

		conn = getConnection();
		sql = "select no,age,irum,hakbun from professorzhen";
		pstmt = conn.prepareStatement(sql);
		rs = professorExecuter(rs);
		rs = pstmt.executeQuery();

		return rs;
	}
	@Override
	public int professorDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from professorzhen where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = professorExecuter();
		return cnt;

	}
	@Override
	public ResultSet professorSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no, age, irum, hakbun from professorzhen where irum = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		pstmt.executeQuery();
		rs = professorExecuter(rs);
		return rs;

	}
	@Override
	public int professorUpdateSql(String irumUpdate, ProfessorDTO professorDTO) throws SQLException {
		conn = getConnection();
		sql = "update professorzhen set age=?, irum=?, hakbun=? where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, professorDTO.getAge());
		pstmt.setString(2, professorDTO.getIrum());
		pstmt.setString(3, professorDTO.getSubject());
		pstmt.setString(4, irumUpdate);
		cnt = professorExecuter();
		return cnt;

	}

}