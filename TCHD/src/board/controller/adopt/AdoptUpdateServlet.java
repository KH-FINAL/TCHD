package board.controller.adopt;

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
import board.model.vo.Adopt;
import board.model.vo.Board;
import board.model.vo.Files;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class AdoptUpdateServlet
 */
@WebServlet(urlPatterns="/adoptUpdate.bo", name="AdoptUpdateServlet")
public class AdoptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memNo = ((Member)session.getAttribute("loginUser")).getMem_no();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024* 10;
			String root = request.getSession().getServletContext().getRealPath("/"); // C:\5_JSPServlet_workspace\TCHD\WebContent\
			String savePath = root + "upload_imageFiles/";	// 파일 저장경로
			
			File f = new File(savePath);
			if(!f.exists()) {		// 폴더 없으면 만들고 시작
				f.mkdirs();
			}
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();	 // 바뀐 파일 이름 저장
			ArrayList<String> originFiles = new ArrayList<String>(); // 원본파일 이름 저장
			ArrayList<Files> fileList = new ArrayList<Files>();
			Board b = new Board();
			Adopt a = new Adopt();
			
			
			int bNo = Integer.parseInt(multiRequest.getParameter("boNo"));
			
			// insert 했던 입양 동물 정보
			String petKind = multiRequest.getParameter("petKind");		// 동물 구분 체크박스
			String petGender = multiRequest.getParameter("petGender");	// 동물성별 체크박스;
			String unigender = "";
			if(multiRequest.getParameter("unigender") != null) {
				unigender = multiRequest.getParameter("unigender");		// 중성화 여부
			} else {
				unigender = "X";
			}
			String petSize = multiRequest.getParameter("petSize");			// 크기
			String petAge = multiRequest.getParameter("petAge"); 			// 나이
			String petName = multiRequest.getParameter("petName");			// 이름
			String petCategory = multiRequest.getParameter("petCategory");	// 품종
			float petWeight = Float.valueOf(multiRequest.getParameter("petWeight"));	// 무게
			String petColor = multiRequest.getParameter("petColor");		// 색깔
			String rescue = multiRequest.getParameter("rescue");
			String lastMent = multiRequest.getParameter("lastMent");		// 하고 싶은 말
			
			String content = petKind + ", " + petGender + ", " + unigender + ", " + petSize + ", " + petAge + ", " + 
					petName + ", " + petCategory + ", " + petWeight + ", " + petColor + ", " + 
					rescue + ", " + lastMent;
			
			System.out.println("수정하기 content : " + content);
			
//			Board b = new Board(bNo, "입양게시판", petName, content, memNo);
//			
//			Adopt a = new Adopt(petKind, petCategory, petGender, unigender, petName, petAge, 
//									rescue, petWeight, petColor, petSize, lastMent);

			b.setBoNo(bNo);
			b.setBoTitle(petName);
			b.setBoContent(content);
			b.setMemNo(memNo);
			
			a.setBoNo(bNo);
			a.setPetName(petName);
			a.setPetKinds(petKind);
			a.setPetCategory(petCategory);
			a.setPetGender(petGender);
			a.setPetUnigender(unigender);
			a.setPetAge(petAge);
			a.setPetWeight(petWeight);
			a.setPetSize(petSize);
			a.setPetColor(petColor);
			a.setRescueDate(rescue);
			a.setPetComment(lastMent);
			
			
			
			Enumeration<String> files = multiRequest.getFileNames();	// form에서 전송되는 파일이름 : 글 수정 시 업로드 된 파일 가져오기
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				String updateFile = multiRequest.getFilesystemName(name);
				
				if(updateFile == null) {	// 수정 시 새로운 파일 첨부 안했다면
					saveFiles.add(multiRequest.getFilesystemName(name));	 // 바뀐 파일명
					originFiles.add(multiRequest.getOriginalFileName(name)); // 실제 업로드했던 파일명
				} else {					// 새로운 파일 첨부 했다면
					saveFiles.add(multiRequest.getFilesystemName(updateFile));	 // 바뀐 파일명
					originFiles.add(multiRequest.getOriginalFileName(updateFile));
				}
			}
			
			for(int i = 0; i < originFiles.size(); i++) {
				Files ft = new Files();
				ft.setFilePath(savePath);
				ft.setOrignName(originFiles.get(i));
				ft.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() -1) {
					ft.setFileLevel(0);
				} else { 
					ft.setFileLevel(1);
				}
				
				fileList.add(ft);
			}
			
			System.out.println(saveFiles);
			System.out.println(originFiles);
			
			// insert 했던 파일 정보
//			String thumbnail = request.getParameter("thumbnail");
//			
//			String contentImg1 = ""; 
//			String contentImg2 = ""; 
//			String contentImg3 = ""; 
//			if(multiRequest.getParameter("contentImg1") != null ) {
//				contentImg1 = request.getParameter("contentImg1");
//			}
//			
//			if(multiRequest.getParameter("contentImg2") != null ) {
//				contentImg2 = request.getParameter("contentImg2");
//			}
//
//			if(multiRequest.getParameter("contentImg3") != null ) {
//				contentImg3 = request.getParameter("contentImg3");
//			}
			
			
			int result = new BoardService().updateAdopt(b, a, fileList);
			
			if(result > 0) {
				request.setAttribute("adopt", a);
				request.setAttribute("fileList", fileList);
				request.setAttribute("section", "WEB-INF/views/adopt/aodptDetdail.bo?boNo=" + bNo);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
//				for(int i = 0; i < saveFiles.size(); i++) {
//					File failedFile = new File(savePath + saveFiles.get(i));
//					failedFile.delete();
//				}
//				request.setAttribute("msg", "사진 게시판 수정에 실패하였습니다.");
//				request.setAttribute("section", "WEB-INF/views/common/errorPage.jsp");
//				request.getRequestDispatcher("index.jsp").forward(request, response);
				response.sendRedirect("adoptDetail.bo?boNo=" + bNo);
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
