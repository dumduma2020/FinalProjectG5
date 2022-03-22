package com.petcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.petcare.model.Register;
import com.petcare.model.RegisterContainer;

public class UserDao{

	 	private static final String selct_user_by_id = "select owner_id ,fname,lname, gender, age, address, email from owner where owner_id =?";
	    private static final String select_all_owner = "select * from owner";
	    private static final String delete_owner_by_id = "delete from owner where owner_id = ?;";
	    private static final String update_owner = "update owner set fname = ?, lname = ?, gender = ?, age = ?, address = ?, email = ? where owner_id = ?;";


	public RegisterContainer selectOwner(long id) {
		RegisterContainer register = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = UtilityDB.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(selct_user_by_id);) {
	            preparedStatement.setLong(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                long owner_id = rs.getLong("owner_id");
	                String fname = rs.getString("fname");
	                String lname = rs.getString("lname");
	                String gender = rs.getString("gender");
	                int age = rs.getInt("age");
	                String address = rs.getString("address");
	                String email = rs.getString("email");
	               
	                register = new RegisterContainer(owner_id,fname,  lname,  gender,  age,  address, email);
	                
	            }
	        } catch (SQLException exception) {
	        	UtilityDB.printSQLException(exception);
	        }
	        return register;
	}


	public List<Employeetodo> selectAllEmployee() {
		 // using try-with-resources to avoid closing resources (boiler plate code)
        List < Employeetodo > todos = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String username = rs.getString("username");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("is_done");
                todos.add(new Employeetodo(id, title, username, description, targetDate, isDone));
                
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return todos;
	}


	public boolean deleteEmployee(int id) throws SQLException {
		 boolean rowDeleted;
	        try (Connection connection = JDBCUtils.getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_BY_ID);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	}


	public boolean updateEmployee(Employeetodo employeetodo) throws SQLException {
		 boolean rowUpdated;
	        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES);) {
	            statement.setString(1, employeetodo.getTitle());
	            statement.setString(2, employeetodo.getUsername());
	            statement.setString(3, employeetodo.getDesc());
	            statement.setDate(4, JDBCUtils.getSQLDate(employeetodo.getTargetdate()));
	            statement.setBoolean(5, employeetodo.isStatus());
	            statement.setLong(6, employeetodo.getId());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	}
	
