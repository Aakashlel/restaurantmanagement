package com.Threads;

import com.RestrauntManagement.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch implements Runnable {

	private String branchName;

	private Manager manager;

	private ArrayList<Waiter> waiters = new ArrayList<>();
	private ArrayList<Chef> chefs = new ArrayList<>();
	private ArrayList<Cashier> cashiers = new ArrayList<>();
	private ArrayList<Receptionist> receptionists = new ArrayList<>();

	public Branch(String branchName, Manager manager, ArrayList<Waiter> waiters, ArrayList<Chef> chefs,
			ArrayList<Cashier> cashiers, ArrayList<Receptionist> receptionists) {

		this.branchName = branchName;
		this.manager = manager;

		this.waiters = waiters;
		this.chefs = chefs;
		this.cashiers = cashiers;
		this.receptionists = receptionists;
	}

	@Override
	public void run() {

		Scanner sc = new Scanner(System.in);

		int choice = 0;

		while (choice != -1) {

			System.out.println("\n==========");
			System.out.println(branchName + " Branch");
			System.out.println("==========");

			System.out.println(
					"1. Manager\n" + "2. Waiter\n" + "3. Chef\n" + "4. Cashier\n" + "5. Receptionist\n" + "-1. Exit");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				Manager.ManagerMain(manager);
				break;

			case 2:
				selectWaiter(sc);
				break;

			case 3:
				selectChef(sc);
				break;

			case 4:
				selectCashier(sc);
				break;

			case 5:
				selectReceptionist(sc);
				break;

			case -1:
				System.out.println("Exiting Branch");
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	private void selectWaiter(Scanner sc) {

		System.out.println("Select Waiter:");

		for (int i = 0; i < waiters.size(); i++) {

			System.out.println((i + 1) + ". " + waiters.get(i).empName + " (" + waiters.get(i).empID + ")");
		}

		int choice = sc.nextInt();

		if (choice > 0 && choice <= waiters.size()) {

			Waiter.WaiterMain(waiters.get(choice - 1));
		}
	}

	private void selectChef(Scanner sc) {

		System.out.println("Select Chef:");

		for (int i = 0; i < chefs.size(); i++) {

			System.out.println((i + 1) + ". " + chefs.get(i).empName + " (" + chefs.get(i).empID + ")");
		}

		int choice = sc.nextInt();

		if (choice > 0 && choice <= chefs.size()) {

			Chef.ChefMain(chefs.get(choice - 1));
		}
	}

	private void selectCashier(Scanner sc) {

		System.out.println("Select Cashier:");

		for (int i = 0; i < cashiers.size(); i++) {

			System.out.println((i + 1) + ". " + cashiers.get(i).empName + " (" + cashiers.get(i).empID + ")");
		}

		int choice = sc.nextInt();

		if (choice > 0 && choice <= cashiers.size()) {

			Cashier.CashierMain(cashiers.get(choice - 1));
		}
	}

	private void selectReceptionist(Scanner sc) {

		System.out.println("Select Receptionist:");

		for (int i = 0; i < receptionists.size(); i++) {

			System.out.println((i + 1) + ". " + receptionists.get(i).empName + " (" + receptionists.get(i).empID + ")");
		}

		int choice = sc.nextInt();

		if (choice > 0 && choice <= receptionists.size()) {

			Receptionist.ReceptionistMain(receptionists.get(choice - 1));
		}
	}
}