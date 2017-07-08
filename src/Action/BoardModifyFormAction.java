package Action;
 
import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardModifyFormAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		Path path = new Path();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String page = request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(boardNo);
		String content = article.getContent();
		content = content.replace("<br>", "\n");
		content = content.replace("&nbsp;", " ");
		article.setContent(content);
		request.setAttribute("article", article);
		request.setAttribute("page", page);

		path.setPath("/board/boardModify.jsp");
		return path;
	}
 
}
 