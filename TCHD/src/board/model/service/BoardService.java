package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import board.model.dao.BoardDAO;
import board.model.vo.Adopt;
import board.model.vo.AdoptApply;
import board.model.vo.Board;
import board.model.vo.Files;
import board.model.vo.Notice;
import board.model.vo.PageInfo;
import board.model.vo.Questions;
import board.model.vo.Comments;
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
	
	

	public int getListCount(int boType) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().getListCount(conn,boType);
		
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



	public ArrayList<Volunteer> selectVList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Volunteer> volunteerList = new BoardDAO().selectVList(conn, pi);
		
		close(conn);
		
		return volunteerList;
	}
	
	public int insertBoard(Board b, Adopt a, ArrayList<Files> fileList) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().insertBoard(conn, b);
		int result1 = 0;
		int result2 = 0;
		
		
		if(result > 0) {
			result1 = new BoardDAO().insertAdoptBoard(conn, a);	// 내용 저장 객체
			result2 = new BoardDAO().insertAdoptFiles(conn, fileList);	// 파일 객체
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

	public Questions selectBoard(int bNo) {
		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO();
		int result = dao.updateCount(conn, bNo);
		Questions qBoard = null;
		
		if(result > 0) {
			qBoard = dao.selectBoard(conn, bNo);
			
		}
		close(conn);
		
		
		return qBoard;
	}



	public int insertNotice(Notice notice, Files uploadFile) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		int finalResult = 0;
		int result1 = bDAO.insertNoticeBoard1(conn, notice);

		if(result1>0) {
			int result2 = bDAO.insertNoticeBoard2(conn, notice.getNoticeSubject());
			finalResult = result2;
			if(result2>0 && uploadFile.getOrignName()!=null) {

				int result3 = bDAO.insertNoticeFile(conn,uploadFile);		

				finalResult = result3;

				commit(conn);
			}
		}else {
			rollback(conn);
		}


		close(conn);

		return finalResult;

	}



	public Notice selectNotice(int bNo) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		int result=bDAO.updateCount(conn, bNo);
		Notice notice =null;
		
		if(result>0) {

			notice = bDAO.selectNotice(conn,bNo);
		}

		close(conn);

		return notice;
	}



	public ArrayList<Files> selectNoticeFile(int bNo) {
		Connection conn = getConnection();
		
	
	
		ArrayList<Files> fileList = null;
		
		fileList = new BoardDAO().selectFile(conn, bNo);

		close(conn);

		return fileList;
	}

	public int updateNotice(Notice notice, Files file) {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		
		int result1 = bDAO.updateNotice1(conn,notice);
		int finalResult=result1;
		if(result1>0) {  // BOARD테이블 UPDATE성공
			int result2 = bDAO.updateNotice2(conn, notice);
			finalResult=result2;
			if(result2>0) {  // NOTICE테이블 UPDATE성공
				if(file.getFileNo()!=0) { //원본이 사진이 있을때
					if(file.getOrignName()!=null) { // 수정페이지에서 사진을 추가할경우 = 사진을 변경할 경우
						int result3 = bDAO.updateNoticeFile1(conn,file);						
						finalResult=result3;													
					}else { // 사진을 뺄 경우
						int result3 = bDAO.updateNoticeFile3(conn,file);						
						finalResult=result3;	
					}
					
				}else {  //원본이 사진이 없을 때 
					if(file.getOrignName()!=null) { // 수정페이지에서 사진을 추가할경우 = 사진을 변경할 경우
						int result3= bDAO.updateNoticeFile2(conn, file);						
						finalResult=result3;												
					}
				
				}
			}
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return finalResult;
	}

	public Adopt selectedAdopt(int bNo) {
		Connection conn = getConnection();
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateCount(conn, bNo);
		Adopt adopt = null;
		
		if(result > 0) {
			adopt = dao.selectAdopt(conn, bNo);
		}
		
		close(conn);
		
		return adopt;
	}



	public int insertQuestions(Questions q, Files uploadFile) {
		Connection conn = getConnection();
		BoardDAO DAO = new BoardDAO();
		int finalResult = 0;
		int result1 = DAO.insertQuestions1(conn, q);

		if(result1>0) {
			int result2 = DAO.insertQuestions2(conn, q.getBoPwd(), q.getQuSub());
			finalResult = result2;
			if(result2>0 && uploadFile.getOrignName()!=null) {

				int result3 = DAO.insertQuestionsFile(conn,uploadFile);		

				finalResult = result3;

				commit(conn);
			}
		}else {
			rollback(conn);
		}


		close(conn);

		return finalResult;
		
	}


	
	public int insertApply(Board b, AdoptApply apply) {
		Connection conn = getConnection();
		
		int result1 = new BoardDAO().insertBoard(conn, b);
		int result2 = new BoardDAO().insertApply(conn, apply);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else { 
			rollback(conn);
		}
		
		close(conn);
		return result2;
	}
	
	
	
	public Volunteer selectVolunteer(int bNo) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.updateCount(conn, bNo);
		
		Volunteer volunteer = null;
		if(result > 0) {
			volunteer = dao.selectVolunteer(conn, bNo);
			
			if(volunteer != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return volunteer;
	}

	public ArrayList<Comments> selectCommentsList(int bNo) {
		Connection conn = getConnection();
		
		ArrayList<Comments> commentsList = new BoardDAO().selectCommentsList(conn, bNo);
		close(conn);
		return commentsList;
	}
	


	public ArrayList<Notice> searchNotice(String search, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> noticeList = new BoardDAO().searchNotice(conn,search,pi);
		
		close(conn);
		
		return noticeList;
	}



	public int searchNoticeCount(String search) {
		Connection conn = getConnection();
		
		int count = new BoardDAO().searchNoticeCount(conn,search);
		
		close(conn);
		
		return count;
		
		
	}



	public ArrayList<Notice> selectNoticeMainPage() {
		Connection conn = getConnection();
		
		ArrayList<Notice> noticeList = new BoardDAO().selectNoticeMainPage(conn);
		
		close(conn);
		
		return noticeList;
	}

	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Notice> noticeList = new BoardDAO().selectNoticeList(conn,pi);

		close(conn);

		return noticeList;
	}



	public int getMyVolunteerCount(int mem_no) {
		Connection conn= getConnection();
		
		int count = new BoardDAO().getMyVolunteerCount(conn,mem_no);
		
		close(conn);
		
		return count;
	}

	public ArrayList<Volunteer> selectMyVolunteerList(int mem_no,PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Volunteer> volunteerList = new BoardDAO().selectMyVolunteer(conn,mem_no,pi);
		
		close(conn);
		
		return volunteerList;
		
	}



	public ArrayList<Adopt> selectAdoptMainPage() {
		Connection conn = getConnection();
		
		ArrayList<Adopt> adoptList = new BoardDAO().selectAdoptMainPage(conn);
		
		close(conn);
		
		return adoptList;
	}



	public ArrayList<Files> selectAdoptImageMainPage() {
		Connection conn = getConnection();
		
		ArrayList<Files> fileList = new BoardDAO().selectAdoptImageMainPage(conn);
		
		close(conn);
		
		return fileList;
	}

	public ArrayList<Comments> insertComments(Comments comments) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.insertComments(conn, comments);
		
		ArrayList<Comments> commentsList = null;
		if(result > 0) {
			commit(conn);
			commentsList = dao.selectCommentsList(conn, comments.getBoNo());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return commentsList;
	}



	public int updateAdopt(Board b, Adopt a, ArrayList<Files> fList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.updateBoard(conn, b);
		int finalResult = result1;
		if(result1 > 0) {						// Board 테이블 update 성공
			int result2 = dao.updateAdopt(conn, a);
			finalResult = result2;
			if(result2 > 0) {			// Adopt 테이블 update 성공
				for(int i = 0; i < fList.size(); i++) {
					if(fList.get(i).getFileNo() != 0 ) {		// 원본 사진이 있을 때
						if(fList.get(i).getOrignName() != null) { // 수정 페이지에서 사진 추가할 경우 or 사진 변경할 경우
							int result3 = dao.updateAdoptFile1(conn, fList);
							finalResult = result3;
						} else {	 					 // 수정페이지에서 사진 뺼 경우
							int result3 = dao.updateAdoptFile2(conn, fList);
							finalResult = result3;
						}
					}
				}
			}
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return finalResult;
	}
	

	public HashMap<String, Integer> getEachBoardCount(int mem_no) {
		Connection conn= getConnection();
		
		HashMap<String, Integer> eachBoardCount = new BoardDAO().getEachBoardCount(conn,mem_no);
		
		close(conn);
		
		return eachBoardCount;
	}

	public ArrayList<Volunteer> selectMyVolunteerListGm(int mem_no,PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Volunteer> volunteerList = new BoardDAO().selectMyVolunteerGm(conn, mem_no,pi);
		close(conn);
		return volunteerList;
		
	}


	public int getMyVolunteerCountGm(int mem_no) {
		Connection conn = getConnection();
		int count = new BoardDAO().getMyVolunteerCountGm(conn, mem_no);
		close(conn);
		return count;
	}

	
	public int insertVolunteer(Volunteer v, Files uploadFile) {
		
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int finalResult = 0;
		int result1 = dao.insertVolunteer1(conn, v);

		if(result1>0) {
			int result2 = dao.insertVolunteer2(conn, v, v.getVoMaxmember(), v.getVoApplymember(), v.getVoDeadline(), v.getVoDate(), v.getVoArea(), v.getVoPlace(), v.getVoComment());
			finalResult = result2;
			if(result2>0 && uploadFile.getOrignName()!=null) {

				int result3 = dao.insertVolunteerFile(conn,uploadFile);		

				finalResult = result3;

				commit(conn);
			}
			
		} else {
			
			rollback(conn);
		}

		close(conn);

		return finalResult;
	}

} // class end