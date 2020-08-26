package common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMail {

	public void sendEmail(String to, String text) throws Exception {
		// to : 받는 사람	text : 메일 내용
		Properties prop = new Properties();

		// 프로토콜 설정
		prop.put("mail.transport.protocol", "smtp");
		// gmail SMTP 서비스 주소(호스트)
		prop.put("mail.smtp.user", "izevolf.gmail.com");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		// gmail SMTP 서비스 포트 설정
		prop.put("mail.smtp.port", "465");
		// 로그인할 때 TLS를 사용할 것인지 설정 ==> gmail에서는 TLS가 필수가 아님
		prop.put("mail.smtp.starttls.enable", "true"); // ↑따라서 생략 가능???
		// gmail 인증용 SSL 설정 ==> gmail에서 인증할 때 사용하므로 필수
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// SMTP 인증 설정
		prop.put("mail.smtp.auth", "true");

		prop.put("mail.smtp.debug", "true");
		prop.put("mail.smtp.socketFactory.fallback", "false");

		// Authenticator : 네트워크 접속에 필요한 인증을 취득하기 위한 객체
		// 암호 인증을 사용하기 위해 호출
		Authenticator auth = new SMTPAuthenticator();
		Session mailSession = Session.getDefaultInstance(prop, auth);
		// 메일을 전송할 때의 상황 출력
		mailSession.setDebug(true);

		// create a message
		Message msg = new MimeMessage(mailSession);

		// set the from and to address
		// 보내는 사람 설정
		msg.setFrom(new InternetAddress("izevolf@gmail.com"));
		// 받는 사람 설정
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

		// setting the subject and content type
		// 제목 설정
		msg.setSubject("안녕하세요. ♡함께하묘 행복하개♡ 입니다.");
		// 내용 설정
//		msg.setText(text);
		msg.setContent(text, "text/html; charset=UTF-8;");
		// 보내는 날짜 설정
		msg.setSentDate(new Date());

		Transport.send(msg);
	}
}
