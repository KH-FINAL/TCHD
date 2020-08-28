
package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Adopt;
import board.model.vo.Board;
import board.model.vo.Files;
import board.model.vo.PageInfo;
import board.model.vo.Questions;
import board.model.vo.Volunteer;

public class BoardDAO {
	private Properties prop = new Properties();
	
	public BoardDAO() {
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList selectAList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Adopt> list = null;
		
		String query = prop.getProperty("selectAList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Adopt>();
			
			// 
			while(rset.next()) {
				list.add(new Adopt(rset.getInt("bo_no"),
						rset.getInt("bo_type"),
						rset.getString("cate_name"),
						rset.getString("mem_id"),
						rset.getString("pet_kinds"),
						rset.getString("pet_category"),
						rset.getString("pet_gender"),
						rset.getString("pet_unigender"),
						rset.getString("pet_name"),
						rset.getString("pet_age"),
						rset.getDate("pet_rescue_date"),
						rset.getFloat("pet_weight"),
						rset.getString("pet_color"),
						rset.getString("pet_size"),
						rset.getString("pet_comment"),
						rset.getString("adopt_yn")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList selectFList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Files> list = null;
		
		String query = prop.getProperty("selectFList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Files>();
			while(rset.next()) {
				list.add(new Files(rset.getInt("bo_no"),
									rset.getString("change_name")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 2);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Questions> selectQList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Questions> Qlist = null;
		
		String query = prop.getProperty("selectQList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, 2); //bo_type 2 문의게시판
			rset = pstmt.executeQuery();
			
			Qlist = new ArrayList<Questions>(); //db의 resultSet결과보고만들기
			while(rset.next()) {
				Questions q = new Questions(rset.getInt("bo_no"),
									rset.getInt("bo_type"),
									rset.getString("cate_name"),
									rset.getString("bo_title"),
									rset.getString("bo_content"),
									rset.getInt("bo_count"),
									rset.getDate("bo_date"),
									rset.getInt("mem_no"),
									rset.getString("mem_id"),
									rset.getString("bo_delete_yn"),
									rset.getString("mem_leave"));
				
				Qlist.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return Qlist;
	}
	
	
	public ArrayList<Board> selectMyBoard(Connection conn,int mem_no,PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> boardList = new ArrayList<Board>();
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMyBoard"));
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, mem_no);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board=null;
				int currBo_no = 0;
				if(currBo_no!=rset.getInt("BO_NO")) {
					currBo_no=rset.getInt("BO_NO");
				}
				board = new Board(
						rset.getInt("BO_NO"),
						rset.getString("CATE_NAME"),
						rset.getString("BO_TITLE"),
						rset.getDate("BO_DATE")
					);
				boardList.add(board);
				if(rset.getInt("COM_NO")!=0) {
					board= new Board(
							rset.getInt("COM_NO"),
							null,
							rset.getString("COM_CONTENT"),
							rset.getDate("COM_DATE")
						);
					boardList.add(board);
				}
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return  boardList;
	}

	public ArrayList<Volunteer> selectMyVolunteer(Connection conn, int mem_no) {
		PreparedStatement pstmt = null;
		ResultSet  rset =null;
		ArrayList<Volunteer> volunteerList = new ArrayList<Volunteer>();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMyVolunteer"));
			
			rset=pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return volunteerList;
	}

	public ArrayList<Volunteer> selectVList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Volunteer> VList = null;
		
		String query = prop.getProperty("selectVList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);	// 첫번째 자리에 startRow
			pstmt.setInt(2, endRow);	// 두번째 자리에 endRow
			pstmt.setInt(3, 1);
			rset = pstmt.executeQuery();
			
			VList = new ArrayList<Volunteer>();
			while(rset.next()) {
				Volunteer v = new Volunteer(rset.getInt("bo_no"),
											rset.getInt("bo_type"),
											rset.getString("cate_name"),
											rset.getString("bo_title"),
											rset.getInt("bo_count"),
											rset.getDate("bo_date"),
											rset.getInt("mem_no"),
											rset.getString("mem_id"),
											rset.getString("bo_delete_yn"));
				VList.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		// DB에 VLIST 뷰 짜고 다시 재도전 예정 ㅎ..
		
		return VList;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getMemNo());
			pstmt.setString(2, b.getBoTitle());
			pstmt.setString(3, b.getBoContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		
		return result;
	}

	public int insertAdoptBoard(Connection conn, Adopt a) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAdopt");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, a.getPetKinds());
			pstmt.setString(2, a.getPetCategory());
			pstmt.setString(3, a.getPetGender());
			pstmt.setString(4, a.getPetUnigender());
			pstmt.setString(5, a.getPetName());
			pstmt.setString(6, a.getPetAge());
			pstmt.setFloat(7, a.getPetWeight());
			pstmt.setString(8, a.getPetColor());
			pstmt.setString(9, a.getPetSize());
			pstmt.setString(10, a.getPetComment());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		
		return result;
	}

	public int insertAdoptFiles(Connection conn, ArrayList<Files> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFiles");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				Files f = fileList.get(i);
				
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, f.getOrignName());
					pstmt.setString(2, f.getChangeName());
					pstmt.setString(3, f.getFilePath());
					pstmt.setInt(4, f.getFileLevel());
					
					result += pstmt.executeUpdate();	// 파일이 여러개일 수 있어서 +=
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Questions> selectAnswerQuestions(Connection conn,PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Questions> questionsList = new ArrayList<Questions>();
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("selectAnswerQuestions"));
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Questions q = new Questions(
						rset.getInt("BO_NO"),
						0,
						rset.getString("CATE_NAME"),
						rset.getString("BO_TITLE"),
						rset.getString("BO_CONTENT"),
						0,
						rset.getDate("BO_DATE"),
						rset.getInt("MEM_NO"),
						rset.getString("MEM_ID"),
						null,
						null
						);
						questionsList.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return questionsList;
	}

	public int answerQuestion(Connection conn, int qNo, String answer) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt =conn.prepareStatement(prop.getProperty("answerQuestion"));
			pstmt.setInt(1, qNo);
			pstmt.setString(2, answer);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int selectMyBoardCount(Connection conn, int mem_no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count =0;
		
		try {
			pstmt =conn.prepareStatement(prop.getProperty("selectMyBoardCount"));
			pstmt.setInt(1, mem_no);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count= rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public int selectAnswerQuestionsCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count =0;
		
		try {
			pstmt =conn.prepareStatement(prop.getProperty("selectAnswerQuestionsCount"));
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				count= rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}

	public int updateCount(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return 0;
	}

	public Questions selectBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Questions board = null;
		
		String query = prop.getProperty("selectBoard");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board  = new Questions(rset.getInt("bo_no"),
									rset.getInt("bo_type"),
									rset.getString("cate_name"),
									rset.getString("bo_title"),
									rset.getString("bo_content"),
									rset.getInt("bo_count"),
									rset.getDate("bo_date"),
									rset.getString("mem_id"),
									rset.getString("bo_delete_yn"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}
	


	
	
	
}