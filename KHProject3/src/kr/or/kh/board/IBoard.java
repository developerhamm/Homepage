package kr.or.kh.board;


import java.sql.SQLException;
import java.util.ArrayList;

public interface IBoard {
	public abstract int boardWrite(BoardDTO boardDTO) throws SQLException;
	public abstract ArrayList<BoardDTO> boardList()throws SQLException;
	public abstract int boardDelete(int no) throws SQLException;
	public abstract BoardDTO boardSearch(String titleSearch) throws SQLException;
	public abstract void boardReadCount(BoardDTO boardDTO) throws SQLException;
	public abstract int boardUpdateFinal(BoardDTO boardDTO,String titleSearch) throws SQLException;
	public abstract int totalCount();
	public abstract PageTo page(int curPage);
}
