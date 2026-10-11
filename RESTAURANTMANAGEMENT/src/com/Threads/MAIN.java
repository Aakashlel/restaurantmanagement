package com.Threads;

import java.sql.SQLException;
import java.util.Scanner;

import com.RestrauntManagement.Admin;

public class MAIN {

	public static void main(String[] args) {
		Branch hyderabad = Branches.createHyderabadBranch();
		Branch bangalore = Branches.createBangaloreBranch();
		Branch chennai = Branches.createChennaiBranch();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != -1) {
			System.out.println("\n========== BRANCH SELECTION ==========");
			System.out.println("1. Hyderabad");
			System.out.println("2. Bangalore");
			System.out.println("3. Chennai");
			System.out.println("-1. Exit");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				hyderabad.run();
				break;
			case 2:
				bangalore.run();
				break;
			case 3:
				chennai.run();
				break;
			case -1:
				System.out.println("Exiting Application...");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		
		sc.close();
		try {
			Admin.con.prepareStatement("truncate employee").execute();
			Admin.con.prepareStatement("truncate menu").execute();
			Admin.con.prepareStatement("truncate seating").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
