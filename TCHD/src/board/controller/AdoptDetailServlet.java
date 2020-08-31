package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Adopt;
import board.model.vo.Files;
import member.model.vo.Member;

/**
 * Servlet implementation class AdoptDetailServlet
 */
@WebServlet(urlPatterns="/adoptDetail.bo", name="AdoptDetailServlet")
public class AdoptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		String userId = ((Member)session.getAttribute("loginUser")).getMem_id();
//		System.out.println("입양 상세보기 userId : " + userId);
		
		
		int bNo = Integer.parseInt(request.getParameter("boNo"));
		
		BoardService service = new BoardService();
		Adopt adopt = service.selectedAdopt(bNo); 	// 입양게시판 디테일 조회  --> ADETAIL 뷰 만들기
		ArrayList<Files> fileList = service.selectNoticeFile(bNo);
		
		if(adopt != null && fileList != null ) {	// 왜 비회원일 때는 상세보기가 안되는겨..
			request.setAttribute("adopt", adopt);
			request.setAttribute("fileList", fileList);
			request.setAttribute("section", "WEB-INF/views/adopt/adoptDetail.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "입양게시판 상세보기에 실패하였습니다.");
			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
