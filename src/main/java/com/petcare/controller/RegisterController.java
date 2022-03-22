package com.petcare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petcare.dao.RegisterDao;
import com.petcare.model.Register;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterDao registerDao = new RegisterDao();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* super.doGet(request, response); */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		/* String user_role = request.getParameter("user_role"); */
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Register owner = new Register();
		/* owner.setUser_role(user_role); */
        owner.setFname(firstName);
        owner.setLname(lastName);
        owner.setGender(gender);
        owner.setAge(age);
        owner.setAddress(address);
        owner.setEmail(email);
        owner.setUsername(username);
        owner.setPassword(password);

        try {
            int result = registerDao.register(owner);
            if (result == 1) {
            	
                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
	
}
