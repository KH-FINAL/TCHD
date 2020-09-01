package board.controller.adopt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.AdoptApply;
import board.model.vo.Board;
import member.model.vo.Member;

/**
 * Servlet implementation class AdoptDeleteServlet
 */
@WebServlet(urlPatterns="/adoptApply.bo", name="AdoptApplyServlet")
public class AdoptApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loginUserNo = ((Member)request.getSession().getAttribute("loginUser")).getMem_no();		// ??? 왜 null이야 로그인 했는데
		String answer = request.getParameter("answer1" + ", " + "answer2" + ", " + "answer3" + ", " + 
											"answer4" + ", " + "answer5" + ", " + "answer6" + ", " + "answer7");
		System.out.println("입양신청서 : " + answer);
		
		Board b = new Board(0, null, "입양신청서", answer, null, 0, null, loginUserNo);
		AdoptApply apply = new AdoptApply(answer, loginUserNo);
		
		int result = new BoardService().insertApply(b, apply);
		
		int bNo = b.getBoNo();
		if(result > 0) {
			response.sendRedirect("adoptDetail.bo?bNo=" + bNo);
		} else { 
			request.setAttribute("msg", "입양 신청서 작성에 실패하였습니다.");
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
