package support.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import support.model.vo.Support;

public class SupportDAO {
	Properties prop = new Properties();
	
	public SupportDAO() {
		String fileName = SupportDAO.class.getResource("/sql/support/support-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectMemNo(Connection conn, Support support) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int mem_no = 0;
		
		String query = prop.getProperty("selectMemNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, support.getMem_id());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mem_no = rset.getInt("mem_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mem_no;
	}
	
	public int applyMem(Connection conn, Support support) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("applyMem");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, support.getMem_no());
			pstmt.setInt(2, support.getSup_price());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int applyNonMem(Connection conn, Support support) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("applyNonMem");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, support.getSup_price());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectSupNo(Connection conn, Support support) {
		Statement stmt = null;
		ResultSet rset = null;
		int sup_no = 0;
		
		String query = prop.getProperty("selectSupNo");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				sup_no = rset.getInt("MAX(SUP_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return sup_no;
	}

	public Support checkSupNo(Connection conn, int supNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Support support = null;
		
		String query = prop.getProperty("checkSupNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, supNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				support = new Support(rset.getInt("sup_no"), 
									  rset.getInt("sup_price"), 
									  rset.getDate("sup_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return support;
	}
}
