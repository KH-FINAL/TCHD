package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId+"/"+userPwd);
		
		Member member = new Member(userId,userPwd);
		
		Member loginUser = new MemberService().login(member);
		
		if(loginUser!=null) {
			request.getSession().setAttribute("loginUser", loginUser);
			// Session이 기본적으로 갖는 유효 시간은 30분!
			//request.setAttribute("section", "WEB-INF/views/common/main.jsp");
			//response.sendRedirect(request.getContextPath());
			response.getWriter().println("1");
		} else {
//			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
//			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			response.getWriter().println("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
