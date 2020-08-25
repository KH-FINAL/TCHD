package board.model.dao;

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

	public ArrayList selectBList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Adopt> list = null;
		
		String query = prop.getProperty("selectAList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Adopt>();
			
			// Adopt vo가 이상한거 같아서 막혔슈,, 내일 하겠습니다,,
//			while(rset.next()) {
//				list.add(new Adopt(rset.))
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ArrayList selectFList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
} // class end
