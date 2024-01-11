package com.fitness.fitness_freak.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "full_name") 
	private String fullName;
    @Column(name = "contact_details")
    private String contactDetails;
    @Column(name = "membership_type") 
    private String membershipType;
    @Column(name = "payment_history") 
    private String paymentHistory;
	
	public Member() {
		
	}
	
	

	public Member(String fullName, String contactDetails, String membershipType, String paymentHistory) {
		super();
		this.fullName = fullName;
		this.contactDetails = contactDetails;
		this.membershipType = membershipType;
		this.paymentHistory = paymentHistory;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(String paymentHistory) {
		this.paymentHistory = paymentHistory;
	}
	
	
}
