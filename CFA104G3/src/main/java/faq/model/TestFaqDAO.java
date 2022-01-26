package faq.model;



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
public class TestFaqDAO {
	private FaqDAO dao;
	
	// 建立物件
	@BeforeEach
	public void before() {
		dao = new FaqDAO();
	}

	// 清除
	@After
	public void after() {
		dao = null;
	}
	
	// 注意命名方式大小寫
	@Test
	public void testInsert() {
		FaqVO pojo = new FaqVO();
		
		// TODO 填入資料, 注意FK資料是否存在
		pojo.setId(5);
		pojo.setQuestion("安安");
		pojo.setAnswer("好醜");
		
		
		int row = dao.insert(pojo);
		assertNotEquals(row, 0);
	}
	
	@Test
	public void testdeleteById() {
		// TODO 刪除後別忘記還原
		int row = dao.deleteById(4);
		assertNotEquals(row, 4);
	}
	
	@Test
	public void testUpdate() {
		// TODO 請記得填入vo資料
		FaqVO pojo = new FaqVO();
		
		// TODO 填入資料, 注意PK、FK資料是否存在
		pojo.setId(5);
		pojo.setQuestion("安安");
		pojo.setAnswer("好醜");
		
		int row = dao.update(pojo);
		assertNotEquals(row, 5);
	}
	
	@Test
	public void testselectById() {
		FaqVO vo = dao.selectById(1);
		assertNotNull(vo);
	}
	
	@Test
	public void testSelectAll() {
		List<FaqVO> vos = dao.selectAll();
		assertTrue(vos.size() > 0);
	}
}


