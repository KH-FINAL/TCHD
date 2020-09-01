package animalHospital.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import animalHospital.model.service.AnimalHospitalService;
import animalHospital.model.vo.AnimalHospital;

@WebServlet("/hospitalList.ho")
public class AnimalHospitalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnimalHospitalListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AnimalHospital> hospitalList = null;
		AnimalHospitalService ahs = new AnimalHospitalService();
		String addr = (String)request.getParameter("addr");

		
		if(addr == null || addr.equals("전체보기")) {
			// 지역 선택하지 않은 경우 & 전체보기를 선택한 경우
			hospitalList = ahs.allHospitalList();
		} else {
			// 지역 선택한 경우
			// 개수에 맞는 번호를 목록에서 보여줘야 함
			hospitalList = ahs.selectAddr(addr);
		}
		
		request.setAttribute("addr", addr);
		request.setAttribute("hospitalList", hospitalList);
		request.setAttribute("section", "WEB-INF/views/animalHospital/animalHospitalList.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
