package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardDetailAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String page = request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(boardNo);
		Path path = new Path();

		request.setAttribute("page", page);
		request.setAttribute("article", article);
		path.setPath("/board/boardView.jsp");

		return path;
	}

}
