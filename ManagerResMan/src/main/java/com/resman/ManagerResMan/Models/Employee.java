package com.resman.ManagerResMan.Models;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Column(name="empID")
	@Id
	int empID;
	@Column(name="empName")
	String empName;
	@Column(name="empAge")
	int empAge;
	@Enumerated(EnumType.STRING)
	@Column(name="empDesignation")
	Roles empDesignation;
	@Column(name="empGender")
	char empGender;
	@Column(name="empSal")
	int empSal;
	@Column(name="empEmail")
	String empEmail;
	@Enumerated(EnumType.STRING)
	@Column(name="empBranch")
	Branches empBranch;
	public Employee() {
		super();
	}
	public Employee(int empID, String empName, int empAge, Roles empDesignation, char empGender, int empSal,
			String empEmail, Branches empBranch) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empAge = empAge;
		this.empDesignation = empDesignation;
		this.empGender = empGender;
		this.empSal = empSal;
		this.empEmail = empEmail;
		this.empBranch = empBranch;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empAge=" + empAge + ", empDesignation="
				+ empDesignation + ", empGender=" + empGender + ", empSal=" + empSal + ", empEmail=" + empEmail
				+ ", empBranch=" + empBranch + "]";
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public Branches getEmpBranch() {
		return empBranch;
	}
	public void setEmpBranch(Branches empBranch) {
		this.empBranch = empBranch;
	}
	
	
}
