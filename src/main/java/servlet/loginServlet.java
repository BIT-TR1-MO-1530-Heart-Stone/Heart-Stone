package servlet;

import dao.LoginDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");   
		 String email = request.getParameter("username");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String screenname = request.getParameter("screenname");
			String phone_number = request.getParameter("phone_number");
			String info = request.getParameter("info");
			int gender = 1;
		
		User user=new User( email, password, fullname, screenname, phone_number, info, gender);
		
	    try {
	    	int result= LoginDao.login(user);
			
			if(result>0) 
				request.getRequestDispatcher("main.jsp").forward(request, response);
			else 
				request.getRequestDispatcher("login.jsp").forward(request, response);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
 
	}
 
}

