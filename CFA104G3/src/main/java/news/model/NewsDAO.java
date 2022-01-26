package news.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.dao.CoreDao;
import core.util.SQLUtil;
import news.model.NewsVO;

public class NewsDAO implements CoreDao<NewsVO, Integer> {

	private static final String INSERT_STMT = "INSERT INTO NEWS"
			+ "(NEWS_ID,NEWS_CONTENT,NEWS_IMG,NEWS_TIME,NEWS_TYPE) " + "VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT " + "NEWS_ID,NEWS_CONTENT,NEWS_IMG,NEWS_TIME,NEWS_TYPE "
			+ "FROM NEWS order by NEWS_ID";
	private static final String GET_ONE_STMT = "SELECT " + "NEWS_ID,NEWS_CONTENT,NEWS_IMG,NEWS_TIME,NEWS_TYPE "
			+ "FROM NEWS where NEWS_ID = ?";
	private static final String DELETE = "DELETE FROM NEWS where NEWS_ID = ?";
	private static final String UPDATE = "UPDATE NEWS set "
			+ "NEWS_ID=?,NEWS_CONTENT=?,NEWS_IMG=?,NEWS_TIME=?,NEWS_TYPE=? " + "where NEWS_ID=?";

	static {
		try {
			Class.forName(SQLUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(NewsVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertedRow;

		try {

			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, pojo.getId());
			pstmt.setString(2, pojo.getContent());
			pstmt.setBytes(3, pojo.getImage());
			pstmt.setTimestamp(4, pojo.getDate());
			pstmt.setInt(5, pojo.getType());

			insertedRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			// 使用SQL工具處理
			SQLUtil.closeResource(con, pstmt, null);
		}

		return insertedRow;
	}

	@Override
	public int deleteById(Integer id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRow;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, id);

			deleteRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, null);
		}

		return deleteRow;
	}

	@Override
	public int update(NewsVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRow;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, pojo.getId());
			pstmt.setString(2, pojo.getContent());
			pstmt.setBytes(3, pojo.getImage());
			pstmt.setTimestamp(4, pojo.getDate());
			pstmt.setInt(5, pojo.getType());

			updateRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, null);
		}

		return updateRow;
	}

	@Override
	public NewsVO selectById(Integer id) {
		NewsVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			// 直接寫死欄位index，不要用name
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setContent(rs.getString(2));
				vo.setImage(rs.getBytes(3));
				vo.setDate(rs.getTimestamp(4));
				vo.setType(rs.getInt(5));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, rs);
		}

		return vo;
	}

	@Override
	public List<NewsVO> selectAll() {
		List<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setContent(rs.getString(2));
				vo.setImage(rs.getBytes(3));
				vo.setDate(rs.getTimestamp(4));
				vo.setType(rs.getInt(5));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, rs);
		}

		return list;
	}

}
