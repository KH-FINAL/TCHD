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
		
		ArrayList<AnimalHospital> hospitalList = new AnimalHospitalService().selectHospitalList();
		
		
		request.setAttribute("hospitalList", hospitalList);
		request.setAttribute("section", "WEB-INF/views/animalHospital/animalHospitalList.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
