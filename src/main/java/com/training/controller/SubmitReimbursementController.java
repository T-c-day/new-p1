package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.model.Reimbursements;
import com.training.pms.dao.ReimbursementsDAO;
import com.training.pms.dao.ReimbursementsDAOImpl;

/**
 * Servlet implementation class SubmitReimbursementController
 */
public class SubmitReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReimbursementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		float amount = Float.valueOf(request.getParameter("amount")).floatValue();
		String description = request.getParameter("description");
		String status = request.getParameter("status");		
		String thatday = request.getParameter("date");
		
		
		Reimbursements reimb= new Reimbursements(username, amount, description, status, thatday, 0 );
		ReimbursementsDAO rDAO = new ReimbursementsDAOImpl();
		rDAO.submitReimbursement(reimb);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body><a href=\"employeeHome.jsp\">");
		out.println("New Reimbursement has been submitted for approval.");
		out.println("</body></html></a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
