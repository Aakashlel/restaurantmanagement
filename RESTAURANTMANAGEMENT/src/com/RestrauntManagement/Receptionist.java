package com.RestrauntManagement;

import java.sql.Connection;
import java.time.Duration;
import java.sql.Time;
import java.time.LocalTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ResExceptions.GracePeriodViolationException;
import com.ResExceptions.TooManyMembersException;

public class Receptionist extends Employee implements ReceptionistInterface {

	public Receptionist(String empName, String empDesignation, String empEmail, String empBranch, int empID, int empAge,
			int empSal, char empGender) {

		super(empName, empDesignation, empEmail, empBranch, empID, empAge, empSal, empGender);
	}

	Connection con = Admin.con;
	Scanner sc = new Scanner(System.in);

	@Override
	public void checkAvailability() {

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from seating where Branch=?");
			pstmt.setString(1, this.empBranch);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				String branch = this.empBranch;
				int seats3 = res.getInt(2);
				int seats5 = res.getInt(3);
				int seats10 = res.getInt(4);
				System.out.println(
						"Branch:" + branch + " 3 seater:" + seats3 + " 5 seater:" + seats5 + " 10 seater:" + seats10);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void occupyTable(int resID, int numCust) {
		try {
			PreparedStatement pstmt = con.prepareStatement("select*from reservation where ID=?");
			pstmt.setInt(1, resID);

			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				pstmt = con.prepareStatement("update reservation set Stat='o', TimeIn=? where ID=?");
				pstmt.setTime(1, Time.valueOf(LocalTime.now()));
				pstmt.setInt(2, resID);
				pstmt.executeUpdate();
			} else {
				ArrayList<Integer> arr = new ArrayList<>();
				while (numCust > 0) {
					int s = (numCust >= 10) ? 10 : (numCust >= 5) ? 5 : 3;
					arr.add(s);
					pstmt = con.prepareStatement("select ? from seating where Branch=?");
					if (s == 10) {
						pstmt.setString(1, "Seats10");
					} else if (s == 5) {
						pstmt.setString(1, "seats5");
					} else {
						pstmt.setString(1, "Seats3");
					}
					pstmt.setString(2, this.empBranch);
					ResultSet res2 = pstmt.executeQuery();
					if (res2.getInt(1) == 0) {
						throw new TooManyMembersException("Not enough space available please wait for some time");
					}
					pstmt = con.prepareStatement("update seating set ?=? where Branch=?");
					if (s == 10) {
						pstmt.setString(1, "Seats10");
					} else if (s == 5) {
						pstmt.setString(1, "seats5");
					} else {
						pstmt.setString(1, "Seats3");
					}
					pstmt.setInt(2, res2.getInt(1) - s);
					pstmt.setString(3, this.empBranch);
					pstmt = con.prepareStatement("insert into reservation values ?,?,?,?,?,?,?,?");
					pstmt.setInt(1, resID);
					System.out.println("Enter customer name");
					String custName = sc.next();
					pstmt.setString(2, custName);
					pstmt.setString(3, this.empBranch);
					pstmt.setInt(4, numCust);
					pstmt.setTime(5, Time.valueOf(LocalTime.now()));
					pstmt.setTime(6, Time.valueOf(LocalTime.now()));
					pstmt.setString(7, String.valueOf('o'));
					pstmt.setInt(8, s);
					pstmt.executeUpdate();
					numCust -= s;
				}

			}
			System.out.println("Table Occupied Successfully");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void freeTable(int resID) {

		try {
			PreparedStatement pstmt = con.prepareStatement("select tcat from reservation where ID=?");
			pstmt.setInt(1, resID);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int tableSize = res.getInt("tcat");
				String column;
				switch (tableSize) {
				case 10:
				column = "Seats10";
				break;
				case 5:
				column = "Seats5";
				break;
				default:
				column = "Seats3";
				}
				String sql =
				"update seating " +
				"set " + column + " = " + column + " + 1 " +
				"where Branch=?";
				PreparedStatement updateStmt =
				con.prepareStatement(sql);
				updateStmt.setString(1, this.empBranch);
				updateStmt.executeUpdate();
				}
			pstmt = con.prepareStatement("delete from reservation where ID=?");

			pstmt.setInt(1, resID);

			pstmt.executeUpdate();

			System.out.println("Table Freed Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewReservation(int resID) {

		try {

			PreparedStatement pstmt = con.prepareStatement("select * from reservation where ID=?");

			pstmt.setInt(1, resID);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				int id = res.getInt(1);
				String customer = res.getString(2);
				int tableNo = res.getInt(8);

				System.out.println("Reservation ID : " + id);
				System.out.println("Customer Name  : " + customer);
				System.out.println("Table Category   : " + tableNo);
			} else {
				System.out.println("Reservation Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void makeReservation(int resID, String custName, int count, LocalTime slot) {

		try {

			PreparedStatement pstmt = con.prepareStatement(
					"insert into reservation(ID,custName,count,Branch,TimeSlot,Stat,tcat) values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, resID);
			pstmt.setString(2, custName);
			pstmt.setInt(3, count);
			pstmt.setString(4, this.empBranch);
			pstmt.setTime(5, Time.valueOf(slot));
			pstmt.setString(6, String.valueOf('r'));
			while (count > 0) {
				int s = (count >= 10) ? 10 : (count >= 5) ? 5 : 3;
				pstmt.setInt(7, s);
				pstmt.executeUpdate();
				count -= s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelReservation(int resID) {

		try {

			PreparedStatement pstmt = con.prepareStatement("delete from reservation where ID=?");

			pstmt.setInt(1, resID);

			pstmt.executeUpdate();

			System.out.println("Reservation Cancelled Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ReceptionistMain(Receptionist r) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Receptionist with ID:" + r.empID);
		System.out.println(
				"Enter 1 to check availability\nEnter 2 to occupy table\nEnter 3 to free table\nEnter 4 to view reservation\nEnter 5 to make reservation\nEnter 6 to cancel reservation\nEnter -1 to exit");
		int ch = 0;
		while (ch != -1) {
			int resID, numCust, count, hrs, mins;
			String custName;
			System.out.println("Enter choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				r.checkAvailability();
				break;
			case 2:
				System.out.println("Enter reservation ID");
				resID = sc.nextInt();
				System.out.println("Enter number of customers:");
				numCust = sc.nextInt();
				r.occupyTable(resID, numCust);
				break;
			case 3:
				System.out.println("Enter reservation ID");
				resID = sc.nextInt();
				r.freeTable(resID);
				break;
			case 4:
				System.out.println("Enter reservation ID");
				resID = sc.nextInt();
				r.viewReservation(resID);
				break;
			case 5:
				System.out.println("Enter reservation ID");
				resID = sc.nextInt();
				System.out.println("Enter customer name");
				custName = sc.next();
				System.out.println("Enter number of customers");
				count = sc.nextInt();
				System.out.println("Enter Hour of the day");
				hrs = sc.nextInt();
				System.out.println("Enter Minute of the hour");
				mins = sc.nextInt();
				Duration d=Duration.between(LocalTime.now(), LocalTime.of(hrs, mins));
				if(d.toHours()<4) {
					throw new GracePeriodViolationException(d.toHours()+" does not meet the minimum requirement of 4 hours grace period");
				}
				r.makeReservation(resID, custName, count, LocalTime.of(hrs, mins));
				break;
			case 6:
				System.out.println("Enter reservation ID");
				resID = sc.nextInt();
				r.cancelReservation(resID);
				break;
			case -1:
				break;
			default:
				System.out.println("Enter valid choice");
			}
		}
	}
}