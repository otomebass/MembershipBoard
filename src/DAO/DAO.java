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
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

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
	public ArrayList<BoardBean> selectArticleList(String name, int page, int limit, String sort, String search) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startRow = (page - 1) * 10; // 紐� 踰덉㎏ 遺��꽣 �씫�뼱 �삱 寃껋씤媛�

		try {

			if (sort.equals("readCount")) {
				sql = "select * from board order by readCount desc limit ?,12";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			} else if (sort.equals("replyCount")) {
				sql = "select * from reply order by replyCount desc limit ?,12";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			} else if (sort.equals("searchPro")) {
				sql = "select * from board inner join user on user.id=board.id where user.name like ? or board.title like ? or board.content like ? limit ?,12";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
				pstmt.setString(3, "%" + search + "%");
				pstmt.setInt(4, startRow);
			} else {
				sql = "select * from board order by boardNo desc limit ?,12";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardBean();
				board.setBoardNo(rs.getInt("boardNo"));
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setBoardDate(rs.getDate("boardDate"));
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

			sql = "insert into board(boardNo,id,title,content,readCount,boardDate) ";
			sql += "values(?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getId());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContent());
			pstmt.setInt(5, 0);

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertArticle Error" + e);
		} finally {
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
				boardBean.setBoardNo(rs.getInt("boardNo"));
				boardBean.setTitle(rs.getString("title"));
				String content = rs.getString("content");
				content = content.replace("\n", "<br>");
				content = content.replace(" ", "&nbsp;");
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
			System.out.println("updateArticle Error" + e);
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

	// �쉶�썝媛��엯 �떊泥� 紐⑸줉
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
				user.setWho(rs.getString("who"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	// �쉶�썝媛��엯
	public void New(NewUser newuser) {
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
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
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
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return newuser;
	}

	public void MoveUser(NewUser newuser) {
		PreparedStatement pstmt = null;
		String sql = "insert into user(name,id,pwd,email,addr,who) values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newuser.getName());
			pstmt.setString(2, newuser.getId());
			pstmt.setString(3, newuser.getPwd());
			pstmt.setString(4, newuser.getEmail());
			pstmt.setString(5, newuser.getAddr());
			pstmt.setString(6, newuser.getWho());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	public void DoneMove(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from newuser where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
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
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return list;
	}

}