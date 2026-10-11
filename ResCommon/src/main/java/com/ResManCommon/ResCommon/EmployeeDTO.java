package com.ResManCommon.ResCommon;

public class EmployeeDTO {

	private String empName;
	private int empID;
	private int empAge;
	private Roles empDesignation;
	private char empGender;
	private int empSal;
	private String empEmail;
	private String empBranch;
	public EmployeeDTO() {
		super();
	}
	public EmployeeDTO(String empName, int empID, int empAge, Roles empDesignation, char empGender, int empSal,
			String empEmail, String empBranch) {
		super();
		this.empName = empName;
		this.empID = empID;
		this.empAge = empAge;
		this.empDesignation = empDesignation;
		this.empGender = empGender;
		this.empSal = empSal;
		this.empEmail = empEmail;
		this.empBranch = empBranch;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public Roles getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(Roles empDesignation) {
		this.empDesignation = empDesignation;
	}
	public char getEmpGender() {
		return empGender;
	}
	public void setEmpGender(char empGender) {
		this.empGender = empGender;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpBranch() {
		return empBranch;
	}
	public void setEmpBranch(String empBranch) {
		this.empBranch = empBranch;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empName=" + empName + ", empID=" + empID + ", empAge=" + empAge + ", empDesignation="
				+ empDesignation + ", empGender=" + empGender + ", empSal=" + empSal + ", empEmail=" + empEmail
				+ ", empBranch=" + empBranch + "]";
	}
}
