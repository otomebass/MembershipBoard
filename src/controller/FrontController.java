package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Action.*;
import VO.*;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		Path path = null;
		Action action = null;
		if (command.equals("/MainPage.do")) {
			path = new Path();
			path.setRedirect(true);
			path.setPath(request.getContextPath() + "/MainPage.jsp");
		} else if (command.equals("/boardList.do")) {
			action = new BoardListAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardWriteForm.do")) {
			String page = request.getParameter("page");
			request.setAttribute("page", page);
			path = new Path();
			path.setPath("/board/boardWrite.jsp");
		} else if (command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.do")) {
			action = new BoardModifyProAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyForm.do")) {
			action = new BoardModifyFormAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeletePro.do")) {
			action = new BoardDeleteProAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeleteForm.do")) {
			String page = request.getParameter("page");
			request.setAttribute("page", page);
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			request.setAttribute("boardNo", boardNo);
			path = new Path();
			path.setPath("/board/boardDelete.jsp");
		} else if (command.equals("/AdminPage.do")) {
			path = new Path();
			path.setRedirect(true);
			path.setPath(request.getContextPath() + "/board/AdminPage.jsp");
		} else if (command.equals("/AdminConfirmUser.do")) {
			action = new AdminConfirmUserAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (command.equals("/NewUserForm.do")) {
			path = new Path();
			path.setPath("/board/NewUser.jsp");
		} else if (command.equals("/NewUserAction.do")) {
			action = new NewUserAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (command.equals("/ConfirmOk.do")) {
			action = new AdminConfirmOk();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (command.equals("/AdminUserList.do")) {
			action = new AdminUserListAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (command.equals("loginChk.do")) {
			// 아이디, 비번 받는 폼에서 이곳으로 와서 로그인 체크
			System.out.println("컴온");
			action = new LoginProAction();
			try {
				path = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (path != null) {
			if (path.isRedirect()) {
				response.sendRedirect(path.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(path.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
