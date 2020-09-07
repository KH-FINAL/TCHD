package board.controller.volunteer;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
import member.model.vo.Member;

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
		HttpSession session = request.getSession();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			// 파일 첨부.
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
			
			// mem_no, selectBoard, boTitle, voArea
			int mem_no = ((Member)session.getAttribute("loginUser")).getMem_no();
		    System.out.println("mem_no:"+mem_no);
		    
			String selectBoard = multiRequest.getParameter("selectBoard");
			
			String boTitle = multiRequest.getParameter("boTitle");
			System.out.println(boTitle);
			
			String voArea = multiRequest.getParameter("voArea");
			
			// 봉사 일시.
//			String voDate = multiRequest.getParameter("voDate");
			String voDate2 = multiRequest.getParameter("voDate");
			String[] vo_dateArr = voDate2.split("-");
			int year = Integer.parseInt(vo_dateArr[0]);
			int month = Integer.parseInt(vo_dateArr[1])-1;
			int day = Integer.parseInt(vo_dateArr[2].split("T")[0]);
			int hour = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[0]);
			int min = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[1]);
			System.out.println("convert_voDate : " + year + "-" + (month + 1) + "-" + day + " " + hour + " : " + min);
			Date voDate = new Date(new GregorianCalendar(year, month, day, hour, min).getTimeInMillis());
			System.out.println(voDate);
//			String voDate2 = multiRequest.getParameter("voDate");
//			String voDate2 = multiRequest.getParameter("voDate");
//			Date voDate = Date.valueOf(voDate2);
//			Date voDate = new Date(new GregorianCalendar(voDate2).getTimeInMillis());
			
			// 봉사지.
//			String voPlace = multiRequest.getParameter("voPlace");
			String zonecode= multiRequest.getParameter("zoneCode");
			String address = multiRequest.getParameter("joinAddress");
			String address2 = multiRequest.getParameter("joinAddress2");
			String voPlace = null;
			if(!zonecode.equals("")) {
				voPlace = "("+zonecode+")"+" "+address+", "+address2;
			}
			System.out.println(zonecode);
			System.out.println(address); 
			System.out.println(address2);
			
			// 봉사 정원.
			String voMaxmember2 = multiRequest.getParameter("voMaxmember");
			int voMaxmember = Integer.parseInt(voMaxmember2);
			
			// 내용.
			String voComment = multiRequest.getParameter("voComment");
			
			//
			Volunteer v = new Volunteer(3, boTitle, voArea, voDate, voPlace, voMaxmember, voComment, selectBoard, mem_no);
			
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
