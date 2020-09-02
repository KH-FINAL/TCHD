package board.controller.questions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.Files;
import board.model.vo.Notice;
import board.model.vo.Questions;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class QuestionsWriteServlet
 */
@WebServlet("/write.qu")
public class QuestionsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsWriteServlet() {
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
		
		HttpSession session = request.getSession();
		String saveFile = multiRequest.getFilesystemName("input_file");	// form에서 전송되는 파일이름
		String originFile = multiRequest.getOriginalFileName("input_file");	// form에서 전송되는 파일이름
	
		String selectBoard = multiRequest.getParameter("input_subject");
		String content = multiRequest.getParameter("input_content");
		String title= multiRequest.getParameter("input_title");
		String userId = ((Member)session.getAttribute("loginUser")).getMem_id();
		String pass = multiRequest.getParameter("q_password");
		
	

		Questions q = new Questions(0, title, content, null , null , 0, selectBoard, 2);
		
		
		Files uploadFile =  new Files();
		uploadFile.setFilePath(savePath);
		uploadFile.setOrignName(originFile);
		uploadFile.setChangeName(saveFile);
		
		
		
		int result = new BoardService().insertQuestions(q, uploadFile);
		
		
		
		if(result>0) {
			response.sendRedirect("list.qu");
		}else {
			
			File failedFil = new File(savePath+saveFile);
			failedFil.delete();
			
			request.setAttribute("errorMsg", "문의사항 등록에 실패하였습니다.");
			request.setAttribute("section","WEB-INF/views/common/errorPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
