package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Volunteer;
import member.model.vo.Member;

/**
 * Servlet implementation class MyVolunteerListServlet
 */
@WebServlet("/listMyVolunteer.vo")
public class MyVolunteerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyVolunteerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mem_no = ((Member)request.getSession().getAttribute("loginUser")).getMem_no();
		
		ArrayList<Volunteer> volunteerList = new BoardService().selectMyVolunteer(mem_no);
		
		request.setAttribute("volunteerList", volunteerList);
		request.setAttribute("section", "WEB-INF/views/member/listMyVolunteer_myPage.jsp");
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
