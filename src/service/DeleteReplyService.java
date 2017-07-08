package service;

import static DB.DB.*;
import java.sql.*;

import DAO.*;

public class DeleteReplyService {

	public boolean deleteReply(int pkNo) {

		boolean isSuccessDelete = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessDeleteReply = dao.deleteReply(pkNo);

		if (isSuccessDeleteReply > 0) {
			isSuccessDelete = true;
			commit(conn);
			close(conn);
		}
		return isSuccessDelete;

	}
}
