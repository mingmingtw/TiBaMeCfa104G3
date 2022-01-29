package faq.model;

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
import faq.model.FaqVO;

public class FaqDAO implements CoreDao<FaqVO, Integer> {

	private static final String INSERT_STMT = "INSERT INTO FAQ" + "(FAQ_ID,FAQ_QUESTION,FAQ_ANSWER) "
			+ "VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT " + "FAQ_ID,FAQ_QUESTION,FAQ_ANSWER "
			+ "FROM FAQ order by FAQ_ID";
	private static final String GET_ONE_STMT = "SELECT " + "FAQ_ID,FAQ_QUESTION,FAQ_ANSWER "
			+ "FROM FAQ where FAQ_ID = ?";
	private static final String DELETE = "DELETE FROM FAQ where FAQ_ID = ?";
	private static final String UPDATE = "UPDATE FAQ set " + "FAQ_ID=?,FAQ_QUESTION=?,FAQ_ANSWER=?" + "where FAQ_ID=?";

	static {
		try {
			Class.forName(SQLUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(FaqVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertedRow;

		try {

			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, pojo.getId());
			pstmt.setString(2, pojo.getQuestion());
			pstmt.setString(3, pojo.getAnswer());

			insertedRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {

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
	public int update(FaqVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRow;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, pojo.getId());
			pstmt.setString(2, pojo.getQuestion());
			pstmt.setString(3, pojo.getAnswer());

			updateRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, null);
		}

		return updateRow;
	}

	@Override
	public FaqVO selectById(Integer id) {
		FaqVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new FaqVO();
				vo.setId(rs.getString(1));
				vo.setQuestion(rs.getString(2));
				vo.setAnswer(rs.getString(3));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, rs);
		}

		return vo;
	}

	@Override
	public List<FaqVO> selectAll() {
		List<FaqVO> list = new ArrayList<FaqVO>();
		FaqVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new FaqVO();
				vo.setId(rs.getString(1));
				vo.setQuestion(rs.getString(2));
				vo.setAnswer(rs.getString(3));

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
