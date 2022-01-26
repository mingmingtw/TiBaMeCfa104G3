package faq.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoimpl;
import web.member.vo.Member;

@WebServlet("/member/login")
public class FaqLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		MemberDao dao = new MemberDaoimpl();
		Member member = dao.selectByUsernameAndPassword(username,password);
		System.out.println(member.getNickname());
		
	}

}
