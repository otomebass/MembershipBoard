package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class BoardModifyProService {

	public boolean modifyArticle(BoardBean article) throws Exception {

		boolean isModifySuccess = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		int updateCount = dao.updateArticle(article);

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
 