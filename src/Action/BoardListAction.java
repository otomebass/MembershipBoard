package Action;

import java.util.*;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class BoardListAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		Path path = null;
		int page = 1; // 현재 페이지
		int limit = 11; // 한 페이지에 몇 개의 글을 보여 줄 것인가
		String sort = "boardList";
		String search = "";
		String pagingLogic = "";
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
			search = request.getParameter("search");
			pagingLogic = sort;
			request.setAttribute("sort", sort);
			request.setAttribute("pagingLogic", pagingLogic);
			path = new Path();
			path.setPath("/board/boardList.jsp?sort=" + sort);
		} else {
			path = new Path();
			path.setPath("/board/boardList.jsp");
		}

		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount(); // 게시글의 총 개수를 구해옴
		articleList = boardListService.getArticleList(page, limit, sort, search);
		// 게시글의 리스트를구해옴
		int maxPage = listCount / limit;
		if (listCount % limit > 0)
			maxPage++;

		int startPage = ((page - 1) / 10) * 10 + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		request.setAttribute("page", page);

		return path;
	}

}
