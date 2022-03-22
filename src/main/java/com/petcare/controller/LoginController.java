package com.petcare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petcare.dao.LoginDao;
import com.petcare.model.LoginBean;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
			request.setAttribute("errMessage", "You have logout successfully");
			RequestDispatcher requestDispatcher =  request.getRequestDispatcher("jsp/login.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("Logged out");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginbean = new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		LoginDao loginDao = new LoginDao();
		
			try {
				String userValidate = loginDao.authenticateUser(loginbean);
				if(userValidate.equals("Admin_Role")) {
					System.out.println("Admin's dashboard");
					HttpSession session = request.getSession();
					session.setAttribute("Admin", username);
					request.setAttribute("username", username);
					request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
				}
				else if(userValidate.equals("User_Role")) {
					System.out.println("Users dashboard");
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10*60);
					session.setAttribute("User", username);
					request.setAttribute("username", username);
					request.getRequestDispatcher("jsp/user.jsp").forward(request, response);
				}
				else {
					System.out.println("Error message =" +userValidate);
					request.setAttribute("errMessage", userValidate);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			catch(IOException e1){
				e1.printStackTrace();	
			}
			catch(Exception e2){
				e2.printStackTrace();	
		}
	}

}
