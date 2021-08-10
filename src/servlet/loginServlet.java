package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.loginDao;
import model.User;
 
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");   
		 String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String country = request.getParameter("country");
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
		
		User user=new User(username,password,email,gender,country,first_name,last_name);    
		
	    try {
	    	int result=loginDao.login(user);
			
			if(result>0) 
				request.getRequestDispatcher("main.jsp").forward(request, response);
			else 
				request.getRequestDispatcher("login.jsp").forward(request, response);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
 
	}
 
}

