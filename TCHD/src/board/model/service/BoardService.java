package board.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Questions;
import board.model.vo.Volunteer;

public class BoardService {

	public ArrayList selectTList(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		BoardDAO dao = new BoardDAO();
		
		if(i == 1) {
			list = dao.selectAList(conn);
		} else { 
			list = dao.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}



	public ArrayList<Questions> selectQList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Questions> Qlist = new BoardDAO().selectQList(conn, pi);
		
		close(conn);
		return Qlist;
	}


	public ArrayList<Board> selectMyBoard(int mem_no) {
		Connection conn = getConnection();
		
		ArrayList<Board> boardList = new BoardDAO().selectMyBoard(conn,mem_no);
		
		close(conn);
		
		return boardList;
	}

	public ArrayList<Volunteer> selectMyVolunteer(int mem_no) {
		Connection conn = getConnection();
		
		ArrayList<Volunteer> volunteerList = new BoardDAO().selectMyVolunteer(conn,mem_no);
		
		close(conn);
		
		return volunteerList;
		
	}

	
	

} // class end
