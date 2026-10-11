package com.RestrauntManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ResExceptions.PaymentFailedException;

public class Cashier extends Employee implements CashierInterface {

	public Cashier(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {
		super(empName, empDesignation, empEmail, empBranch, empID, empAge, empSal, empGender);
	}

	@Override
	public void makePayment() {

		Connection con = Admin.con;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Order ID:");
		int ID = sc.nextInt();

		int totalAmount = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(
					"select distinct o.Item,o.Qty,m.Price from orders o join menu m on o.Item=m.DishName where o.ID=?");

			pstmt.setInt(1, ID);

			ResultSet res = pstmt.executeQuery();

			System.out.println("------ BILL ------");

			while (res.next()) {

				String item = res.getString("Item");
				int qty = res.getInt("Qty");
				int price = res.getInt("Price");

				int amount = qty * price;
				totalAmount += amount;

				System.out.println("Item : " + item + " Qty : " + qty + " Price : " + price + " Amount : " + amount);
			}

			System.out.println("------------------");
			System.out.println("Total Amount : " + totalAmount);

			System.out.println("Enter Amount Paid:");
			int paid = sc.nextInt();

			if (paid < totalAmount) {
				throw new PaymentFailedException("Insufficient Amount");
			} else {
				int balance = paid - totalAmount;

				System.out.println("Payment Successful");
				System.out.println("Balance Amount : " + balance);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(PaymentFailedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void CashierMain(Cashier ca) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cashier with ID" + ca.empID);
		System.out.println("Enter 1 to initiate payment\nEnter -1 to exit");
		int ch = 0;
		while (ch != -1) {
			System.out.println("Enter Choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				ca.makePayment();
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