package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Volunteer;

/**
 * Servlet implementation class VolunteerInsertServlet
 */
@WebServlet("/volunteerInsert.bo")
public class VolunteerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String boTitle = request.getParameter("boTitle");
		String voArea = request.getParameter("voArea");
		String voDate = request.getParameter("voDate");
		String voPlace = request.getParameter("voPlace");
		String voMaxmember = request.getParameter("voMaxmember");
		String voComment = request.getParameter("voComment");
		
//		Volunteer volunteer = new Volunteer(boTitle, voArea, voDate, voPlace, voMaxmember, voComment);
//		int result = new BoardService().selectVolunteer(volunteer);
//		
//		if(result > 0) {
//			response.sendRedirect("volunteerList.bo");
//		} else {
//			request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
