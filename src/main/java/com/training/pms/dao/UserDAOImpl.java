package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.model.Employee;
import com.training.model.Reimbursements;
import com.training.pms.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	Connection connection = DBConnection.getConnection();
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public boolean register(Employee user) {
		System.out.println("Creating new user: " + user);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getType());

			statement = connection.prepareStatement("insert into ersuser values(default,?,?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getType());

			rows = statement.executeUpdate();
			System.out.println(rows + " user registered successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (rows == 0) {
			return false;
		}
		return true;
	}

	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {

			stat = connection.prepareStatement("select * from ersuser where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();

			System.out.println("validate is running");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (userValid) {
			logger.info(username + " logged in successfully");

		} else {
			logger.warn(username + " attempted to log in");
		}
		return userValid;
	}

	public List<Employee> getUsers() {
		System.out.println("Printing all users  ");
		List<Employee> employee = new ArrayList<Employee>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from ersuser");
			while (res.next()) {
				Employee employees = new Employee();
				employees.setUserID(res.getInt(1));
				employees.setUsername(res.getString(2));
				employees.setPassword(res.getString(3));
				employees.setType(res.getString(4));
				employee.add(employees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> getUsersByUserName(String username) {
		System.out.println("Printing all users by username");
		List<Employee> employees = new ArrayList<Employee>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from ersuser where username='" + username + "'");
			while (res.next()) {
				Employee employee = new Employee();
				employee.setUserID(res.getInt(1));
				employee.setUsername(res.getString(2));
				employee.setPassword(res.getString(3));
				employee.setType(res.getString(4));
				employee.setFname(res.getString(5));
				employee.setLname(res.getString(6));
				employee.setCity(res.getString(7));
				employee.setState(res.getString(8));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean checkType(String username, String password) {
		boolean validManager = false;
		PreparedStatement stat;
		try {
			stat = connection
					.prepareStatement("select * from ersuser where username= ? and password= ? and type= 'Manager' ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			validManager = res.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return validManager;
	}

	@Override
	public boolean updateUserInfo(Employee emp) {
		System.out.println("Updating user information");
		PreparedStatement statement = null;
		
		try {
		statement = connection.prepareStatement("update ersuser set fname= ?, lname= ?, city= ?, state=? where username=?");
		statement.setString(2, emp.getFname());
		statement.setString(3, emp.getLname());
		statement.setString(4, emp.getCity());
		statement.setString(5, emp.getState());
		statement.setString(1, emp.getUsername());

		statement.execute();
		System.out.println("user info updated successfully");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NullPointerException e) {
		e.printStackTrace();
	}
	return true;
	}
}
