package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Path;
import service.AdminDeleteUserService;

public class AdminDeleteUserAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();

		String id = request.getParameter("id");
		
		AdminDeleteUserService deleteuser = new AdminDeleteUserService();
		deleteuser.DeleteUser(id);
		
		path.setPath("AdminBanList.do");
		return path;
	}

}
