package kr.or.kh.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.bo")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardDTO boardDTO;
    private BoardDAO boardDAO;
    private int cnt;
    private ArrayList<BoardDTO> boardList;
    private String titleSearch;
    public BoardServlet() {
    	boardDTO = new BoardDTO();
    	boardDAO = new BoardDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/boardRegister.bo")) {//게시판등록
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setAuthor(request.getParameter("author"));
            boardDTO.setNal(request.getParameter("nal"));
            boardDTO.setReadcount(Integer.parseInt(request.getParameter("readcount")));
            try {
				cnt=boardDAO.boardWrite(boardDTO);
				out.print(cnt+"건 게시글이 등록되었습니다.");
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//게시판등록
        else if(command.equals("/boardList.bo")){//목록			
			int curPage = 1;//기본페이지
			if(request.getParameter("curPage")!=null){
				curPage = Integer.parseInt(request.getParameter("curPage"));				
			}			
			PageTo boardList=boardDAO.page(curPage);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/listPage");
			request.setAttribute("page", boardList);
			//listPage.jsp에서 목록 리스트 데이터 저장
			request.setAttribute("list", boardList.getList());
			//page.jsp에서 페이징 처리 데이터 저장
			dis.forward(request, response);
			
		}//목록
		/*else if(command.equals("/boardList.bo")) {//게시판전체출력
			try {
				boardList = boardDAO.boardList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
				request.setAttribute("boardList", boardList);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//게시판전체출력
		*/
		else if(command.equals("/boardDelete.bo")) {
			String no1 = request.getParameter("no");
			int no = Integer.parseInt(no1);
			try {
				cnt = boardDAO.boardDelete(no);
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardSearch.bo")) {
			String titleSearch = request.getParameter("titleSearch");
			String readcount = request.getParameter("readcount");
			try {
				boardDTO = boardDAO.boardSearch(titleSearch);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardSearch");
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		else if(command.equals("/boardUpdateSearch.bo")) {
			titleSearch = request.getParameter("titleSearch");
			try {
				boardDTO = boardDAO.boardSearch(titleSearch);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardUpdateConfirm");
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("/boardUpdateFinal.bo")) {
			titleSearch = request.getParameter("titleSearch");
			boardDTO.setNo(Integer.parseInt(request.getParameter("no")));
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setAuthor(request.getParameter("author"));
			boardDTO.setNal(request.getParameter("nal"));
			boardDTO.setReadcount(Integer.parseInt(request.getParameter("readcount")));
			try {
				cnt=boardDAO.boardUpdateFinal(boardDTO,titleSearch);
				boardList = boardDAO.boardList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
				request.setAttribute("boardList", boardList);
				dis.forward(request, response);				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
