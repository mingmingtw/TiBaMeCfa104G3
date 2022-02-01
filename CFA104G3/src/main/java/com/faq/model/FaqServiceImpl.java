package com.faq.model;

import java.util.List;

import com.faq.model.FaqVO;

public class FaqServiceImpl {
	private FaqDAOJDBCImpl dao;

	public FaqServiceImpl() {
		dao = new FaqDAOJDBCImpl();
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
	public List<FaqVO> selectAll(){
		return dao.selectAll();
	}
}
