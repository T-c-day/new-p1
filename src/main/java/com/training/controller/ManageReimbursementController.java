package com.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.Reimbursements;
import com.training.pms.dao.ReimbursementsDAO;
import com.training.pms.dao.ReimbursementsDAOImpl;

/**
 * Servlet implementation class ManageReimbursementController
 */
public class ManageReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageReimbursementController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReimbursementsDAO dao = new ReimbursementsDAOImpl();
		HttpSession session = request.getSession();

		List<Reimbursements> list = new ArrayList<Reimbursements>();
		list = dao.getemployeePending();

		for (Reimbursements t : list) {
			String res = request.getParameter("radio" + t.getReimId());
			System.out.println(res);
			
			if(res== null) {
				
			}
			else if (res.equals("approve")) {
				dao.approveReim(t);
			} else if (res.equals("deny")) {
				dao.denyReim(t);
			}
		}
		RequestDispatcher dis= null;
		dis = request.getRequestDispatcher("managerHome.jsp");
        dis.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
