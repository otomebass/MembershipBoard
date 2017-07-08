package service;

import static DB.DB.*;

import java.sql.*;

import DAO.*;
import VO.*;

public class ReplyProService {

	public boolean registerReply(ReplyBean replyBean, int boardNo) throws Exception {

		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessReply = dao.insertReply(replyBean, boardNo);

		if (isSuccessReply > 0) {
			isWriteSuccess = true;
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return isWriteSuccess;
	}

	public void updateReplyCount(int boardNo) {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);

		int isSuccessReply = dao.updateReplycount(boardNo);

		if (isSuccessReply > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}

}
