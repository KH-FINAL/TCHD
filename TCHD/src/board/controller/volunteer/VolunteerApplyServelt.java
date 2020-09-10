package board.controller.volunteer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Volunteer;
import member.model.vo.Member;
import support.model.service.SupportService;
import support.model.vo.Support;

/**
 * Servlet implementation class VolunteerApplyServelt
 */
@WebServlet("/volunteerApply.bo")
public class VolunteerApplyServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerApplyServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 글 번호
//		int boNo = Integer.parseInt(request.getParameter("volBNo"));
//		
//		
//		
//		Volunteer volunteer = new Volunteer(boNo, memNo);
//		
//		//int result = new BoardService().applyVolunteer(volBNo);
//		int result = new BoardService().applyVolunteer(volunteer);
//		
//		if(result>0) {
//			response.sendRedirect("volunteerList.bo");
//		}else {
//			request.setAttribute("errorMsg", "봉사 신청에 실패했습니다.");
//			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}
		// 다시 도전.
		// 신청하는 사람
		HttpSession session = request.getSession();
		int memNo = ((Member)session.getAttribute("loginUser")).getMem_no();
		
		int volBNo = Integer.parseInt(request.getParameter("volBNo"));
		
		int result = new BoardService().applyVolunteer(volBNo,memNo);
		
		if(result>0) {
			//response.sendRedirect("volunteerDetail.bo?bNo="+volBNo");
			response.getWriter().println("1");
		}else {
			response.getWriter().println("0");
			//request.setAttribute("errorMsg", "봉사 신청에 실패했습니다.");
			//request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
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
