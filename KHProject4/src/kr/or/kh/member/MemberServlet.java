package kr.or.kh.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kh.board.BoardDAO;
import kr.or.kh.board.BoardDTO;

@WebServlet("*.mb")
public class MemberServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
         private MemberDTO memberDTO;
       private MemberDAO memberDAO;
       private int cnt;
       private ArrayList<MemberDTO> memberList;
       private String id;
       private String pw;
       private HttpSession session;
       
       public MemberServlet() {
          memberList = new ArrayList<MemberDTO>();
          memberDTO= new MemberDTO();
          memberDAO= new MemberDAO();
       }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
      doPost(request, response);
   }
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            String requestURI = request.getRequestURI();
            String contextPath = request.getContextPath();
            String command = requestURI.substring(contextPath.length());
            
            //HttpSession session=request.getSession();
            if(command.equals("/memberRegister.mb")) {//멤버등록
               memberDTO.setId(request.getParameter("id"));
               memberDTO.setPw(request.getParameter("pw"));
               memberDTO.setAddr(request.getParameter("addr"));
               memberDTO.setTel(request.getParameter("tel"));
               try {
                  cnt=memberDAO.memberRegister(memberDTO);
                  out.print(cnt+"건 회원이 등록되었습니다.");
                  response.sendRedirect("memberList.mb");
               } catch (Exception e) {
                  e.printStackTrace();
               }
               }//게시판등록
            else if(command.equals("/memberList.mb")) {//멤버전체출력
               try {
                  memberList = memberDAO.memberList();
                  RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberList");//RequestDispatcher 배열값도 보내고
                  request.setAttribute("memberList", memberList);//보드리스트라는 이름으로 보드리스트에 등록함
                  dis.forward(request, response);
               } catch (SQLException e) {
                  e.printStackTrace();
               }
               }//전체출력
            else if(command.equals("/memberLogin.mb")) {
               id=request.getParameter("id");
               pw=request.getParameter("pw");
               try {
               memberDTO=memberDAO.memberLogin(id,pw);
            } catch (SQLException e) {
               e.printStackTrace();
            }
                if(!id.equals(memberDTO.getId())){
                   out.print("아이디가틀렸습니다.");
                }else if(!pw.equals(memberDTO.getPw())){
                   out.print("비밀번호가 일치하지 않습니다.");
                }else{
                   out.print("환영합니다.");
                   session = request.getSession();
                   session.setAttribute("pw", pw);
                }
              response.sendRedirect("index.jsp?page=kh");
            }//로그인
            
            else if(command.equals("/memberLogout.mb")) {
               session.invalidate();//세션에들어있는값 모두 제거해줌
               response.sendRedirect("index.jsp?page=kh");
            }
            else if(command.equals("/memberDelete.mb")) {
            	String pw = request.getParameter("pw");
            	String sessionPW = (String)session.getAttribute("pw");
            	if(pw.equals(sessionPW)) {
            		String deleteId= (String)session.getAttribute("id");
            		String deletePw= (String)session.getAttribute("pw");
            	  	try {
                    	int cnt =memberDAO.memberDelete(deleteId,deletePw);
                    	out.print("<script>alert('탈퇴되었습니다.'); location.href='memberLogout.mb'</script>");
        
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
            	}else {
            		out.print("<a href=# onclick=test()> 비밀번호 틀림 </a>");
            	}
              }
            else if(command.equals("/idcheckConfirm.mb")) {
               
               String telSearch=request.getParameter("tel");//폼 액션에서 넘어올때는 겟파라미터
               String id=null;
               try {
               id=memberDAO.memberIdcheck(telSearch);
               out.print(id+"검색하신 아이디 입니다.<br>");
               out.print("<a href=index.jsp?page=kh>메인으로</a>");
            } catch (SQLException e) {
               e.printStackTrace();
            }
            }
            else if(command.equals("/passcheckConfirm.mb")) {   
               String id=request.getParameter("id");
               try {
               String pw= memberDAO.memberPwcheck(id);
               out.print(pw+"는 검색하신 아이디에  비밀번호  입니다.<br>");
               out.print("<a href=index.jsp?page=kh>메인으로</a>");
            } catch (SQLException e) {
               e.printStackTrace();
            }
               
            }
            else if (command.equals("/memberUpdateConfirm.mb")) {  
               String id=request.getParameter("id");
              try {
               memberDTO=memberDAO.memberUpdateConfirm(id);
               RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberUpdateConfirm");
               request.setAttribute("memberDTO", memberDTO);
               dis.forward(request, response);
            } catch (SQLException e) {
               e.printStackTrace();
            }
            }
            
            
              else if(command.equals("/memberUpdateFinal.mb")) {
                 memberDTO.setId(request.getParameter("id"));
                 memberDTO.setPw(request.getParameter("pw"));
                 memberDTO.setAddr(request.getParameter("addr"));
                 memberDTO.setTel(request.getParameter("tel"));
                 String idSearch=request.getParameter("idSearch");
                 try {
					cnt = memberDAO.memberUpdateFinal(memberDTO,idSearch);
				 response.sendRedirect("memberList.mb");

                 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }
              else if(command.equals("/idcheck.mb")) {
            	  String idSearch = request.getParameter("id");
       
            	  try {
					ResultSet rs = memberDAO.memberIdCheckall(idSearch);
					while(rs.next()) {
						memberDTO.setId(rs.getString("id"));
					}
					if(idSearch.equals(memberDTO.getId())) {
						out.print("이미 있는 아이디입니다.<br>");
				
						out.print("<input type='button' value='종료' onClick='self.close()'>");
					}else {
						out.print("사용 가능한 아이디입니다.<br>");
						
						out.print("<input type='button' value='종료' onClick='self.close()'>" );
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	  
              }
            }
            }
   


