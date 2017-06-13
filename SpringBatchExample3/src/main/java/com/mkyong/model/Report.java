package com.mkyong.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Report {

	private int refId;
	private String name;
	private int age;
	private Date dob;
	private BigDecimal income;


	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	// for csv demo only
	public String getCsvDob() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(getDob());

	}

}