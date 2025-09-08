package com.insurance;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Policy {
	private String policyId;
	private String policyType;
	private String fullName;
	private int age;
	private double coverage;
	private double premium;
	private String status;
	private String description;
	private int duration;
	@JsonFormat(pattern = "yyyy-MM-dd")   
	private LocalDate startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	public Policy(String policyId, String policyType, String fullName, int age, double coverage, double premium) {
		this.policyId = policyId;
		this.policyType = policyType;
		this.fullName = fullName;
		this.age = age;
		this.coverage = coverage;
		this.premium = premium;
		this.status = "Active";
		this.description =description;
		this.startDate = LocalDate.now();       
		this.expiryDate = startDate.plusYears(duration);
	}

	public String getPolicyId() {
		return policyId; 
	}
	public String getPolicyType() {
		return policyType;
	}
	public String getFullName() {
		return fullName;
	}
	public int getAge() {
		return age; 
	}
	public double getCoverage() {
		return coverage;
	}
	public double getPremium() { 
		return premium; 
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status; 
	}
	public int getDuration() {
		return duration; 
	}
	public void setDuration(int duration) { 
		this.duration = duration;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate; 
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setDescription(String description) {
		this.description = description; 
	}
	public String getDescription() { 
		return description; 
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Policy)) return false;
		Policy policy = (Policy) o;
		return Objects.equals(policyId, policy.policyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(policyId);
	}

	@Override
	public String toString() {
		return "Policy{" +
				"policyId='" + policyId + '\'' +
				", policyType='" + policyType + '\'' +
				", fullName='" + fullName + '\'' +
				", age=" + age +
				", coverageAmount=" + coverage +
				", premium=₹" + premium +
				", duration=" + duration + " years" +
				", status='" + status + '\'' +
				", startDate=" + startDate +
				", expiryDate=" + expiryDate +
				", description='" + description + '\'' +
				'}';
	}
}