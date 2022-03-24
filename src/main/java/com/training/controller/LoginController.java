package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.Employee;
import com.training.pms.dao.UserDAO;
import com.training.pms.dao.UserDAOImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		HttpSession session= request.getSession();
		session.setAttribute("username", uname);
		
		UserDAO loginDAO = new UserDAOImpl(); 
		boolean result = loginDAO.validate(uname, pwd);
		boolean check = loginDAO.checkType(uname, pwd);
		
		if(result) {
			if(check) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("managerHome.jsp");
				dispatcher.include(request, response);
			}else {
				List<Employee> temp = loginDAO.getUsersByUserName( uname );
				for( Employee e : temp )
				{
				System.out.println(temp);
				}
				
				Employee.setEmplog(loginDAO.getUsersByUserName(uname).get(0));
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("employeeHome.jsp");
				dispatcher1.include(request, response);
				
				}
		} else {
			out.println("<h1>Your username/password is incorrect, please <a href=index.jsp>login</a> again</h1>");
		}
		out.println("</body></html>");
	}

}
