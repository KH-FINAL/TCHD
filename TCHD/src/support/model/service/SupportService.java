package support.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import support.model.dao.SupportDAO;
import support.model.vo.Support;

public class SupportService {

	public int applyMem(Support support) {
		Connection conn = getConnection();
		
		SupportDAO dao = new SupportDAO();
		int result = 0;
		
		int mem_no = dao.selectMemNo(conn, support);
		
		if(mem_no != 0) {
			support.setMem_no(mem_no);
			result = dao.applyMem(conn, support);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int applyNonMem(Support support) {
		Connection conn = getConnection();
		
		SupportDAO dao = new SupportDAO();
		
		int result = dao.applyNonMem(conn, support);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		int sup_no = dao.selectSupNo(conn, support);
		
		close(conn);
		
		return sup_no;
	}

	public int checkSupNo(int supNo) {
		Connection conn = getConnection();
		
		int check = new SupportDAO().checkSupNo(conn, supNo);
		
		close(conn);
		
		return check;
	}

	public Support selectListNonMem(String supNo) {
		Connection conn = getConnection();
		
		Support support = new SupportDAO().selectListNonMem(conn, supNo);
		
		close(conn);
		
		return support;
	}

	public ArrayList<Support> selectListMem(int mem_no) {
		Connection conn = getConnection();
		
		ArrayList<Support> supportList = new SupportDAO().selectListMem(conn, mem_no);
		
		close(conn);
		
		return supportList;
	}
}
