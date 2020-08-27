package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/leave.me")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeaveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("input_pwd");
		
		// 현재 로그인 되어있는 아이디 가져오기
		HttpSession session = request.getSession();
		String loginUserId = ((Member)session.getAttribute("loginUser")).getMem_id();
		
		Member member = new Member(loginUserId, pwd);
		
		int result = new MemberService().confirmPw(member);
		
		if(result != 0) {
			session.invalidate(); // 로그아웃
			
//			response.sendRedirect(request.getContextPath());
//			request.setAttribute("section", "WEB-INF/views/common/main.jsp");
			
			request.setAttribute("msg", "회원탈퇴가 완료되었습니다.");
			request.setAttribute("section", "WEB-INF/views/common/successPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "회원 탈퇴에 실패하였습니다.");
			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
