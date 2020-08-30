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
	
	public ArrayList<AnimalHospital> allHospitalList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AnimalHospital> hospitalList = new ArrayList<AnimalHospital>();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("allHospitalList"));
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				AnimalHospital hospital = new AnimalHospital(rset.getInt("HOS_NO"), 
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
	
	public ArrayList<AnimalHospital> selectAddr(Connection conn, String addr) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AnimalHospital> hospitalList = new ArrayList<AnimalHospital>();
		
		switch(addr) {
		case "서울특별시": case "부산광역시": case "대구광역시": case "인천광역시": case "광주광역시": case "대전광역시":
		case "울산광역시": case "세종특별자치시": case "경기도": case "강원도": case "제주특별자치도":
			addr = addr.substring(0, 2);
			break;
		case "충청북도":	addr = "충북";	break;
		case "충청남도":	addr = "충남";	break;
		case "전라북도":	addr = "전북";	break;
		case "전라남도":	addr = "전남";	break;
		case "경상북도":	addr = "경북";	break;
		case "경상남도":	addr = "경남";	break;
		}
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectAddr"));
			pstmt.setString(1, addr + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AnimalHospital hospital = new AnimalHospital(rset.getInt("HOS_NO"), 
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
	
	public AnimalHospital selectHospital(Connection conn, int hosNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AnimalHospital hospital = null;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("selectHospital"));
			pstmt.setInt(1, hosNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				hospital= new AnimalHospital(rset.getInt("HOS_NO"), 
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
