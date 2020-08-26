package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Adopt;
import board.model.vo.Files;

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
			
			// Adopt vo가 이상한거 같아서 막혔슈,, 내일 하겠습니다,,
			while(rset.next()) {
				list.add(new Adopt(rset.getInt("bo_no"),
									rset.getInt("bo_type"),
									rset.getString("cate_name"),
									rset.getString("mem_id"),
									rset.getString("pet_kinds"),
									rset.getString("pet_category"),
									rset.getString("pet_gender"),
									rset.getString("pet_uigender"),
									rset.getString("pet_name"),
									rset.getString("pet_age"),
									rset.getDate("pet_rescue_date"),
									rset.getFloat("pet_weight"),
									rset.getString("pet_color"),
									rset.getString("pet_size"),
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
	
	
	
	
	
} // class end
