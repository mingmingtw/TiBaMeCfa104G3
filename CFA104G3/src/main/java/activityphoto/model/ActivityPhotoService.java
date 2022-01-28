package activityphoto.model;

import faq.model.FaqDAO;
import faq.model.FaqVO;

public class ActivityPhotoService {
	private ActivityPhotoDAO dao;

	public ActivityPhotoService() {
		dao = new ActivityPhotoDAO();
	}

	public ActivityPhotoVO addActivityPhoto(Integer id, Integer activityId, byte[] photo) {

		ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();

		activityPhotoVO.setId(id);
		activityPhotoVO.setActivityId(activityId);
		activityPhotoVO.setPhoto(photo);

		dao.insert(activityPhotoVO);

		return activityPhotoVO;
	}

	public ActivityPhotoVO updateActivityPhoto(Integer id, Integer activityId, byte[] photo) {

		ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();

		activityPhotoVO.setId(id);
		activityPhotoVO.setActivityId(activityId);
		activityPhotoVO.setPhoto(photo);
		dao.update(activityPhotoVO);

		return activityPhotoVO;
	}

	public int deleteById(Integer id) {
		return dao.deleteById(id);
	}

	public ActivityPhotoVO getOneActivityPhoto(Integer id) {
		return dao.selectById(id);
	}

}
