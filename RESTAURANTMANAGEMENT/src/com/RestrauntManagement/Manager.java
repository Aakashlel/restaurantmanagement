package com.RestrauntManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Manager extends Employee implements ManagerInterface {

	Connection con = Admin.con;
	Scanner sc = new Scanner(System.in);

	public Manager(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {
		super(empName, empDesignation, empEmail, empBranch, empID, empAge, empSal, empGender);
	}

	@Override
	public synchronized void updateMenu() {
		try {
			System.out.println("Enter Item Name:");
			String item = sc.next();

			System.out.println("Enter New Price:");
			int price = sc.nextInt();

			PreparedStatement pstmt = con.prepareStatement("update menu set Price=? where DishName=?");

			pstmt.setInt(1, price);
			pstmt.setString(2, item);

			int res = pstmt.executeUpdate();
			System.out.println(res + " Menu Item Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void removeMenu() {
		try {
			System.out.println("Enter Item Name:");
			String item = sc.next();

			PreparedStatement pstmt = con.prepareStatement("delete from menu where DishName=?");

			pstmt.setString(1, item);

			int res = pstmt.executeUpdate();
			System.out.println(res + " Menu Item Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewEmployee() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from employee");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(
						rs.getInt("empID") + " " + rs.getString("empName") + " " + rs.getString("empDesignation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void addEmployee() {
		try {
			System.out.println("Enter Employee ID:");
			int id = sc.nextInt();

			System.out.println("Enter Employee Name:");
			String name = sc.next();

			System.out.println("Enter Age:");
			int age = sc.nextInt();

			System.out.println("Enter Designation:");
			String desig = sc.next();

			System.out.println("Enter Gender:");
			char gender = sc.next().charAt(0);

			System.out.println("Enter salary:");
			int sal = sc.nextInt();

			System.out.println("Enter email:");
			String email = sc.next();

			System.out.println("Enter branch:");
			String branch = sc.next();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into employee(empID,empName,empDesignation,empGender,empSal,empEmail,empBranch,empAge) values(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, desig);
			pstmt.setString(4, String.valueOf(gender));
			pstmt.setInt(5, sal);
			pstmt.setString(6, email);
			pstmt.setString(7, branch);
			pstmt.setInt(8, age);

			int res = pstmt.executeUpdate();
			System.out.println(res + " Employee Added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void removeEmployee() {
		try {
			System.out.println("Enter Employee ID:");
			int id = sc.nextInt();

			PreparedStatement pstmt = con.prepareStatement("delete from employee where empID=?");

			pstmt.setInt(1, id);

			int res = pstmt.executeUpdate();
			System.out.println(res + " Employee Removed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void updateEmployee() {
		try {
			System.out.println("Enter Employee ID:");
			int id = sc.nextInt();

			System.out.println("Enter New Employee Name:");
			String name = sc.next();

			System.out.println("Enter new age:");
			int age = sc.nextInt();

			System.out.println("Enter new Designation:");
			String desig = sc.next();

			System.out.println("Enter Gender:");
			char gender = sc.next().charAt(0);

			System.out.println("Enter new salary:");
			int sal = sc.nextInt();

			System.out.println("Enter new email:");
			String email = sc.next();

			System.out.println("Enter new branch:");
			String branch = sc.next();

			PreparedStatement pstmt = con.prepareStatement(
					"update employee set empName=?,empAge=?,empDesignation=?,empGender=?,empSal=?,empEmail=?,empBranch=? where empID=?");

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, desig);
			pstmt.setString(4, String.valueOf(gender));
			pstmt.setInt(5, sal);
			pstmt.setString(6, email);
			pstmt.setString(7, branch);
			pstmt.setInt(8, id);

			int res = pstmt.executeUpdate();
			System.out.println(res + " Employee Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewMenu() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from menu where Branch=?");
			pstmt.setString(1, this.empBranch);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Item: " + rs.getString("DishName") + " Price: " + rs.getInt("Price") + " Type: "
						+ rs.getString("FoodType") + " Branch: " + rs.getString("Branch"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ManagerMain(Manager m) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Manager with Employee ID " + m.empID);
		System.out.println("Enter 1 to View Employee\n" + "Enter 2 to Add Employee\n" + "Enter 3 to Remove Employee\n"
				+ "Enter 4 to Update Employee\n" + "Enter 5 to View Menu\n" + "Enter 6 to Update Menu\n"
				+ "Enter 7 to Remove Menu Item\n" + "Enter -1 to Exit");
		int ch = 0;
		while (ch != -1) {
			System.out.println("Enter Choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				m.viewEmployee();
				break;
			case 2:
				m.addEmployee();
				break;
			case 3:
				m.removeEmployee();
				break;
			case 4:
				m.updateEmployee();
				break;
			case 5:
				m.viewMenu();
				break;
			case 6:
				m.updateMenu();
				break;
			case 7:
				m.removeMenu();
				break;
			case -1:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter Valid Choice");
			}
		}
	}
}