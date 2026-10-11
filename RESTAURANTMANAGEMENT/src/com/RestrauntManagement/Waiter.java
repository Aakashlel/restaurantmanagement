package com.RestrauntManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Waiter extends Employee implements WaiterInterface {

	public Waiter(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {
		super(empName, empDesignation, empEmail, empBranch, empID, empAge, empSal, empGender);
	}

	Connection con = Admin.con;
	Scanner sc = new Scanner(System.in);
	int ID;

	@Override
	public void viewOrder() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from orders");
			ResultSet res = pstmt.executeQuery();
				while (res.next()) {
					int id = res.getInt(1);
					String Item = res.getString(2);
					int Qty = res.getInt(3);
					String Stat=res.getString(4);
					System.out.println("ID:" + id + " " + "Item:" + Item + " " + "Quantity:" + Qty+" Status: "+Stat);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void makeOrder() {
		System.out.println("make called");
		System.out.println("Enter order details");
		int ID, Qty;
		String Item;
		System.out.println("Enter order ID:");
		ID = sc.nextInt();
		System.out.println("Enter Dish Name:");
		Item = sc.next();
		System.out.println("Enter quantity:");
		Qty = sc.nextInt();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into orders(ID,Item,Qty) values(?,?,?)");
			pstmt.setInt(1, ID);
			pstmt.setString(2, Item);
			pstmt.setInt(3, Qty);
			int res = pstmt.executeUpdate();
			System.out.println("Added " + res + " items to order");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifyOrder() {
		System.out.println("Enter order details");
		int ID, Qty;
		String Item;
		System.out.println("Enter order ID:");
		ID = sc.nextInt();
		System.out.println("Enter Dish Name:");
		Item = sc.next();
		System.out.println("Enter new quantity:");
		Qty = sc.nextInt();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update orders set Qty=? where ID=? and Item=?");
			pstmt.setInt(1, Qty);
			pstmt.setInt(2, ID);
			pstmt.setString(3, Item);
			pstmt.executeUpdate();
			System.out.println("Updated Order " + ID + " Dish " + Item + " Qty:" + Qty);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void cancelOrder() {
		int ch, ID;
		String Item;
		System.out.println("Enter 1 to delete Item from an order\nEnter 2 to delete complete order");
		System.out.println("Enter Choice:");
		ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter order ID:");
			ID = sc.nextInt();
			System.out.println("Enter Dish name:");
			Item = sc.next();
			try {
				PreparedStatement pstmt = con.prepareStatement("delete from orders where ID=? and Item=?");
				pstmt.setInt(1, ID);
				pstmt.setString(2, Item);
				pstmt.executeUpdate();
				System.out.println("Deleted from Order " + ID + " Dish " + Item);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter order ID:");
			ID = sc.nextInt();
			try {
				PreparedStatement pstmt = con.prepareStatement("delete from orders where ID=?");
				pstmt.setInt(1, ID);
				pstmt.executeUpdate();
				System.out.println("Deleted Order " + ID);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Enter a valid choice");
		}

	}

	@Override
	public void viewMenu() {
		String branch = this.empBranch;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from menu where Branch=?");
			pstmt.setString(1, branch);
			ResultSet res = pstmt.executeQuery();
			if (res.next())
				while (res.next()) {
					String Item = res.getString(1);
					int price = res.getInt(2);
					String FoodType = res.getString(3);
					System.out.println(
							"Item:" + Item + " Price:" + price + " Food Type:" + FoodType + " Branch:" + branch);
				}
			else
				System.out.println("Order Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void WaiterMain(Waiter w) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Waiter with Waiter ID " + w.empID);
		System.out.println(
				"Enter 1 to View Order\nEnter 2 to Make Order\nEnter 3 to Modify Order\nEnter 4 to Delete Order/Items\nEnter 5 to View menu\nEnter -1 to exit");
		int ch = 0;
		while (ch != -1) {
			System.out.println("Enter choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				w.viewOrder();
				break;
			case 2:
				w.makeOrder();
				break;
			case 3:
				w.modifyOrder();
				break;
			case 4:
				w.cancelOrder();
				break;
			case 5:
				w.viewMenu();
				break;
			case -1:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter valid choice");
			}
		}
	}

}