package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class BoardWriteProService {

	public boolean registerArticle(BoardBean boardBean) throws Exception {

		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int insertCount = dao.insertArticle(boardBean);

		if (insertCount > 0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		close(conn);
		return isWriteSuccess;
	}
}
