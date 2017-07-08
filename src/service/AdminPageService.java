package service;

import static DB.DB.getConnection;

import java.sql.Connection;

import DAO.DAO;

public class AdminPageService {

	public int waituser() throws Exception{
		int i=0;
		
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		i = dao.countuser();
		return i;
	}
	public int manageuser() throws Exception{
		int j=0;
		
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		j = dao.countmanageuser();
		return j;
	}
	
	public int managereject() throws Exception{
		int k=0;
		
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		k = dao.countmanagereject();
		return k;
	}
}
