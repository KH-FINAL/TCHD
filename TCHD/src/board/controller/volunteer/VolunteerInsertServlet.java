package board.controller.volunteer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Files;
import board.model.vo.Volunteer;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class VolunteerInsertServlet
 */
@WebServlet("/volunteerInsert.bo")
public class VolunteerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession(); // 수진쓰 코드. 있고 없고 차이?
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*10;
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "upload_imageFiles/";
	
			File f= new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy()); 

			String saveFile = multiRequest.getFilesystemName("input_file");	// form에서 전송되는 파일이름
			String originFile = multiRequest.getOriginalFileName("input_file");	// form에서 전송되는 파일이름
		
			String selectBoard = multiRequest.getParameter("selectBoard"); // view에서.. 첨부파일 이름인가?
			String boTitle = multiRequest.getParameter("boTitle");
			String voArea = multiRequest.getParameter("voArea");
			String voDate = multiRequest.getParameter("voDate");
//			String voPlace = multiRequest.getParameter("voPlace");
			String zonecode= multiRequest.getParameter("zoneCode");
			String address = multiRequest.getParameter("joinAddress");
			String address2 = multiRequest.getParameter("joinAddress2");
			String voPlace = null;
			if(!zonecode.equals("")) {
				voPlace = zonecode+","+address+","+address2;
			}
			
			System.out.println(zonecode);
			System.out.println(address); 
			System.out.println(address2);
			System.out.println(boTitle);
			
			String voMaxmember = multiRequest.getParameter("voMaxmember");
			String voComment = multiRequest.getParameter("voComment");
			
			Volunteer v = new Volunteer(3, boTitle, voArea, voDate, voPlace, voMaxmember, voComment, selectBoard);
			
			Files uploadFile =  new Files();
			uploadFile.setFilePath(savePath);
			uploadFile.setOrignName(originFile);
			uploadFile.setChangeName(saveFile);
			
			int result = new BoardService().insertVolunteer(v, uploadFile);
			
			if(result>0) {
				response.sendRedirect("volunteerList.bo");
			} else {
				File failedFile = new File(savePath+saveFile);
				failedFile.delete();
				
				request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
				view.forward(request, response);
			}
		}
//		String boTitle = request.getParameter("boTitle");
//		String voArea = request.getParameter("voArea");
//		String voDate = request.getParameter("voDate");
//		String voPlace = request.getParameter("voPlace");
//		String voMaxmember = request.getParameter("voMaxmember");
//		String voComment = request.getParameter("voComment");
		
//		Volunteer volunteer = new Volunteer(boTitle, voArea, voDate, voPlace, voMaxmember, voComment);
//		int result = new BoardService().selectVolunteer(volunteer);
//		
//		if(result > 0) {
//			response.sendRedirect("volunteerList.bo");
//		} else {
//			request.setAttribute("msg", "게시글 등록에 실패하였습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
