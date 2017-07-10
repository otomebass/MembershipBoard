package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import VO.Path;
import service.AdminPageService;

public class AdminPageAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		path.setPath("/board/AdminPage.jsp");
		int i, j, k;
		AdminPageService aps = new AdminPageService();
		i = aps.waituser();
		j = aps.manageuser();
		k = aps.managereject();

		request.setAttribute("i", i);
		request.setAttribute("j", j);
		request.setAttribute("k", k);
		return path;
	}

}
