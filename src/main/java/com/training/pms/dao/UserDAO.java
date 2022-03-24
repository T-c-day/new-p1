package com.training.pms.dao;

import java.util.List;

import com.training.model.Employee;
import com.training.model.Reimbursements;


public interface UserDAO {
	public boolean register(Employee user);
	public boolean validate(String username,String password);
	public boolean checkType(String username, String password);
	public List<Employee> getUsers();
	public List<Employee> getUsersByUserName(String username);
	public boolean updateUserInfo(Employee emp);
}
