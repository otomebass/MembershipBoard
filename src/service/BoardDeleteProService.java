package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class BoardDeleteProService {

	public boolean isArticleWriter(int boardNo, String password) throws Exception {

		boolean isArticleWriter = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		isArticleWriter = dao.isArticleBoardWirter(boardNo, password);
		close(conn);
		return isArticleWriter;
	}

	public boolean deleteArticle(int boardNo) throws Exception {

		boolean isDeleteSuccess = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		int deleteCount = dao.deleteArticle(boardNo);

		if (deleteCount > 0) {
			commit(conn);
			isDeleteSuccess = true;
		} else {
			rollback(conn);
		}

		close(conn);
		return isDeleteSuccess;
	}
}
