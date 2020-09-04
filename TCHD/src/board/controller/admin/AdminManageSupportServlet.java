package board.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/manageSupport.bo")
public class AdminManageSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminManageSupportServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//ArrayList<Support> supportList = new BoardService().selectManageSupport();
		request.setAttribute("section", "WEB-INF/views/admin/manageSupport_admin.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
