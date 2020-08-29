package animalHospital.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.ArrayList;

import animalHospital.model.dao.AnimalHospitalDAO;
import animalHospital.model.vo.AnimalHospital;

public class AnimalHospitalService {

	public ArrayList<AnimalHospital> selectHospitalList() {
		Connection conn =getConnection();
		
		ArrayList<AnimalHospital> hospitalList = new AnimalHospitalDAO().selectHospitalList(conn);
		
		close(conn);
		
		return hospitalList;
	}

	public AnimalHospital selectHospital(int hosNo) {
		Connection conn = getConnection();
		
		AnimalHospital  hospital= new AnimalHospitalDAO().selectHospitalList(conn, hosNo);
		
		close(conn);
		
		return hospital;
	}

}
