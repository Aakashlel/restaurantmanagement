package com.RestrauntManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Employee implements Admin {
	public String empName;
	String empDesignation;
	String empEmail;
	String empBranch;
	public int empID;
	int empAge;
	int empSal;
	char empGender;
	public Employee(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empEmail = empEmail;
		this.empBranch = empBranch;
		this.empID = empID;
		this.empAge = empAge;
		this.empSal = empSal;
		this.empGender = empGender;
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into employee(empID,empName,empDesignation,empGender,empSal,empEmail,empBranch,empAge) values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, this.empID);
			pstmt.setString(2, this.empName);
			pstmt.setString(3, this.empDesignation);
			pstmt.setString(4, String.valueOf(this.empGender));
			pstmt.setInt(5, this.empSal);
			pstmt.setString(6, this.empEmail);
			pstmt.setString(7, this.empBranch);
			pstmt.setInt(8, this.empAge);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
