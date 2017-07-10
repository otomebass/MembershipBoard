package DAO;

import static DB.DB.*;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import VO.*;

public class DAO {

	DataSource ds;
	Connection conn;

	private static DAO dao;

	private DAO() {
	}

	public static DAO getInstance() {
		if (dao == null) {
			dao = new DAO();
		}
		return dao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	// 湲��쓽 媛쒖닔 援ы븯湲�
	public int selectListCount(String sort, String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			if (sort.equals("searchPro")) {
				sql = "select count(*) from board where name like ? or title like ? or content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
				pstmt.setString(3, "%" + search + "%");
				rs = pstmt.executeQuery();
			} else {
				sql = "select count(*) from board";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}

			if (rs.next())
				listCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("getListCount Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 湲� 紐⑸줉 蹂닿린
	public ArrayList<BoardBean> selectArticleList(int page, int limit, String sort, String search) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startRow = (page - 1) * 11; // 紐� 踰덉㎏ 遺��꽣 �씫�뼱 �삱 寃껋씤媛�

		try {

			if (sort.equals("readCount")) {
				sql = "select * from board order by readCount desc limit ?,11";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			} else if (sort.equals("replyCount")) {
				sql = "select * from board order by replyCount desc limit ?,11";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			} else if (sort.equals("searchPro")) {
				sql = "select * from board where name like ? or title like ? or content like ? limit ?,11";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
				pstmt.setString(3, "%" + search + "%");
				pstmt.setInt(4, startRow);
			} else {
				sql = "select * from board order by boardNo desc limit ?,11";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardBean();
				board.setName(rs.getString("name"));
				board.setBoardNo(rs.getInt("boardNo"));
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setBoardDate(rs.getDate("boardDate"));
				board.setReplyCount(rs.getInt("replyCount"));
				articleList.add(board);
			}

		} catch (Exception e) {
			System.out.println("selectArticleList Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	public int insertArticle(BoardBean article) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int num = 0;
		int insertCount = 0;
		String sql = "";

		try {
			pstmt = conn.prepareStatement("select max(boardNo) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into board(name,boardNo,id,title,content,readCount,replyCount,boardDate) ";
			sql += "values(?,?,?,?,?,?,?,now())";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, article.getName());
			pstmt2.setInt(2, num);
			pstmt2.setString(3, article.getId());
			pstmt2.setString(4, article.getTitle());
			pstmt2.setString(5, article.getContent());
			pstmt2.setInt(6, 0);
			pstmt2.setInt(7, 0);

			insertCount = pstmt2.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertArticle Error: " + e);
		} finally {
			close(pstmt2);
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	public BoardBean selectArticle(int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		try {
			pstmt = conn.prepareStatement("select * from board where boardNo=?");
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardBean = new BoardBean();
				boardBean.setName(rs.getString("name"));
				boardBean.setBoardNo(rs.getInt("boardNo"));
				boardBean.setId(rs.getString("id"));
				boardBean.setTitle(rs.getString("title"));
				String content = rs.getString("content");
				boardBean.setContent(content);
				boardBean.setReadCount(rs.getInt("readCount"));
				boardBean.setBoardDate(rs.getDate("boardDate"));
			}
		} catch (Exception e) {
			System.out.println("selectArticle Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardBean;
	}

	public int updateReplycount(int boardNo, String boardReply) {
		PreparedStatement pstmt = null;
		String sql = "";
		int updateReplyCount = 0;
		try {

			if (boardReply.equals("plus")) {
				sql = "update board set replyCount=replyCount+1 where boardNo=" + boardNo;
			}
			if (boardReply.equals("minus")) {
				sql = "update board set replyCount=replyCount-1 where boardNo=" + boardNo;
			}
			pstmt = conn.prepareStatement(sql);
			updateReplyCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateReplycount Error: " + e);
		} finally {
			close(pstmt);
		}
		return updateReplyCount;
	}

	public int updateReadCount(int boardNo) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update board set readCount=readCount+1 where boardNo=" + boardNo;

		try {
			pstmt = conn.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateReadCount Error: " + e);
		} finally {
			close(pstmt);
		}
		return updateCount;
	}

	public int updateArticle(BoardBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update board set title=?, content=? where boardNo=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getBoardNo());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateArticle Error: " + e);
		} finally {
			close(pstmt);
		}
		return updateCount;
	}

	public int deleteArticle(int boardNo) {

		PreparedStatement pstmt = null;
		String sql = "delete from board where boardNo=?";
		int deleteCount = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteArticle Error: " + e);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public int replyCount(int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int replyCount = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from reply where boardNo=" + boardNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				replyCount = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("replyCount Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return replyCount;
	}

	public int insertReply(ReplyBean replyArticle, int boardNo) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		int isSuccessReply = 0;
		int num = 0;
		int pkNo = 0;
		int replyCount = 0;
		String sql = "";

		try {
			pstmt = conn.prepareStatement("select max(replyNo) from reply where boardNo=" + boardNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			pstmt2 = conn.prepareStatement("select max(pKNo) from reply");
			rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				pkNo = rs2.getInt(1) + 1;
			} else {
				pkNo = 1;
			}

			pstmt3 = conn.prepareStatement("select max(replyCount) from reply where boardNo=" + boardNo);
			rs3 = pstmt3.executeQuery();
			if (rs3.next()) {
				replyCount = rs3.getInt(1) + 1;
			} else {
				replyCount = 1;
			}

			sql = "insert into reply(pkNo,boardNo,replyNo,content,name,replyCount,id) ";
			sql += "values(?,?,?,?,?,?,?)";
			pstmt4 = conn.prepareStatement(sql);

			pstmt4.setInt(1, pkNo);
			pstmt4.setInt(2, replyArticle.getBoardNo());
			pstmt4.setInt(3, num);
			pstmt4.setString(4, replyArticle.getContent());
			pstmt4.setString(5, replyArticle.getName());
			pstmt4.setInt(6, replyCount);
			pstmt4.setString(7, replyArticle.getId());

			isSuccessReply = pstmt4.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertReply Error: " + e);
		} finally {
			close(pstmt4);
			close(pstmt3);
			close(rs2);
			close(pstmt2);
			close(rs);
			close(pstmt);
		}
		return isSuccessReply;

	}

	public ArrayList<ReplyBean> selectReplyList(int boardNo) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReplyBean> replyList = new ArrayList<ReplyBean>();

		try {
			pstmt = conn.prepareStatement("select * from reply where boardNo=? order by replyNo desc;");
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReplyBean replyBean = new ReplyBean();
				replyBean.setPkNo(rs.getInt("pkNo"));
				replyBean.setBoardNo(rs.getInt("boardNo"));
				replyBean.setReplyNo(rs.getInt("replyNo"));
				String content = rs.getString("content");
				content = content.replace("\r\n", "<br>");
				content = content.replace(" ", "&nbsp;");
				replyBean.setContent(content);
				replyBean.setName(rs.getString("name"));
				replyBean.setId(rs.getString("id"));
				replyList.add(replyBean);
			}
		} catch (Exception e) {
			System.out.println("selectReplyList Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return replyList;
	}

	public int deleteReply(int pkNo) {
		PreparedStatement pstmt = null;
		int isSuccessDeleteReply = 0;
		String sql = "delete from reply where pkNo=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pkNo);
			isSuccessDeleteReply = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteReply Error: " + e);
		} finally {
			close(pstmt);
		}
		return isSuccessDeleteReply;
	}

	public User selectLoginUser(String id, String pwd) {
		User loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from user where id=? and pwd=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginUser = new User();
				loginUser.setName(rs.getString("name"));
				loginUser.setId(rs.getString("id"));
				loginUser.setPwd(rs.getString("pwd"));
				loginUser.setEmail(rs.getString("email"));
				loginUser.setAddr(rs.getString("addr"));
				loginUser.setWho(rs.getString("who"));
			}
		} catch (Exception e) {
			System.out.println("selectLoginUser Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginUser;
	}

	public ArrayList<NewUser> confirmview() {
		ArrayList<NewUser> list = new ArrayList<NewUser>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from newuser";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NewUser user = new NewUser();
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setEmail(rs.getString("email"));
				user.setAddr(rs.getString("addr"));
				user.setWho(rs.getString("who"));
				list.add(user);
			}
		} catch (Exception e) {
			System.out.println("confirmview Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	// �쉶�썝媛��엯
	public int New(NewUser newuser) {
		int isJoinSuccess = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into newuser(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newuser.getName());
			pstmt.setString(2, newuser.getId());
			pstmt.setString(3, newuser.getPwd());
			pstmt.setString(4, newuser.getEmail());
			pstmt.setString(5, newuser.getAddr());
			pstmt.setString(6, newuser.getWho());
			isJoinSuccess = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("New Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isJoinSuccess;
	}

	public NewUser SelectOneid(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewUser newuser = null;
		String sql = "select * from newuser where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				newuser = new NewUser();
				newuser.setName(rs.getString("name"));
				newuser.setId(rs.getString("id"));
				newuser.setPwd(rs.getString("pwd"));
				newuser.setEmail(rs.getString("email"));
				newuser.setAddr(rs.getString("addr"));
				newuser.setWho(rs.getString("who"));
			}
		} catch (Exception e) {
			System.out.println("SelectOneid Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return newuser;
	}

	public User Selectoneiduser(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from user where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setEmail(rs.getString("email"));
				user.setAddr(rs.getString("addr"));
				user.setWho(rs.getString("who"));
			}
		} catch (Exception e) {
			System.out.println("Selectoneiduser Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}

	public int MoveUser(NewUser newuser) {
		PreparedStatement pstmt = null;
		String sql = "insert into user(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		int isMoveUser = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newuser.getName());
			pstmt.setString(2, newuser.getId());
			pstmt.setString(3, newuser.getPwd());
			pstmt.setString(4, newuser.getEmail());
			pstmt.setString(5, newuser.getAddr());
			pstmt.setString(6, newuser.getWho());
			isMoveUser = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("MoveUser Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isMoveUser;
	}

	public int MoveUserBan(User user) {
		PreparedStatement pstmt = null;
		String sql = "insert into reject(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		int isMoveUserBan = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPwd());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddr());
			pstmt.setString(6, user.getWho());
			isMoveUserBan = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("MoveUserBan Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isMoveUserBan;
	}

	public int MoveRejectUser(NewUser newuser) {
		PreparedStatement pstmt = null;
		String sql = "insert into reject(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		int isMoveRejectUser = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newuser.getName());
			pstmt.setString(2, newuser.getId());
			pstmt.setString(3, newuser.getPwd());
			pstmt.setString(4, newuser.getEmail());
			pstmt.setString(5, newuser.getAddr());
			pstmt.setString(6, newuser.getWho());
			isMoveRejectUser = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("MoveRejectUser Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isMoveRejectUser;
	}

	public int DoneMove(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from newuser where id=?";
		int isDoneMove = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			isDoneMove = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DoneMove Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isDoneMove;
	}

	public int BanDoneMove(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from user where id=?";
		int isBanDoneMove = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			isBanDoneMove = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("BanDoneMove Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isBanDoneMove;
	}

	public ArrayList<User> AllUser() {
		ArrayList<User> list = new ArrayList<User>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setEmail(rs.getString("email"));
				user.setAddr(rs.getString("addr"));
				user.setWho(rs.getString("who"));
				list.add(user);
			}
		} catch (Exception e) {
			System.out.println("AllUser Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int countuser() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from newuser";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("countuser Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int countmanageuser() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from user";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("countmanageuser Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int countmanagereject() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from reject";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("countmanagereject Error:" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	//////////
	public Reject Selectbanuser(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reject reject = null;
		String sql = "select * from reject where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reject = new Reject();
				reject.setName(rs.getString("name"));
				reject.setId(rs.getString("id"));
				reject.setPwd(rs.getString("pwd"));
				reject.setEmail(rs.getString("email"));
				reject.setAddr(rs.getString("addr"));
				reject.setWho(rs.getString("who"));
			}
		} catch (Exception e) {
			System.out.println("Selectbanuser Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return reject;
	}

	public int movetouser(Reject reject) {
		PreparedStatement pstmt = null;
		String sql = "insert into user(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		int isMovetoUser = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reject.getName());
			pstmt.setString(2, reject.getId());
			pstmt.setString(3, reject.getPwd());
			pstmt.setString(4, reject.getEmail());
			pstmt.setString(5, reject.getAddr());
			pstmt.setString(6, reject.getWho());
			isMovetoUser = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("movetouser Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isMovetoUser;
	}

	public int deleteBan(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from reject where id=?";
		int isDeleteBan = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			isDeleteBan = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteBan Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isDeleteBan;
	}

	public ArrayList<Reject> banlist() {
		ArrayList<Reject> list = new ArrayList<Reject>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reject";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Reject reject = new Reject();
				reject.setName(rs.getString("name"));
				reject.setId(rs.getString("id"));
				reject.setPwd(rs.getString("pwd"));
				reject.setEmail(rs.getString("email"));
				reject.setAddr(rs.getString("addr"));
				reject.setWho(rs.getString("who"));
				list.add(reject);
			}
		} catch (Exception e) {
			System.out.println("banlist Error: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int deleteUser(String id) {
		PreparedStatement pstmt = null;
		int isDeleteUser = 0;
		String sql = "delete from reject where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			isDeleteUser = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteUser Error: " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return isDeleteUser;
	}

	public int idCheck(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCheck = 0;
		String sql = "select id from user where id=? union ";
		sql += "select id from newuser where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				idCheck = 1;
			}
		} catch (Exception e) {
			System.out.println(" idCheck Error: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return idCheck;
	}
}