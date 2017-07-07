package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class BoardModifyProService {

	public boolean isArticleWriter(int boardNo, String password) throws Exception {

		boolean isArticleWriter = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		isArticleWriter = dao.isArticleBoardWirter(boardNo, password);
		close(conn);
		return isArticleWriter;
	}

	public boolean modifyArticle(BoardBean article, String name) throws Exception {

		boolean isModifySuccess = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		int updateCount = dao.updateArticle(article, name);

		if (updateCount > 0) {
			commit(conn);
			isModifySuccess = true;
		} else {
			rollback(conn);
		}
		close(conn);
		return isModifySuccess;

	}
}
