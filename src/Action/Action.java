package Action;

import javax.servlet.http.*;

import VO.*;

public interface Action {
	public Path execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
