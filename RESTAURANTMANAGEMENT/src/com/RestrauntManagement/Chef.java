package com.RestrauntManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Chef extends Employee implements ChefInterface {

	Connection con = Admin.con;
	Scanner sc = new Scanner(System.in);

	public Chef(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {

		super(empName, empDesignation, empEmail, empBranch, empID, empAge, empSal, empGender);
	}

	@Override
	public void viewJobList() {

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from orders");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				String stat = rs.getString(4);

				System.out.println("ID : " + id);
				System.out.println("Item : " + item);
				System.out.println("Quantity : " + qty);
				System.out.println("Status :" + stat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeJobList(int ID) {

		try {
			PreparedStatement pstmt = con.prepareStatement("update orders set Stat='d' where ID=?");

			pstmt.setInt(1, ID);
			int res = pstmt.executeUpdate();

			System.out.println(res + " Job completed");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ChefMain(Chef ch) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Chef with ID:" + ch.empID);
		System.out.println("Enter 1 to view job list\nEnter 2 to mark job complete\nEnter -1 to logout");
		int c = 0;
		while (c != -1) {
			System.out.println("Enter choice:");
			c = sc.nextInt();
			switch (c) {
			case 1:
				ch.viewJobList();
				break;
			case 2:
				int ID;
				System.out.println("Enter order id:");
				ID = sc.nextInt();
				ch.makeJobList(ID);
				break;
			case -1:
				System.out.println("Logout");
				break;
			default:
				System.out.println("Enter a valid choice");
			}
		}
	}
}