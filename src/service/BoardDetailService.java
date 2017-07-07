package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class BoardDetailService {

	public BoardBean getArticle(int boardNo) throws Exception {

		BoardBean article = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int updateCount = dao.updateReadCount(boardNo);

		if (updateCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		article = dao.selectArticle(boardNo);

		close(conn);

		return article;
	}
}
