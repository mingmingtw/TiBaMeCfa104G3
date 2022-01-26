package news.model;

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
public class TestNewsDAO {
	private NewsDAO dao;

	// 建立物件
	@BeforeEach
	public void before() {
		dao = new NewsDAO();
	}

	// 清除
	@After
	public void after() {
		dao = null;
	}

	// 注意命名方式大小寫
	@Test
	public void testInsert() {
		NewsVO pojo = new NewsVO();
		
		// TODO 填入資料, 注意FK資料是否存在
		pojo.setId(1);
		pojo.setContent("安安安安安安安安安安安");
		pojo.setImage(null);
		pojo.setDate(Timestamp.valueOf("2022-10-12 15:00:06"));
		pojo.setType(1);
				
				
			
				
		
		
		int row = dao.insert(pojo);
		assertNotEquals(row, 0);
	}

	@Test
	public void testdeleteById() {
		// TODO 刪除後別忘記還原
		int row = dao.deleteById(2);
		assertNotEquals(row, 0);
	}

	@Test
	public void testUpdate() {
		// TODO 請記得填入vo資料
		NewsVO pojo = new NewsVO();
		
		// TODO 填入資料, 注意PK、FK資料是否存在
	
		pojo.setId(1);
		pojo.setContent("安安安安安安安安安安安");
		pojo.setImage(null);
		pojo.setDate(Timestamp.valueOf("2022-10-12 15:00:06"));
		pojo.setType(1);
		int row = dao.update(pojo);
		assertNotEquals(row, 4);
	}

	@Test
	public void testselectById() {
		NewsVO vo = dao.selectById(1);
		assertNotNull(vo);
	}

	@Test
	public void testSelectAll() {
		List<NewsVO> vos = dao.selectAll();
		assertTrue(vos.size()  >1);
	}
}
