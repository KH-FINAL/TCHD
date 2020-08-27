package board.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Adopt;
import board.model.vo.Board;
import board.model.vo.Files;
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


	public ArrayList<Board> selectMyBoard(int mem_no, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> boardList = new BoardDAO().selectMyBoard(conn,mem_no,pi);
		
		close(conn);
		
		return boardList;
	}

	public ArrayList<Volunteer> selectMyVolunteer(int mem_no) {
		Connection conn = getConnection();
		
		ArrayList<Volunteer> volunteerList = new BoardDAO().selectMyVolunteer(conn,mem_no);
		
		close(conn);
		
		return volunteerList;
		
	}

	public ArrayList<Volunteer> selectVList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Volunteer> VList = new BoardDAO().selectVList(conn, pi);
		
		close(conn);
		
		return VList;
	}
	
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().insertBoard(conn, b);
		
		return result;
	}
	
	public int insertAdopt(Adopt a, ArrayList<Files> fileList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.insertAdopt(conn, a);			// 내용 저장 객체
		int result2 = dao.insertAdopt(conn, fileList);	// 파일 객체
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public ArrayList<Questions> selectAnswerQuestions(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Questions> questionsList = new BoardDAO().selectAnswerQuestions(conn,pi);
		
		close(conn);
		
		return questionsList;
	}

	public int answerQuestion(int qNo, String answer) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().answerQuestion(conn,qNo,answer);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int selectMyBoardCount(int mem_no) {
		Connection conn = getConnection();
		
		int count = new BoardDAO().selectMyBoardCount(conn,mem_no);
		
		close(conn);
		
		return count;
		
	}

	public int selectAnswerQuestionsCount() {
		Connection conn = getConnection();
		
		int count = new BoardDAO().selectAnswerQuestionsCount(conn);
		
		close(conn);
		
		return count;
	}
	

} // class end