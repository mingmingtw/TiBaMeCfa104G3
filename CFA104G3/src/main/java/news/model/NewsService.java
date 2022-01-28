package news.model;

import java.sql.Timestamp;

public class NewsService {
	private NewsDAO dao;

	public NewsService() {
		dao = new NewsDAO();
	}

	public NewsVO addNews(Integer id, String content, byte[] image, Timestamp date, Integer type) {

		NewsVO newsVO = new NewsVO();

		newsVO.setId(id);
		newsVO.setContent(content);
		newsVO.setImage(image);
		newsVO.setDate(date);
		newsVO.setType(type);
		dao.insert(newsVO);

		return newsVO;
	}

	public NewsVO updateFaq(Integer id, String content, byte[] image, Timestamp date, Integer type) {

		NewsVO newsVO = new NewsVO();
		newsVO.setId(id);
		newsVO.setContent(content);
		newsVO.setImage(image);
		newsVO.setDate(date);
		newsVO.setType(type);
		dao.update(newsVO);

		return newsVO;
	}

	public int deleteById(Integer id) {
		return dao.deleteById(id);
	}

	public NewsVO getOneNews(Integer id) {
		return dao.selectById(id);
	}
}
