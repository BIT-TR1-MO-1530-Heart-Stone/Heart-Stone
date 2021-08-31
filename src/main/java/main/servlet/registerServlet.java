package main.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import main.dao.loginDao;
import main.model.User;
 
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 this.doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");   
		 String email = request.getParameter("email");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String screenname = request.getParameter("screenname");
			String phone_number = request.getParameter("phone_number");
			String info = request.getParameter("info");
			int gender = Integer.parseInt(request.getParameter("gender"));
		
		User user=new User( email, password, fullname, screenname, phone_number, info, gender);  
		
		try {
			boolean result=loginDao.register(user);
			
			if(result==true) {
				System.out.println("ע��ɹ���");
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
