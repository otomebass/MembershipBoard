package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Path;
import service.AdminAllowBanService;

public class AdminRejoinUserAction implements Action {

	@Override
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Path path = new Path();
	
		String id = request.getParameter("id");
		
		AdminAllowBanService aabs = new AdminAllowBanService();
		aabs.allow(id);
		path.setPath("/AdminBanList.do");
		return path;
	}

}
