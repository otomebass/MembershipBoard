package Action;

import java.io.*;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardModifyProAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Path path = null;
		boolean isModifySuccess = false;
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		String userPwd = (String) session.getAttribute("userPwd");
		String password = request.getParameter("password");
		BoardBean article = new BoardBean();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
 
		if (!password.equals(userPwd)) {
			String pwChk = "pwFalse";
			request.setAttribute("pwChk", pwChk);
			path = new Path();
			path.setPath("boardModifyForm.do?pwChk=" + pwChk);
		} else {
			article.setBoardNo(boardNo);
			article.setTitle(request.getParameter("title"));
			article.setContent(request.getParameter("content"));
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if (!isModifySuccess) {
				String pwChk = "modifyFalse";
				request.setAttribute("pwChk", pwChk);
				path = new Path();
				path.setPath("boardModifyForm.do?pwChk=" + pwChk);
			} else {
				path = new Path();
				request.setAttribute("page", page);
				path.setPath("boardDetail.do?boardNo=" + article.getBoardNo());
			}
		}
		return path;
	}

}
