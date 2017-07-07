package filter;

import java.io.*;

import javax.servlet.*;

/**
 * Servlet Filter implementation class CharacterEncoding
 */
public class CharacterEncoding implements Filter {

	private String encoding;

	/**
	 * Default constructor.
	 */
	public CharacterEncoding() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
	}

}
