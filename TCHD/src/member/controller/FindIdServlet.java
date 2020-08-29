package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.sendMail;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/findId.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("input_name");
		String email = request.getParameter("input_email");
		System.out.println(name+"/"+email);
		Member member = new Member(0, "",name, email); // 생성자가 겹쳐서 mem_no, mem_id, mem_name, mem_email로 사용
		
		Member findUser = new MemberService().findId(member);
		
		if(findUser != null) {
			// 이메일 전송
			try {
				String id =findUser.getMem_id();
				String cut_id = id.substring(0, 3);
				
				new sendMail().sendEmail("id", email, cut_id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("메일 전송 완료_id");
			
			// "메일 전송 완료"가 콘솔창에 찍힘과 동시에 메인화면으로 이동
			// 확인 버튼을 누른 시간 ~ 메일이 전송되는 시간
			// 이 사이 시간에 "잠시만 기다려주세요" 이런 멘트를 화면에 띄우고 싶은데
			// 고민 좀!
			
			response.getWriter().println("1");
//			response.sendRedirect(request.getContextPath());
//			request.setAttribute("section", "WEB-INF/views/common/main.jsp");
			
		} else {
			request.setAttribute("errorMsg", "아이디 찾기에 실패하였습니다.");
			request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
