package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;

public class BoardDeleteProService {

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
 