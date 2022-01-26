package news.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.model.NewsDAO;
import core.dao.CoreDao;
import news.model.NewsVO;

@WebServlet("/news/login")
public class NewsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		System.out.println(username);
//		System.out.println(password);
		
		NewsVO pojo = new NewsVO();
		NewsVO news = pojo.GET_ONE_STMT(pojo);
		System.out.println(news.getId());
		
	}

}
