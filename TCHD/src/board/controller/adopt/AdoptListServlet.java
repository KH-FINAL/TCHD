package board.controller.adopt;

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
 * Servlet implementation class AdoptListFormServlet
 */
@WebServlet(urlPatterns="/adopt.bo", name="AdoptListServlet")
public class AdoptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		HttpSession session = request.getSession();
		
		if((Member)session.getAttribute("loginUser") == null) {
			ArrayList<Adopt> aList = service.selectTList(1);
			ArrayList<Files> fList = service.selectTList(2);
			
			if(aList != null && fList != null) {
				request.setAttribute("aList", aList);
				request.setAttribute("fList", fList);
				request.setAttribute("section", "WEB-INF/views/adopt/adoptList.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "입양 게시판 조회에 실패하였습니다.");
				request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			String userId = ((Member)session.getAttribute("loginUser")).getMem_id();
			
			ArrayList<Adopt> aList = service.selectTList(1);
			ArrayList<Files> fList = service.selectTList(2);
			
			if(aList != null && fList != null) {
				request.setAttribute("userId", userId);
				request.setAttribute("aList", aList);
				request.setAttribute("fList", fList);
				request.setAttribute("section", "WEB-INF/views/adopt/adoptList.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "입양 게시판 조회에 실패하였습니다.");
				request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
