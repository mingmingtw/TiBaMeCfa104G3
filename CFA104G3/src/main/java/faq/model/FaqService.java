package faq.model;

import java.util.List;

public class FaqService {
	private FaqDAO dao;

	public FaqService() {
		dao = new FaqDAO();
	}

	public FaqVO addFaq(String id, String question, String answer) {

		FaqVO faqVO = new FaqVO();

		faqVO.setId(id);
		faqVO.setQuestion(question);
		faqVO.setAnswer(answer);

		dao.insert(faqVO);

		return faqVO;
	}

	public FaqVO updateFaq(String id, String question, String answer) {

		FaqVO faqVO = new FaqVO();

		faqVO.setId(id);
		faqVO.setQuestion(question);
		faqVO.setAnswer(answer);
		dao.update(faqVO);

		return faqVO;
	}

	public int deleteById(Integer id) {
		return dao.deleteById(id);
	}

	public FaqVO getOneFaq(Integer id) {
		return dao.selectById(id);
	}
}
