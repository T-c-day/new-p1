package com.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Reimbursements;
import com.training.pms.dao.ReimbursementsDAO;
import com.training.pms.dao.ReimbursementsDAOImpl;

public class ReimbursementController {
	
	public static String loadExpenses(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementsDAO reimImpl = new ReimbursementsDAOImpl();
		List<Reimbursements> lReim = new ArrayList<Reimbursements>();
		lReim = reimImpl.selectAllReimbursements();
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(lReim));
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return "managerHome.jsp";
	}

}
