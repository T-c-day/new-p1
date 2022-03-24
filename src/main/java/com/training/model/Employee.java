package com.training.model;

import java.util.Objects;

public class Employee {
	private int userID;
	private String username;
	private String password;
	private String type;
	private String fname;
	private String lname;
	private String city;
	private String state;
	private static Employee emplog;
	
	public Employee(int userID, String username, String password, String type) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	
	public Employee(String username, String fname, String lname, String city, String state) {
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
	}
	public Employee(int userID, String username, String password, String type, String fname, String lname, String city,
			String state) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.type = type;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, fname, lname, password, state, type, userID, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(city, other.city) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname) && Objects.equals(password, other.password)
				&& Objects.equals(state, other.state) && Objects.equals(type, other.type) && userID == other.userID
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Employee [userID=" + userID + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", fname=" + fname + ", lname=" + lname + ", city=" + city + ", state=" + state + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Employee getEmplog() {
		return emplog;
	}
	public static void setEmplog(Employee emplog) {
		Employee.emplog = emplog;
	}
	

}
