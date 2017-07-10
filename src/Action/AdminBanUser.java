package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Path;
import service.AdminBanService;

public class AdminBanUser implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
		String id = request.getParameter("id");
		
		AdminBanService abs = new AdminBanService();
		abs.Ban(id);
		
		path.setPath("/AdminUserList.do");
		return path;
	}

}
   