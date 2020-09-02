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

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
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
		int maxSize = 1024*1024*10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "upload_imageFiles/";
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");

		File f= new File(savePath);
		if(!f.exists()) {
			f.mkdirs();
			
		}
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy()); 
		ArrayList<String> saveFiles = new ArrayList<String>();	 // 바뀐 파일 이름 저장
		ArrayList<String> originFiles = new ArrayList<String>(); // 원본파일 이름 저장
		
		Enumeration<String> files = multiRequest.getFileNames();	// form에서 전송되는 파일이름
		while(files.hasMoreElements()) {
			String name = files.nextElement();
			
			if(multiRequest.getFilesystemName(name) != null) {
				saveFiles.add(multiRequest.getFilesystemName(name));	 // 바뀐 파일명
				originFiles.add(multiRequest.getOriginalFileName(name)); // 실제 업로드했던 파일명
			}
		}
		
	
		String saveFile = multiRequest.getFilesystemName("input_file");	// form에서 전송되는 파일이름
		String originFile = multiRequest.getOriginalFileName("input_file");	// form에서 전송되는 파일이름
	
		String selectBoard = multiRequest.getParameter("selectBoard");
		String title= multiRequest.getParameter("input_title");
		String content = multiRequest.getParameter("content");
		String userId = ((Member)session.getAttribute("loginUser")).getMem_id();
		String comContent = multiRequest.getParameter("comContent");
		String pass = multiRequest.getParameter("q_password");
		System.out.println(content);
	

		//DB에 저장할 객체 - Quesitons테이블
		Questions q = new Questions(0 ,title, content, 0, null, userId, null, selectBoard, comContent, null, pass);
	
		Files uploadFile =  new Files();
		uploadFile.setFilePath(savePath);
		uploadFile.setOrignName(originFile);
		uploadFile.setChangeName(saveFile);
		
		
		ArrayList<Files> fileList = new ArrayList<Files>();
		for(int i = originFiles.size() - 1; i >= 0; i--) {	// originFiles.size() : 원본파일 개수
			Files ft = new Files();
			ft.setFilePath(savePath);				// 사용자 정의 파일경로
			ft.setOrignName(originFiles.get(i));	// 원본파일 이름
			ft.setChangeName(saveFiles.get(i));		// 사용자 정의파일 이름
			
			if(i == originFiles.size() -1) {	
				ft.setFileLevel(0);			// 썸네일
			} else {
				ft.setFileLevel(1);			// 내용사진
			}
			
			fileList.add(ft);		// 파일 저장순서 순차적으로 적용
		}
		
		
		
		
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
