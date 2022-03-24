package com.training.model;

import java.sql.Date;
import java.util.Objects;

public class Reimbursements {

	private String fk_username;
	private double amount;
	private String description;
	private String status;
	private String thatday;
	private int reimId;

	
	public Reimbursements(String fk_username, double amount, String description, String status, String thatday,
			int reimId) {
		this.fk_username = fk_username;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.thatday = thatday;
		this.reimId = reimId;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFk_username() {
		return fk_username;
	}

	public void setFk_username(String fk_username) {
		this.fk_username = fk_username;
	}

	public String getThatday() {
		return thatday;
	}

	public void setThatday(String thatday) {
		this.thatday = thatday;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, fk_username, reimId, status, thatday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(description, other.description) && Objects.equals(fk_username, other.fk_username)
				&& reimId == other.reimId && Objects.equals(status, other.status)
				&& Objects.equals(thatday, other.thatday);
	}

	@Override
	public String toString() {
		return "Reimbursements [fk_username=" + fk_username + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", thatday=" + thatday + ", reimId=" + reimId + "]";
	}

	
	
	
}
