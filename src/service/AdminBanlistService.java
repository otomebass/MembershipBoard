package service;

import static DB.DB.close;
import static DB.DB.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.DAO;
import VO.Reject;

public class AdminBanlistService {

	public ArrayList<Reject> showban() throws Exception{
		ArrayList<Reject> reject = null;
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		reject = dao.banlist();
		close(conn);
		return reject;
	}	
}
