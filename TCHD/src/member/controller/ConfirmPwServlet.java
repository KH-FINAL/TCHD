package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/confirmPw.me")
public class ConfirmPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConfirmPwServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputPw= request.getParameter("inputPw");
		String loginUserId = ((Member)request.getSession().getAttribute("loginUser")).getMem_id();
		System.out.println(inputPw);
		System.out.println(loginUserId);
		System.out.println(loginUserId);

		
		
		int result = new MemberService().confirmPw(loginUserId,inputPw);
		if(result>0) {
			request.getSession().setAttribute("confirmPw", "confirmed");
			response.sendRedirect("myPage.me");
		}else {
			response.sendRedirect("myPage.me");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
