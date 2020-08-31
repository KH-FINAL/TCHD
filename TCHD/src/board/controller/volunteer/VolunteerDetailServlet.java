package board.controller.volunteer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Notice;
import board.model.vo.Volunteer;

/**
 * Servlet implementation class VolunteerDetailServlet
 */
@WebServlet("/volunteerDetail.bo")
public class VolunteerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		Volunteer volunteer = new BoardService().selectVolunteer(bNo);
		
		HttpSession session = request.getSession();
		
		if(volunteer != null) {
			request.setAttribute("section", "WEB-INF/views/volunteer/volunteerDetail.jsp");
			request.setAttribute("volunteer", volunteer);
		} else {
			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
			request.setAttribute("msg", "문의게시글 상세조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
