package common;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class mailTest
 */
@WebServlet("/mailTest.mail")
public class mailTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메일 서블릿 접근  ");
		
		request.setCharacterEncoding("UTF-8");

	      // 보내는 사람
	      String smtpServer = "smtp.gmail.com";
//	      final String sendId = ""; // 네이버 아이디의 경우 필요
	      final String sendPass = "rlgus0929!"; // 비밀번호
	      String sendEmailAddress = "izevolf@gmail.com"; // 이메일주소(네이버)
	      int smtpPort = 587;
	      
	      String subject = "안녕하세요. '함께하묘 행복하개'입니다."; // ---제목
	
	      String content = "안녕하세요. 테스트 메일이에용.";
	      
	      try {
	          Properties props = System.getProperties();
	          props.put("mail.smtp.starttls.enable", "true");
	          props.put("mail.smtp.host", smtpServer);
	          props.put("mail.smtp.port", smtpPort);
	          props.put("mail.smtp.auth", "true");
	          Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	             protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(sendEmailAddress, sendPass);
	             }
	          });
	          session.setDebug(true); // for debug
	          Message mimeMessage = new MimeMessage(session);
	          mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
	          // 받는 사람 메일주소 입력
	          mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("oporingo@naver.com"));
	          mimeMessage.setSubject(subject);
	          mimeMessage.setText(content);
	          Transport.send(mimeMessage);
	          response.setContentType("text/html; charset=UTF-8");
	        
	      }catch(Exception e) {
	    	e.printStackTrace();
	      }
	
	}
	
	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
