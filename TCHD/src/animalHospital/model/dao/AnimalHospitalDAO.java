package animalHospital.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import animalHospital.model.vo.AnimalHospital;

public class AnimalHospitalDAO {
	Properties prop = new Properties();
	
	public AnimalHospitalDAO() {
		String fileName= AnimalHospitalDAO.class.getResource("/sql/animalHospital/animalHospital-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AnimalHospital> selectHospitalList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AnimalHospital> hospitalList = new ArrayList<AnimalHospital>();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectHospitalList"));
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				AnimalHospital hospital = new AnimalHospital(
						rset.getInt("HOS_NO"), 
						rset.getString("HOS_NAME"), 
						rset.getString("HOS_ADDR"), 
						rset.getString("HOS_PHONE"));
				hospitalList.add(hospital);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospitalList;
	}

	public AnimalHospital selectHospitalList(Connection conn, int hosNo) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		AnimalHospital hospital = null;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("selectHospital"));
			pstmt.setInt(1, hosNo);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				hospital= new AnimalHospital(
						rset.getInt("HOS_NO"), 
						rset.getString("HOS_NAME"),
						rset.getString("HOS_ADDR"), 
						rset.getString("HOS_PHONE"));
						
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return hospital;
	}

}
