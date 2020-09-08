package support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/supportListForm.su")
public class SupportListFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupportListFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String checkSupNo = (String)request.getAttribute("checkSupNo");
		
		if(session.getAttribute("loginUser") == null) {
			// 비회원
			if(checkSupNo == null) {
				// 후원 번호 체크 안됐으면 체크하러
				request.setAttribute("section", "WEB-INF/views/support/supportCheckSupNo.jsp");
			} else {
				// 후원 번호 체크 됐으면
				request.setAttribute("section", "WEB-INF/views/support/supportList.jsp");
			}
		} else {
			// 회원 (로그인)
			request.setAttribute("section", "WEB-INF/views/support/supportList.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
