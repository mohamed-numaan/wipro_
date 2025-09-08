package com.insurance;

import java.time.LocalDate;
import java.util.UUID;

public class Claim {
	private String claimId;
	private String policyId;
	private String description;
	private String status;   
	private LocalDate dateSubmitted;

	public Claim(String policyId, String description) {
		this.claimId = UUID.randomUUID().toString();
		this.policyId = policyId;
		this.description = description;
		this.status = "Pending";
		this.dateSubmitted = LocalDate.now();
	}

	// Getters & Setters
	public String getClaimId() {
		return claimId;
	}
	public String getPolicyId() {
		return policyId; 
	}
	public String getDescription() {
		return description; 
	}
	public String getStatus() { 
		return status; 
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDateSubmitted() { 
		return dateSubmitted;
	}
}
