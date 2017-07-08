package service;

import static DB.DB.close;
import static DB.DB.commit;
import static DB.DB.getConnection;

import java.sql.Connection;

import DAO.DAO;

public class AdminAllowBanService {

	public void allow(String id){
		Connection conn = getConnection();
		DAO dao = DAO.getInstance();
		dao.setConnection(conn);
		
		dao.movetouser(dao.Selectbanuser(id));
		dao.deleteBan(id);
		
		commit(conn);
		close(conn);
	}
}
