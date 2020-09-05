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
		Member loginUser = (Member)session.getAttribute("loginUser");
		int bNo = Integer.parseInt(request.getParameter("boNo"));
		
//		if(ServletFileUpload.isMultipartContent(request)) {
//			int maxSize = 1024 * 1024* 10;
//			String root = request.getSession().getServletContext().getRealPath("/"); // C:\5_JSPServlet_workspace\TCHD\WebContent\
//			String savePath = root + "upload_imageFiles/";	// 파일 저장경로
//			
//			
//			File f = new File(savePath);
//			if(!f.exists()) {		// 폴더 없으면 만들고 시작
//				f.mkdirs();
//			}
		
//			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8", new MyFileRenamePolicy());
//			
//			ArrayList<String> saveFiles = new ArrayList<String>();	 // 바뀐 파일 이름 저장
//			ArrayList<String> originFiles = new ArrayList<String>(); // 원본파일 이름 저장
//			ArrayList<Files> fList = new ArrayList<Files>();
		
		Board b = new Board();
		Adopt a = new Adopt();
		
		
		
		// insert 했던 입양 동물 정보
		// PET_CATEGORY=?, PET_UNIGENDER=?, PET_NAME=?, PET_AGE=?, PET_WEIGHT=?, PET_COLOR=?, PET_COMMENT=? WHERE BO_NO=?
		String petKind = request.getParameter("petKind");		// 동물 구분 체크박스
		String petGender = request.getParameter("petGender");	// 동물성별 체크박스;
		String unigender = "";
		if(request.getParameter("unigender") != null) {
			unigender = "O";		// 중성화 여부
		} else {
			unigender = "X";
		}
		String petSize = request.getParameter("petSize");			// 크기
		String petAge = request.getParameter("petAge") + "/" 		// 나이
						+ request.getParameter("petAgeDetail")
					    + request.getParameter("detailAge"); 			// 나이
		String petName = request.getParameter("petName");			// 이름
		String petCategory = request.getParameter("petCategory");	// 품종
		float petWeight = Float.valueOf(request.getParameter("petWeight"));	// 무게
		String petColor = request.getParameter("petColor");		// 색깔
		String rescue = request.getParameter("rescue");
		
		String lastMent = "";
		if(request.getParameter("lastMent") != null) {
			lastMent = request.getParameter("lastMent");		// 하고 싶은 말
		} else {
			lastMent = "";
		}
		String content = petKind + ", " + petGender + ", " + unigender + ", " + petSize + ", " + petAge + ", " + 
				petName + ", " + petCategory + ", " + petWeight + ", " + petColor + ", " + 
				rescue + ", " + lastMent;
			
//			System.out.println("수정하기 content : " + content);
			
//			Enumeration<String> files = multiRequest.getFileNames();	// form에서 전송되는 파일이름 : 글 수정 시 업로드 된 파일 가져오기
//			while(files.hasMoreElements()) {
//				String name = files.nextElement();	// thumbnailImg(썸네일), thumbnailImg1  ==> 내가 새로 선택한 파일 name태그명
//				String updateFile = multiRequest.getFilesystemName(name); // thumbnailImg의 changeName  --> thumbnailImg1의 changeName은 null
//				System.out.println("수정하기 파일이름 :"+name);	
//				System.out.println("수정하기 파일업데이트 :"+updateFile);
//				if(updateFile != null) {	// 사진이 추가됐을 떄??
//					saveFiles.add(multiRequest.getFilesystemName(name));	 // 바뀐 파일명
//					originFiles.add(multiRequest.getOriginalFileName(name)); // 실제 업로드했던 파일명
//				} 
//			}
			
//			System.out.println("수정하기 썸네일:" + multiRequest.getParameter("thumbnailImg"));	// null
//			System.out.println("수정하기 내용사진:" + multiRequest.getParameter("thumbnailImg1"));// null

//			int fileNo0 = Integer.parseInt(multiRequest.getParameter("fileNo0"));
//			int fileNo = Integer.parseInt(multiRequest.getParameter("fileNo"));
			
//			for(int i = 0; i < originFiles.size(); i++) {
//				Files ft = new Files();
//				ft.setBoNo(bNo);
//				ft.setFilePath(savePath);
//				ft.setOrignName(originFiles.get(i));
//				ft.setChangeName(saveFiles.get(i));
//				if(i == originFiles.size() -1) {
//					ft.setFileLevel(0);
////					ft.setFileNdo(fileNo0);
//				} else { 
//					ft.setFileLevel(1);
////					ft.setFileNo(fileNo);
//				}
				
//				fList.add(ft);
//				System.out.println("수정하기 파일 게시글 번호 :"+fList.get(i).getBoNo());
//				System.out.println("수정하기 파일 저장경로 :"+fList.get(i).getFilePath());
//				System.out.println("수정하기 파일 원본이름 :"+fList.get(i).getOrignName());
//				System.out.println("수정하기 파일 바뀐이름 :"+fList.get(i).getChangeName());
//				System.out.println("수정하기 파일레벨 :"+fList.get(i).getFileLevel());
//				System.out.println("수정하기 파일번호 :"+fList.get(i).getFileNo());	// 새로운 이미지 파일이라 파일번호가 없나봐..
//			}
			

			
			b.setBoNo(bNo);
			b.setBoTitle(petName);
			b.setBoContent(content);
			b.setMemNo(loginUser.getMem_no());
			
			// PET_CATEGORY=?, PET_UNIGENDER=?, PET_NAME=?, PET_AGE=?, PET_WEIGHT=?, PET_COLOR=?, PET_COMMENT=? WHERE BO_NO=?
			a.setBoNo(bNo);
			a.setId(loginUser.getMem_id());
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
			
			int result = new BoardService().updateAdopt(b, a);
			ArrayList<Files> fileList = new BoardService().selectNoticeFile(bNo);
			
			if(result > 0) {
				request.setAttribute("loginUser", loginUser);
				request.setAttribute("adopt", a);
				request.setAttribute("rescue", rescue);
				request.setAttribute("fileList", fileList);
				request.setAttribute("section", "WEB-INF/views/adopt/adoptDetail.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
				response.sendRedirect("adoptDetail.bo?boNo=" + bNo);
			}
			
		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
