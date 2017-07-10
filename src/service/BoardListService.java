package service;

import static DB.DB.*;

import java.sql.*;
import java.util.*;

import DAO.*;
import VO.*;

public class BoardListService {

	public int getListCount(String sort,String search) throws Exception {
		int listCount = 0;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		listCount = dao.selectListCount(sort,search);
		close(conn);
		return listCount;
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit, String sort, String search) throws Exception {
		ArrayList<BoardBean> articleList = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		articleList = dao.selectArticleList(page, limit, sort, search);
		close(conn);
		return articleList;

	}

}
