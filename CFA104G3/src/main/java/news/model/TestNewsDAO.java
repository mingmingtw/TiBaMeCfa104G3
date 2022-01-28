package news.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import news.model.NewsVO;

public class TestNewsDAO {
	private NewsDAO dao;

	@BeforeEach
	public void before() {
		dao = new NewsDAO();
	}

	@AfterEach
	public void after() {
		dao = null;
	}

	@Test
	public void testInsert() {
		NewsVO pojo = new NewsVO();

		byte[] data = new byte[1];
		data[0] = 0x05;
		pojo.setContent("最新消息內容");
		pojo.setImage(data);
		pojo.setDate(Timestamp.valueOf("2022-10-12 15:00:06"));
		pojo.setType(1);

		int row = dao.insert(pojo);
		assertNotEquals(row, 0);
	}

	@Test
	public void testDeleteById() {
		int row = dao.deleteById(1);
		assertNotEquals(row, 0);
	}

	@Test
	public void testUpdate() {
		NewsVO pojo = new NewsVO();

		byte[] data = new byte[1];
		data[0] = 0x06;
		pojo.setId(1);
		pojo.setContent("最新消息內容");
		pojo.setImage(data);
		pojo.setDate(Timestamp.valueOf("2022-10-12 15:00:06"));
		pojo.setType(1);

		int row = dao.update(pojo);
		assertNotEquals(row, 0);
	}

	@Test
	public void testSelectById() {
		NewsVO vo = dao.selectById(1);
		assertNotNull(vo);
	}

	@Test
	public void testSelectAll() {
		List<NewsVO> vos = dao.selectAll();
		assertTrue(vos.size() > 1);
	}
}