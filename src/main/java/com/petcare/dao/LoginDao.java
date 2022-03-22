package com.petcare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.petcare.model.LoginBean;

public class LoginDao {
	public String authenticateUser(LoginBean loginbean) {		
		  String username = loginbean.getUsername();
		  String password = loginbean.getPassword();
		  
		  Connection connection = null;
		  Statement statement = null;
		  ResultSet rs = null;
		  
		  String usernameDB = "";
		  String passwordDB = "";
		  String user_roleDB = "";
		  	  
		  try {
			  connection = UtilityDB.getConnection();
			  statement = connection.createStatement();
			  rs = statement.executeQuery("select username, password, user_role from owner");
			  
			  while(rs.next()) {
				  usernameDB = rs.getString("username");
				  passwordDB = rs.getString("password");
				  user_roleDB = rs.getString("user_role");

				  if(username.equals(usernameDB) && password.equals(passwordDB) && user_roleDB.equals("Admin")) 
						return "Admin_Role";
				  
				  else if(username.equals(usernameDB) && password.equals(passwordDB) && user_roleDB.equals("User"))
						return "User_Role";
			  	}
			}
			catch(SQLException e){
				e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}
