package activityphoto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import activityphoto.model.ActivityPhotoVO;

import core.dao.CoreDao;
import core.util.SQLUtil;


public class ActivityPhotoDAO implements CoreDao<ActivityPhotoVO, Integer> {
	private static final String INSERT_STMT = "INSERT INTO ACTIVITY_PHOTO"
			+ "(ACTP_ID,ACTP_ACT_ID,ACTP_PHOTO) "
			+ "VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT "
			+ "ACTP_ID,ACTP_ACT_ID,ACTP_PHOTO "
			+ "FROM ACTIVITY_PHOTO order by ACTP_ID";
	private static final String GET_ONE_STMT = "SELECT "
			+ "ACTP_ID,ACTP_ACT_ID,ACTP_PHOTO "
			+ "FROM ACTIVITY_PHOTO where ACTP_ID = ?";
	private static final String DELETE = "DELETE FROM ACTIVITY_PHOTO where ACTP_ID = ?";
	private static final String UPDATE = "UPDATE ACTIVITY_PHOTO set "
			+ "ACTP_ID=?,ACTP_ACT_ID=?,ACTP_PHOTO=? "
			+ "where ACTP_ID=?";

	// 將class載入動作統一至static內
	static {
		try {
			Class.forName(SQLUtil.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(ActivityPhotoVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertedRow;

		try {
			// SQL參數一律使用SqlUtil處理
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			// 注意參數擺放是否正確
			pstmt.setInt(1, pojo.getActivityId());
			pstmt.setInt(2, pojo.getActivityId());
			pstmt.setBytes(3, pojo.getPhoto());
			

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
	public int update(ActivityPhotoVO pojo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRow;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, pojo.getId());
			pstmt.setInt(2, pojo.getActivityId());
			pstmt.setBytes(3, pojo.getPhoto());
			

			updateRow = pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, null);
		}

		return updateRow;
	}

	@Override
	public ActivityPhotoVO selectById(Integer id) {
		ActivityPhotoVO vo = null;
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
				vo = new ActivityPhotoVO();
				vo.setActivityId(rs.getInt(1));
				vo.setActivityId(rs.getInt(2));
				vo.setPhoto(rs.getBytes(3));
				
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			SQLUtil.closeResource(con, pstmt, rs);
		}

		return vo;
	}

	@Override
	public List<ActivityPhotoVO> selectAll() {
		List<ActivityPhotoVO> list = new ArrayList<ActivityPhotoVO>();
		ActivityPhotoVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SQLUtil.URL, SQLUtil.USER, SQLUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new ActivityPhotoVO();
				vo.setActivityId(rs.getInt(1));
				vo.setActivityId(rs.getInt(2));
				vo.setPhoto(rs.getBytes(3));
				
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

