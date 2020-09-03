package board.controller.adopt;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.vo.Adopt;
import member.model.vo.Member;

/**
 * Servlet implementation class AdoptUpdateForm
 */
@WebServlet(urlPatterns="/adoptUpdateForm.bo", name="AdoptUpadateFormServlet")
public class AdoptUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유저 정보 및 게시글 번호
		HttpSession session = request.getSession();
		String userPhone = ((Member)session.getAttribute("loginUser")).getMem_phone();
		int bNo = Integer.parseInt(request.getParameter("boNo"));
		
		// insert 했던 입양 동물 정보
		String petKind = request.getParameter("petKind");		// 동물 구분 체크박스
		String petGender = request.getParameter("petGender");	// 동물성별 체크박스;
		String unigender = request.getParameter("unigender");		// 중성화 여부
		String petSize = request.getParameter("petSize");			// 크기
		String petAge = request.getParameter("petAge"); 			// 나이
		String petName = request.getParameter("petName");			// 이름
		String petCategory = request.getParameter("petCategory");	// 품종
		float petWeight = Float.valueOf(request.getParameter("petWeight"));	// 무게
		String petColor = request.getParameter("petColor");		// 색깔
		String rescue = request.getParameter("rescue");
		String lastMent = request.getParameter("lastMent");		// 하고 싶은 말
		
		// insert 했던 파일 정보
		String thumbnail = request.getParameter("thumbnail");
		
		String contentImg1 = ""; 
		String contentImg2 = ""; 
		String contentImg3 = ""; 
		if(request.getParameter("contentImg1") != null ) {
			contentImg1 = request.getParameter("contentImg1");
		}
		
		if(request.getParameter("contentImg2") != null ) {
			contentImg2 = request.getParameter("contentImg2");
		}

		if(request.getParameter("contentImg3") != null ) {
			contentImg3 = request.getParameter("contentImg3");
		}
		
		Adopt adopt = new Adopt(petKind, petCategory, petGender, unigender, petName, petAge, 
								rescue, petWeight, petColor, petSize, lastMent);
		
		request.setAttribute("bNo", bNo);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("adopt", adopt);
		request.setAttribute("thumbnail", thumbnail);
		request.setAttribute("contentImg1", contentImg1);
		request.setAttribute("contentImg2", contentImg2);
		request.setAttribute("contentImg3", contentImg3);
		request.setAttribute("section", "WEB-INF/views/adopt/adoptUpdate.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
