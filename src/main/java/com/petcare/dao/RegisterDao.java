package com.petcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petcare.model.Register;

public class RegisterDao {
private static final String INSERT_OWNER_SQL = "INSERT INTO owner" + 
		"( user_role, fname, lname, gender, age, address, email, username, password ) VALUES" 
		 + "( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

private static final String SELECT_ALL_OWNERS = "select * from owner";


public int register(Register owner) throws ClassNotFoundException{
		
	int result = 0;
	ResultSet rs = null;
	
	try (Connection connection = UtilityDB.getConnection();
		
		PreparedStatement check = connection.prepareStatement(SELECT_ALL_OWNERS)) {
        rs =  check.executeQuery();
			
        int count = 0;
        while(rs.next()){
        	
        	// if user_role not null or empty
        	
            	try (Connection connection2 = UtilityDB.getConnection();
            		PreparedStatement preparedStatement = connection2.prepareStatement(INSERT_OWNER_SQL)){
        			
        			preparedStatement.setString(1, "User");
        			preparedStatement.setString(2, owner.getFname());
                    preparedStatement.setString(3, owner.getLname());
                    preparedStatement.setString(4, owner.getGender());
                    preparedStatement.setInt(5, owner.getAge());
                    preparedStatement.setString(6, owner.getAddress());
                    preparedStatement.setString(7, owner.getEmail());
                    preparedStatement.setString(8, owner.getUsername());
                    preparedStatement.setString(9, owner.getPassword());

                    System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate();
            		}
            	catch (SQLException e) {

            		UtilityDB.printSQLException(e);
        		}

        		return result;

        }
        if(count == 0){ 
        	// if user_role is null or empty

        	try (Connection connection2 = UtilityDB.getConnection();
            		PreparedStatement preparedStatement = connection2.prepareStatement(INSERT_OWNER_SQL)){
        			
        			preparedStatement.setString(1, "Admin");
        			preparedStatement.setString(2, owner.getFname());
                    preparedStatement.setString(3, owner.getLname());
                    preparedStatement.setString(4, owner.getGender());
                    preparedStatement.setInt(5, owner.getAge());
                    preparedStatement.setString(6, owner.getAddress());
                    preparedStatement.setString(7, owner.getEmail());
                    preparedStatement.setString(8, owner.getUsername());
                    preparedStatement.setString(9, owner.getPassword());

                    System.out.println(preparedStatement);
                    // Step 3: Execute the query or update query
                    result = preparedStatement.executeUpdate();
            		}
            	catch (SQLException e) {

            		UtilityDB.printSQLException(e);
        		}

        		return result;
        }
       
	} catch (SQLException e) {

		UtilityDB.printSQLException(e);
	}

	return result;
	
}
}
