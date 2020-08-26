package member.model.service;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;


import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn,member);
		int result2= 0;
		if(result>0) {
		
			result2 = new MemberDAO().insertMember_2Phase(conn,member);
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result2;
	}

	public Member login(Member member) {
		Connection conn= getConnection();
		Member loginUser = new MemberDAO().login(conn,member);
		
		close(conn);
		return loginUser;
		
	}

	public int checkId(String inputId) {
		Connection conn =getConnection();
		int result = new MemberDAO().checkId(conn,inputId);
		
		close(conn);
		
		return result;
	}

	public int confirmPw(String loginUserId, String inputPw) {
		Connection conn= getConnection();
		int result= new MemberDAO().confirmPw(conn,loginUserId,inputPw);
		close(conn);
		return result;
	}

	public Member selectMemberPm(String memberId) {
		Connection conn = getConnection();
		Member member = new MemberDAO().selectMemberPm(conn,memberId);
		
		close(conn);
		
		return member;
	}

	public Member selectMemberGm(String memberId) {
		Connection conn = getConnection();
		Member member = new MemberDAO().selectMemberGm(conn,memberId);
		
		close(conn);
		
		return member;
	}

	public int updateMemberPm(Member member) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
	
		int result = mDAO.updateMember(conn, member);		
		
		if(result>0) {
			
			int result2 = mDAO.updateMemberPm(conn, member);
			if(result2>0) {				
				commit(conn);
			}
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateMemberGm(Member member) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
		int result = mDAO.updateMember(conn, member);
		
		if(result>0) {
			int result2 = mDAO.updateMemberGm(conn,member);
			if(result2>0) {
				commit(conn);
			}
		}else {
			
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Member findId(Member member) {
		Connection conn = getConnection();
		
		Member findUser = new MemberDAO().findId(conn, member);
		
		close(conn);
		
		return findUser;
	}
}
