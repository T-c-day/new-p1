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

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	Connection connection = DBConnection.getConnection();

	@Override
	public List<Reimbursements> getPending1(String username) {
		System.out.println("Printing all pending reimbursements: ");
		List<Reimbursements> reimbursements = new ArrayList<Reimbursements>();

		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from reimbursements where fk_username=? and status='P'");
			stat.setString(1, username);

			ResultSet res = stat.executeQuery();
			System.out.println(res);
			while (res.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setThatday(res.getString(1));
				reimbursement.setFk_username(res.getString(2));
				reimbursement.setAmount(res.getFloat(3));
				reimbursement.setDescription(res.getString(4));
				reimbursement.setStatus(res.getString(5));
				reimbursement.setReimId(res.getInt(6));
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursements> getResolved(String username) {
		System.out.println("Printing all resolved reimbursements");
		List<Reimbursements> reimbursements = new ArrayList<Reimbursements>();
		
		PreparedStatement stat;
		try {
			Employee temp= Employee.getEmplog();
			stat = connection.prepareStatement("select * from reimbursements where fk_username=? and status='D' or status='A'");
			stat.setString(1, temp.getUsername());

			ResultSet res = stat.executeQuery();
			System.out.println(res);
			
			while (res.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setThatday(res.getString(1));
				reimbursement.setFk_username(res.getString(2));
				reimbursement.setAmount(res.getFloat(3));
				reimbursement.setDescription(res.getString(4));
				reimbursement.setStatus(res.getString(5));
				reimbursement.setReimId(res.getInt(6));
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursements> getUsersByUsername(String username) {
		System.out.println("Printing all pending reimbursements: ");
		List<Reimbursements> reimbursements = new ArrayList<Reimbursements>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursements where fk_username= '" + username + "'");
			while (res.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setFk_username(res.getString(1));
				reimbursement.setAmount(res.getDouble(2));
				reimbursement.setDescription(res.getString(3));
				reimbursement.setStatus(res.getString(4));
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public boolean submitReimbursement(Reimbursements reimbursement) {
		System.out.println("Creating new Reimbursement: ");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			System.out.println(reimbursement.getFk_username());
			System.out.println(reimbursement.getAmount());
			System.out.println(reimbursement.getDescription());
			System.out.println(reimbursement.getThatday());
			System.out.println(reimbursement.getStatus());

			statement = connection.prepareStatement("INSERT INTO reimbursements VALUES(?, ?, ?, ?, default)");
			statement.setString(2, reimbursement.getFk_username());
			statement.setDouble(3, reimbursement.getAmount());
			statement.setString(4, reimbursement.getDescription());
			statement.setString(1, reimbursement.getThatday());
			// statement.setString(4, reimbursement.getStatus());

			rows = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public List<Reimbursements> selectAllReimbursements() {
		List<Reimbursements> exps = new ArrayList<Reimbursements>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM reimbursements");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				exps.add(new Reimbursements(rs.getString(1), rs.getDouble(3), rs.getString(2), rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exps;
	}

	@Override
	public List<Reimbursements> getemployeePending() {
		System.out.println("Printing all pending reimbursements: ");
		List<Reimbursements> reimbursements = new ArrayList<Reimbursements>();

		try {
			PreparedStatement ps = connection.prepareStatement("select * from reimbursements where status = 'P'");
			ResultSet rs = ps.executeQuery();
			/*
			 * stat = connection.createStatement(); ResultSet res =
			 * stat.executeQuery("select * from reimbursements where status = 'P'");
			 */
			System.out.println(rs);

			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setFk_username(rs.getString(2));
				reimbursement.setAmount(rs.getFloat(3));
				reimbursement.setDescription(rs.getString(4));
				reimbursement.setStatus(rs.getString(5));
				reimbursement.setReimId(rs.getInt(6));
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursements> getemployeeResolved() {
		System.out.println("Printing all resolved reimbursements");
		List<Reimbursements> rb = new ArrayList<Reimbursements>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursements where status = 'D' or status= 'A'");
			while (res.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setFk_username(res.getString(2));
				reimbursement.setAmount(res.getFloat(3));
				reimbursement.setDescription(res.getString(4));
				reimbursement.setStatus(res.getString(5));
				reimbursement.setReimId(res.getInt(6));
				rb.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rb;
	}

	@Override
	public void approveReim(Reimbursements reimburse) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("update reimbursements set status='A' where reimid= ?");
			ps.setInt(1, reimburse.getReimId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void denyReim(Reimbursements reimburse) {
		Statement stat;
		try {
			PreparedStatement ps = connection.prepareStatement("update reimbursements set status='D' where reimid= ?");
			ps.setInt(1, reimburse.getReimId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
