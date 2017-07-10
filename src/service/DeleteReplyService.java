package service;

import static DB.DB.*;
import java.sql.*;

import DAO.*;

public class DeleteReplyService {

	public boolean deleteReply(int pkNo, int boardNo, String boardReply) {

		boolean isSuccessDelete = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessDeleteReply = dao.deleteReply(pkNo);
		int isSuccessReply = dao.updateReplycount(boardNo,boardReply);

		if (isSuccessReply > 0) {
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}

		if (isSuccessDeleteReply > 0) {
			isSuccessDelete = true;
			commit(conn);
			close(conn);
		} else {
			rollback(conn);
		}
		return isSuccessDelete;

	}
}
