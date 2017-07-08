package service;

import static DB.DB.*;

import java.sql.*;
import java.util.*;

import DAO.*;
import VO.*;

public class BoardDetailService {

	public int getReplyCount(int boardNo) {
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		int getReplyCount = dao.replyCount(boardNo);

		return getReplyCount;
	}

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

		commit(conn);
		close(conn);

		return article;
	}

	public ArrayList<ReplyBean> getReplyList(int boardNo) {

		ArrayList<ReplyBean> replyList = new ArrayList<ReplyBean>();
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		replyList = dao.selectReplyList(boardNo);

		close(conn);
		return replyList;
	}
}
