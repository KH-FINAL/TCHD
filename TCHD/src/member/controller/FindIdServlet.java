package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.TestMail;
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
		String text = "";

		Member member = new Member(0, "",name, email); // 생성자가 겹쳐서 mem_no, mem_id, mem_name, mem_email로 사용
		
		Member findUser = new MemberService().findId(member);
		
		if(findUser != null) {
			// 이메일 전송
			try {
				String id =findUser.getMem_id();
				String cut_id = id.substring(0, 3);
				text = 
						"<div style=\"border: 3px solid #2980b9; width: 800px; text-align: center; padding-top: 15px;\">\r\n" + 
						"		<div style=\"padding: 15px; line-height:600%;\">\r\n" + 
						"			<img src=\"https://docs.google.com/drawings/u/0/d/sytGzgCQNFh-6-SoDUlhdfQ/image?w=565&h=99&rev=3&ac=1&invite&parent=15LgYQdQFbkv1-vWBxBquFV0jA7Ire5vxVXXHF_-c56A\">\r\n" + 
						"			<hr style=\"border:5px dashed lightgray;\">\r\n" + 
						"			<b style=\"font-size: 17px;\"><< 아이디/비밀번호 안내 메일 >></b>\r\n" + 
						"			<div style=\"font-size: 19px; font-weight: 800;\">\r\n" + 
						"				<span>회원님의 아이디는 </span>\r\n" + 
						"				<span style=\"color: #008eeb;\">" + cut_id + "***</span>\r\n" + 
						"				<span>입니다.</span>\r\n" + 
						"			</div>\r\n" + 
						"			<hr style=\"border:1.5px solid lightgray; width:60%;\">\r\n" + 
						"			<div style=\"font-weight: 550; line-height:200%;\">\r\n" + 
						"				저희 ♡함께하묘 행복하개♡를 이용해주셔서 감사합니다.<br>\r\n" + 
						"				더욱 편리한 서비스를 제공하기 위해 항상 최선을 다하겠습니다.\r\n" + 
						"			</div>\r\n" + 
						"		</div>\r\n" + 
						"		<br><br>\r\n" + 
						"		<div style=\"background: #eee; padding: 20px; line-height:250%;\">\r\n" + 
						"			함께하묘 행복하개&nbsp;&nbsp;|&nbsp;&nbsp;서울시 강남구 역삼동 어쩌구 123 (우) 12345&nbsp;&nbsp;|&nbsp;&nbsp;대표자 : 김대표\r\n" + 
						"			<br>\r\n" + 
						"			TEL : 02-123-4567&nbsp;&nbsp;|&nbsp;&nbsp;FAX : 02-345-6789&nbsp;&nbsp;|&nbsp;&nbsp;EMAIL : abcd@naver.com&nbsp;&nbsp;|&nbsp;&nbsp;사업자등록번호 : 123-45-67890\r\n" + 
						"		</div>\r\n" + 
						"	</div>\n";
				
				new TestMail().sendEmail(email, text);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("메일 전송 완료");
			
			request.setAttribute("section", "WEB-INF/views/common/main.jsp");
			response.sendRedirect(request.getContextPath());
			
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
