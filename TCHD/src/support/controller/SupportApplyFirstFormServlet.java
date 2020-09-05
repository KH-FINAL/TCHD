package support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

@WebServlet("/supportApplyFirstForm.su")
public class SupportApplyFirstFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupportApplyFirstFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginUser"));
		if(session.getAttribute("loginUser") != null) {
			request.setAttribute("section", "WEB-INF/views/support/support_apply1.jsp");
		} else {
			request.setAttribute("section", "WEB-INF/views/support/support_nonmember1.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
