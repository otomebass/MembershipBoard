package Action;

import javax.servlet.http.*;

import VO.*;
import service.*;

public class AdminBanListAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		path.setPath("/board/AdminBanList.jsp");

		int page = 1;
		int limit = 10;

		AdminBanlistService abls = new AdminBanlistService();

		request.setAttribute("reject", abls.showban());
		return path;
	}
}
