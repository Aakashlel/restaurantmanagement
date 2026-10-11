package com.RestrauntManagement;

import java.sql.Connection;
import java.time.LocalTime;

import com.ResDB.ConnString;

public interface Admin {
	public int RESERVATION_GRACE_PERIOD = 3;
	public int DEFAULT_CASHIERS = 2;
	public int DEFAULT_CHEFS = 2;
	public int DEFAULT_RECEPTIONISTS = 2;
	public int DEFAULT_MANAGERS = 1;
	public int DEFAULT_WAITERS=5;
	public static final Connection con = ConnString.createConnection();
}

interface WaiterInterface extends Admin {
	abstract void viewOrder();

	abstract void makeOrder();

	abstract void modifyOrder();

	abstract void cancelOrder();

	abstract void viewMenu();
}

interface CashierInterface extends Admin {
	abstract void makePayment();
}

interface ChefInterface extends Admin {
	abstract void viewJobList();

	abstract void makeJobList(int ID);
}

interface ManagerInterface extends Admin {
	abstract void viewEmployee();

	abstract void addEmployee();

	abstract void removeEmployee();

	abstract void updateEmployee();

	abstract void viewMenu();

	abstract void updateMenu();

	abstract void removeMenu();
}

interface ReceptionistInterface extends Admin {
	abstract void checkAvailability();

	abstract void occupyTable(int resID, int numCust);

	abstract void freeTable(int resID);

	abstract void viewReservation(int resID);

	abstract void makeReservation(int resID, String custName, int count, LocalTime slot);

	abstract void cancelReservation(int resID);
}

interface NotificationSystem extends Admin {
	abstract void sendNotification();
}