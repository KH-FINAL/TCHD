package support.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/supportApplySecondForm.su")
public class SupportApplySecondFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupportApplySecondFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price = request.getParameter("price"); // 총 후원 금액
		
		request.setAttribute("price", price);
		
		request.setAttribute("section", "WEB-INF/views/support/support_apply2.jsp");
		response.getWriter().println("1");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
