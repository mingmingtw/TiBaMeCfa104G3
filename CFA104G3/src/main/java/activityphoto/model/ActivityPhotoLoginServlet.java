package activityphoto.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import activityphoto.model.ActivityPhotoDAO;
import core.dao.CoreDao;
import activityphoto.model.ActivityPhotoVO;

@WebServlet("/member/login")
public class ActivityPhotoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		ActivityPhotoDAO dao = new ActivityPhotoDAO();
		ActivityPhotoVO activityphoto = dao.INSERT_STMT(P pojo);
		System.out.println(activityphoto.getNickname());
		
	}

}
