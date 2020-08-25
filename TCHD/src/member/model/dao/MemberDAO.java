package member.model.dao;
import static common.JDBCTemplate.close;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	Properties prop =new Properties();
	
	public MemberDAO() {
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, member.getMem_type());
			pstmt.setString(2, member.getMem_id());
			pstmt.setString(3, member.getMem_pw());
			pstmt.setString(4, member.getMem_name());
			pstmt.setString(5, member.getMem_phone());
			pstmt.setString(6, member.getMem_addr());
			pstmt.setString(7, member.getMem_email());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertMember_2Phase(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result =0;
		try {
			if(member.getMem_type().equals("PM")) {
				pstmt = conn.prepareStatement(prop.getProperty("insertMemberPm"));
				pstmt.setDate(1, member.getPm_birth());
				result = pstmt.executeUpdate();
			}else {
				pstmt = conn.prepareStatement(prop.getProperty("insertMemberGm"));
				pstmt.setString(1, member.getGm_regno());
				pstmt.setString(2, member.getGm_name());
				result = pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Member login(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pw());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(
						rset.getString("MEM_TYPE"),
						rset.getString("MEM_ID"),
						rset.getString("MEM_NAME")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public int checkId(Connection conn, String inputId) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkId"));
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int confirmPw(Connection conn, String loginUserId,String inputPw) {
		PreparedStatement pstmt;
		ResultSet rset=null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("confirmPw"));
			pstmt.setString(1, loginUserId);
			pstmt.setString(2, inputPw);
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Member selectMemberPm(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberPm"));
			pstmt.setString(1, memberId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(
							rset.getInt("MEM_NO"),
							rset.getString("MEM_PW"),
							rset.getString("MEM_NAME"),
							rset.getString("MEM_PHONE"),
							rset.getString("MEM_ADDR"),
							rset.getString("MEM_EMAIL"),
							rset.getDate("PM_BIRTH")
						);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public Member selectMemberGm(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberGm"));
			pstmt.setString(1, memberId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(
							rset.getInt("MEM_NO"),
							rset.getString("MEM_PW"),
							rset.getString("MEM_NAME"),
							rset.getString("MEM_PHONE"),
							rset.getString("MEM_ADDR"),
							rset.getString("MEM_EMAIL"),
							rset.getString("GM_REGNO"),
							rset.getString("GM_NAME")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(member.getMem_pw());
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
			pstmt.setString(1, member.getMem_pw());
			pstmt.setString(2, member.getMem_name());
			pstmt.setString(3, member.getMem_phone());
			pstmt.setString(4, member.getMem_addr());
			pstmt.setString(5, member.getMem_email());
			pstmt.setString(6, member.getMem_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	

	public int updateMemberPm(Connection conn, Member member) {
		PreparedStatement pstmt= null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMemberPm"));
			pstmt.setDate(1, member.getPm_birth());
			System.out.println(member.getMem_no());
			pstmt.setInt(2, member.getMem_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}

	public int updateMemberGm(Connection conn, Member member) {
		PreparedStatement pstmt= null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMemberGm"));
			pstmt.setString(1, member.getGm_regno());
			pstmt.setString(2, member.getGm_name());
			pstmt.setInt(3, member.getMem_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}




}
