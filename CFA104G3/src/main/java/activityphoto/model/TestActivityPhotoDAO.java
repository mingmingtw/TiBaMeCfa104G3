package activityphoto.model;



import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



// 一個方法對應一個test
public class TestActivityPhotoDAO {
	private ActivityPhotoDAO dao;
	
	// 建立物件
	@BeforeEach
	public void before() {
		dao = new ActivityPhotoDAO();
	}

	// 清除
	@After
	public void after() {
		dao = null;
	}
	
	// 注意命名方式大小寫
	@Test
	public void testInsert() {
		ActivityPhotoVO pojo = new ActivityPhotoVO();
		
		// TODO 填入資料, 注意FK資料是否存在
		pojo.setId(5);
		pojo.setActivityId(5);
		pojo.setPhoto(null);
		
		
		
		int row = dao.insert(pojo);
		assertNotEquals(row, 0);
	}
	
	@Test
	public void testdeleteById() {
		// TODO 刪除後別忘記還原
		int row = dao.deleteById(2);
		assertNotEquals(row, 2);
	}
	
	@Test
	public void testUpdate() {
		// TODO 請記得填入vo資料
		ActivityPhotoVO pojo = new ActivityPhotoVO();
		
		// TODO 填入資料, 注意PK、FK資料是否存在
		pojo.setId(1);
		pojo.setActivityId(1);
		pojo.setPhoto(null);
		
		
		int row = dao.update(pojo);
		assertNotEquals(row, 4);
	}
	
	@Test
	public void testselectById() {
		ActivityPhotoVO vo = dao.selectById(1);
		assertNotNull(vo);
	}
	
	@Test
	public void testSelectAll() {
		List<ActivityPhotoVO> vos = dao.selectAll();
		assertTrue(vos.size() >1);
	}
}

