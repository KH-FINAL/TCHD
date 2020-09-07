package board.controller.volunteer;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Files;
import board.model.vo.Notice;
import board.model.vo.Volunteer;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class VolunteerUpdateServlet
 */
@WebServlet("/volunteerUpdate.bo")
public class VolunteerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			System.out.println(saveFile);
			System.out.println(originFile);
			
			int volBNo = Integer.parseInt(request.getParameter("volBNo"));
			System.out.println(volBNo);
			
			String volCateName = request.getParameter("volCateName");
			System.out.println(volCateName);
			
			String boTitle = request.getParameter("input_title");
			
			String voArea = request.getParameter("voArea");
			
			// 봉사 일시. (업데이트폼 서블릿이랑 동일)
			String voDate2 = request.getParameter("input_voDate");
			String[] vo_dateArr = voDate2.split("-");
			int year = Integer.parseInt(vo_dateArr[0]);
			int month = Integer.parseInt(vo_dateArr[1])-1;
			int day = Integer.parseInt(vo_dateArr[2].split("T")[0]);
//			int hour = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[0]);
//			int min = Integer.parseInt(vo_dateArr[2].split("T")[1].split(":")[1]);
//			System.out.println("convert_voDate : " + year + "-" + (month + 1) + "-" + day + " " + hour + " : " + min);
			System.out.println("convert_voDate : " + year + "-" + (month + 1) + "-" + day);
//			Date voDate = new Date(new GregorianCalendar(year, month, day, hour, min).getTimeInMillis());
			Date voDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			
			// 봉사지.
			String zonecode= request.getParameter("input_zoneCode");
			String address = request.getParameter("input_joinAddress");
			String address2 = request.getParameter("input_joinAddress2");
			String voPlace = null;
			if(!zonecode.equals("")) {
				voPlace = "("+zonecode+")"+" "+address+", "+address2;
			}
			
			// 봉사 정원.
			String voMaxmember2 = request.getParameter("input_voMaxmember");
			int voMaxmember = Integer.parseInt(voMaxmember2);
			
			// 내용.
			String voComment = request.getParameter("input_voComment");
			
			// 글쓴 날짜.
			String boDate2 = request.getParameter("boDate");
			String[] bo_dateArr = boDate2.split("-");
			int boYear = Integer.parseInt(vo_dateArr[0]);
			int boMonth = Integer.parseInt(vo_dateArr[1])-1;
			int boDay = Integer.parseInt(vo_dateArr[2].split("T")[0]);
			Date boDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			
			Volunteer volunteer = new Volunteer(volBNo, volCateName, boTitle, voDate, voPlace, boDate, voMaxmember, voComment);

			int fileNo =0;
	
			if(multiRequest.getParameter("volunteerFileNo")!=null) {
				fileNo = Integer.parseInt(multiRequest.getParameter("volunteerFileNo"));
		
			}
			Files file = new Files(fileNo, volBNo, originFile, saveFile, savePath, null, 0, 0, null);
			
			int result = new BoardService().updateVolunteer(volunteer, file);
			
			
			if(result>0) {
				response.sendRedirect("volunteerDetail.bo?bNo="+volBNo);
			}else {
				File failedFile = new File(savePath+saveFile);
				failedFile.delete();
				
				request.setAttribute("errorMsg", "게시글 수정에 실패하였습니다.");
				request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
