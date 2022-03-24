package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.Reimbursements;
import com.training.pms.dao.ReimbursementsDAO;
import com.training.pms.dao.ReimbursementsDAOImpl;

/**
 * Servlet implementation class EmployeeResolvedServlet
 */
public class EmployeeResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeResolvedServlet() {
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
		
		
		ReimbursementsDAO dao = new ReimbursementsDAOImpl(); 
		List<Reimbursements> result = dao.getResolved(uname);
		
		HttpSession session= request.getSession();
		session.setAttribute("resultlist",result);
		
		out.println("</body></html>");
	
	}

}
