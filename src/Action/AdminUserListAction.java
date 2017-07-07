package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Path;
import service.AdminUserListService;

public class AdminUserListAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		path.setPath("/board/AdminUserList.jsp");
		
		AdminUserListService auls = new AdminUserListService();
		request.setAttribute("user", auls.showuser());
		
		return path;
	}

}
