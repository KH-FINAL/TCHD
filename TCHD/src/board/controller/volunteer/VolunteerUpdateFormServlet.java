package board.controller.volunteer;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.vo.Volunteer;
import member.model.vo.Member;

/**
 * Servlet implementation class VolunteerUpdateFormServlet
 */
@WebServlet("/volunteerUpdateForm.bo")
public class VolunteerUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String volMemId = request.getParameter("volMemId");
		String volMemNo = request.getParameter("volMemNo");
		
		int volBNo = Integer.parseInt(request.getParameter("volBNo"));
		System.out.println(volBNo);
		
		String volCateName = request.getParameter("volCateName");
		System.out.println(volCateName);
		
		String volBoTitle = request.getParameter("volBoTitle");
		System.out.println(volBoTitle);
		
		String voArea = request.getParameter("voArea");
		
		// 봉사 일시. (주석처리해둔 시간까지 받으면 배열 오류 남.)
		String voDate2 = request.getParameter("voDate");
		String[] vo_dateArr = voDate2.split("-");
		int year = Integer.parseInt(vo_dateArr[0]);
		int month = Integer.parseInt(vo_dateArr[1])-1;
		int day = Integer.parseInt(vo_dateArr[2].split("T")[0]);
//		int hour = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[0]);
//		int min = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[1]);
//		System.out.println("convert_voDate : " + year + "-" + (month + 1) + "-" + day + " " + hour + " : " + min);
		System.out.println("convert_voDate : " + year + "-" + (month + 1) + "-" + day);
//		Date voDate = new Date(new GregorianCalendar(year, month, day, hour, min).getTimeInMillis());
		Date voDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		
		// 봉사지. (안됨)
		String zonecode= request.getParameter("zoneCode");
		String address = request.getParameter("joinAddress");
		String address2 = request.getParameter("joinAddress2");
//		String voPlace = null;
//		if(!zonecode.equals("")) {
//			voPlace = "("+zonecode+")"+" "+address+", "+address2;
//		}
		
		// 봉사 정원.
		String voMaxmember2 = request.getParameter("voMaxmember");
		int voMaxmember = Integer.parseInt(voMaxmember2);
		
		// 내용.
		String voComment = request.getParameter("voComment");
		
		// 글쓴 날짜(받아와야 하나?)
		String boDate2 = request.getParameter("boDate");
		String[] bo_dateArr = boDate2.split("-");
		int boYear = Integer.parseInt(vo_dateArr[0]);
		int boMonth = Integer.parseInt(vo_dateArr[1])-1;
		int boDay = Integer.parseInt(vo_dateArr[2].split("T")[0]);
		Date boDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		System.out.println(boDate);
		
		int fileNo=0;
		if(request.getParameter("volunteerFileNo")!=null) {
			fileNo = Integer.parseInt(request.getParameter("volunteerFileNo"));
		}
		
//		Volunteer volunteer = new Volunteer(volBNo, volCateName, boTitle, voDate, voPlace, boDate, voMaxmember, voComment);
		Volunteer volunteer = new Volunteer(volBNo, volCateName, volBoTitle, voDate, boDate, voMaxmember, voComment);
		System.out.println(volunteer);
		request.setAttribute("fileNo", fileNo);
		request.setAttribute("volunteer", volunteer);
		request.setAttribute("section", "WEB-INF/views/volunteer/volunteerUpdate.jsp");
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