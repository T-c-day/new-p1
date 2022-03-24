package com.training.pms.dao;

import java.util.List;

import com.training.model.Reimbursements;

public interface ReimbursementsDAO {

	public List<Reimbursements> getPending1(String username);
	public List<Reimbursements> getemployeePending();
	public List<Reimbursements> getemployeeResolved();
	public List<Reimbursements> getResolved(String username);
	public List<Reimbursements> getUsersByUsername(String username);
	public boolean submitReimbursement (Reimbursements reimbursement);
	public void approveReim(Reimbursements reimburse);
	public void denyReim(Reimbursements reimburse);
	
	public List<Reimbursements> selectAllReimbursements();
	
	

}
