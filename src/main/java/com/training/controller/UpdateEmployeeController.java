package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.Employee;
import com.training.model.Reimbursements;
import com.training.pms.dao.ReimbursementsDAO;
import com.training.pms.dao.ReimbursementsDAOImpl;
import com.training.pms.dao.UserDAO;
import com.training.pms.dao.UserDAOImpl;

/**
 * Servlet implementation class UpdateEmployeeController
 */
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		HttpSession session= request.getSession();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		
		
		Employee emp = new Employee(fname, lname, city, state,Employee.getEmplog().getUsername());
		System.out.println(emp);
		//Employee.getEmplog().getUsername()
		UserDAO udao = new UserDAOImpl();
		udao.updateUserInfo(emp);
		
		
		 out.println("<h1>"+fname+" you have succesfully updated your information.");
	     out.println("<h1> <a href = employeeHome.jsp >Home</a>");
		 out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
