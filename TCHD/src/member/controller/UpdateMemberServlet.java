package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateMemberServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("userNo"));
		String name = request.getParameter("userName");
		String pwd_ori = request.getParameter("originalPwd");		
		String pwd = request.getParameter("userPwd");
	
		String phone  = request.getParameter("userPhone");
		String zonecode= request.getParameter("zoneCode");
		String address = request.getParameter("mainAddress");
		String address2 = request.getParameter("detailAddress");
		String addressTotal =null;
		if(!zonecode.equals("")) {
			addressTotal = zonecode+","+address+","+address2;
		}
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String emailTotal = email+"@"+email2;
		
		String birth = request.getParameter("userBirth");  // 개인회원
		String[] birthArr= birth.split("-");
		int year =Integer.parseInt(birthArr[0]);
		int month=Integer.parseInt(birthArr[1])-1;
		int day= Integer.parseInt(birthArr[2]);
		Date birth2 = new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
		
		String gmname = request.getParameter("joinGmName");  // 단체회원
		String regno = request.getParameter("joinRegNo");
		
		String id = ((Member)request.getSession().getAttribute("loginUser")).getMem_id();
		String memberType = ((Member)request.getSession().getAttribute("loginUser")).getMem_type();
		
		Member member = null;
		if(memberType.equals("PM")) {  // 개인회원일 경우 
			if(!pwd.equals("")) {   // 비밀번호까지 수정할 경우
				member = new Member(no,memberType,id,pwd,name,phone,addressTotal,emailTotal,birth2);		
			}else {   // 비밀번호는 수정하지 않을 경우
				member = new Member(no,memberType,id,pwd_ori,name,phone,addressTotal,emailTotal,birth2);		
			}
			int result  = new MemberService().updateMemberPm(member);
			
			if(result>0) {
				response.sendRedirect("myPage.me");
			}else {
				request.setAttribute("errorMsg", "회원정보 수정 중 에러가 발생하였습니다.");
				request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else {
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
