package com.Threads;

import java.sql.SQLException;
import java.util.ArrayList;
import com.RestrauntManagement.*;

public class Branches {

	public static Branch createHyderabadBranch() {

		Manager manager = new Manager("Kumar", "Manager", "kumar@restaurant.com", "Hyd", 1001, 45, 90000, 'M');

		ArrayList<Waiter> waiters = new ArrayList<>();
		ArrayList<Chef> chefs = new ArrayList<>();
		ArrayList<Cashier> cashiers = new ArrayList<>();
		ArrayList<Receptionist> receptionists = new ArrayList<>();

		receptionists
				.add(new Receptionist("Priya", "Receptionist", "priya@restaurant.com", "Hyd", 1002, 26, 30000, 'F'));

		receptionists
				.add(new Receptionist("Anjali", "Receptionist", "anjali@restaurant.com", "Hyd", 1003, 29, 32000, 'F'));

		cashiers.add(new Cashier("Rohit", "Cashier", "rohit@restaurant.com", "Hyd", 1004, 31, 28000, 'M'));

		cashiers.add(new Cashier("Sneha", "Cashier", "sneha@restaurant.com", "Hyd", 1005, 27, 29000, 'F'));

		chefs.add(new Chef("Vikram", "Chef", "vikram@restaurant.com", "Hyd", 1006, 38, 45000, 'M'));

		chefs.add(new Chef("Arun", "Chef", "arun@restaurant.com", "Hyd", 1007, 36, 42000, 'M'));

		chefs.add(new Chef("Suresh", "Chef", "suresh@restaurant.com", "Hyd", 1008, 34, 40000, 'M'));

		chefs.add(new Chef("Mohan", "Chef", "mohan@restaurant.com", "Hyd", 1009, 39, 43000, 'M'));

		chefs.add(new Chef("Kiran", "Chef", "kiran@restaurant.com", "Hyd", 1010, 35, 41000, 'M'));

		waiters.add(new Waiter("Rahul", "Waiter", "rahul@restaurant.com", "Hyd", 1011, 24, 22000, 'M'));

		waiters.add(new Waiter("Amit", "Waiter", "amit@restaurant.com", "Hyd", 1012, 25, 23000, 'M'));

		waiters.add(new Waiter("Deepak", "Waiter", "deepak@restaurant.com", "Hyd", 1013, 23, 21000, 'M'));

		waiters.add(new Waiter("Naveen", "Waiter", "naveen@restaurant.com", "Hyd", 1014, 26, 22500, 'M'));

		waiters.add(new Waiter("Ajay", "Waiter", "ajay@restaurant.com", "Hyd", 1015, 27, 24000, 'M'));

		new MenuItem("PaneerButter Masala", 180, "Veg", "Hyd", 1);
		new MenuItem("KajuPaneer", 200, "Veg", "Hyd", 2);
		new MenuItem("VegBiryani", 160, "Veg", "Hyd", 3);
		new MenuItem("MushroomBiryani", 180, "Veg", "Hyd", 4);
		new MenuItem("GobiManchurian", 140, "Veg", "Hyd", 5);
		new MenuItem("PaneerTikka", 180, "Veg", "Hyd", 6);
		new MenuItem("VegFriedRice", 150, "Veg", "Hyd", 7);
		new MenuItem("BabyCornManchurian", 150, "Veg", "Hyd", 8);
		new MenuItem("DalTadka", 130, "Veg", "Hyd", 9);
		new MenuItem("VegNoodles", 140, "Veg", "Hyd", 10);
		try {
			Admin.con.prepareStatement("insert into seating values ('Hyd',15,10,2)").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Branch("Hyderabad", manager, waiters, chefs, cashiers, receptionists);
	}

	public static Branch createBangaloreBranch() {

		Manager manager = new Manager("Arvind", "Manager", "arvind@restaurant.com", "Blr", 2001, 48, 92000, 'M');

		ArrayList<Waiter> waiters = new ArrayList<>();
		ArrayList<Chef> chefs = new ArrayList<>();
		ArrayList<Cashier> cashiers = new ArrayList<>();
		ArrayList<Receptionist> receptionists = new ArrayList<>();

		// Receptionists

		receptionists
				.add(new Receptionist("Pooja", "Receptionist", "pooja@restaurant.com", "Blr", 2002, 24, 31000, 'F'));

		receptionists.add(new Receptionist("Neha", "Receptionist", "neha@restaurant.com", "Blr", 2003, 31, 34000, 'F'));

		// Cashiers

		cashiers.add(new Cashier("Sanjay", "Cashier", "sanjay@restaurant.com", "Blr", 2004, 29, 29500, 'M'));

		cashiers.add(new Cashier("Meera", "Cashier", "meera@restaurant.com", "Blr", 2005, 33, 31500, 'F'));

		// Chefs

		chefs.add(new Chef("Rakesh", "Chef", "rakesh@restaurant.com", "Blr", 2006, 42, 48000, 'M'));

		chefs.add(new Chef("Manish", "Chef", "manish@restaurant.com", "Blr", 2007, 38, 45500, 'M'));

		chefs.add(new Chef("Nitin", "Chef", "nitin@restaurant.com", "Blr", 2008, 35, 43000, 'M'));

		chefs.add(new Chef("Harish", "Chef", "harish@restaurant.com", "Blr", 2009, 40, 46500, 'M'));

		chefs.add(new Chef("Vivek", "Chef", "vivek@restaurant.com", "Blr", 2010, 37, 44500, 'M'));

		// Waiters

		waiters.add(new Waiter("Sharma", "Waiter", "sharma@restaurant.com", "Blr", 2011, 23, 23000, 'M'));

		waiters.add(new Waiter("Tarun", "Waiter", "tarun@restaurant.com", "Blr", 2012, 25, 24000, 'M'));

		waiters.add(new Waiter("Karthik", "Waiter", "karthik@restaurant.com", "Blr", 2013, 22, 22000, 'M'));

		waiters.add(new Waiter("Sohel", "Waiter", "sohel@restaurant.com", "Blr", 2014, 27, 24500, 'M'));

		waiters.add(new Waiter("Yashwanth", "Waiter", "yashwanth@restaurant.com", "Blr", 2015, 26, 25000, 'M'));

		new MenuItem("ChickenBiryani", 250, "Non-Veg", "Blr", 1);
		new MenuItem("MuttonBiryani", 320, "Non-Veg", "Blr", 2);
		new MenuItem("Chicken65", 190, "Non-Veg", "Blr", 3);
		new MenuItem("ChickenTikka", 220, "Non-Veg", "Blr", 4);
		new MenuItem("ChickenFry", 200, "Non-Veg", "Blr", 5);
		new MenuItem("ChickenCurry", 220, "Non-Veg", "Blr", 6);
		new MenuItem("ButterChicken", 240, "Non-Veg", "Blr", 7);
		new MenuItem("ChickenLollipop", 230, "Non-Veg", "Blr", 8);
		new MenuItem("ChickenKebab", 220, "Non-Veg", "Blr", 9);
		new MenuItem("ChickenFried Rice", 200, "Non-Veg", "Blr", 10);
		
		try {
			Admin.con.prepareStatement("insert into seating values ('Blr',12,8,2)").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Branch("Bangalore", manager, waiters, chefs, cashiers, receptionists);
	}

	public static Branch createChennaiBranch() {

		Manager manager = new Manager("Ashok", "Manager", "ashok@restaurant.com", "Chn", 3001, 46, 95000, 'M');

		ArrayList<Waiter> waiters = new ArrayList<>();
		ArrayList<Chef> chefs = new ArrayList<>();
		ArrayList<Cashier> cashiers = new ArrayList<>();
		ArrayList<Receptionist> receptionists = new ArrayList<>();

		// Receptionists

		receptionists
				.add(new Receptionist("Divya", "Receptionist", "divya@restaurant.com", "Chn", 3002, 27, 31000, 'F'));

		receptionists
				.add(new Receptionist("Anusha", "Receptionist", "anusha@restaurant.com", "Chn", 3003, 29, 33000, 'F'));

		// Cashiers

		cashiers.add(new Cashier("Vamsi Krishna", "Cashier", "vamsi@restaurant.com", "Chn", 3004, 30, 29500, 'M'));

		cashiers.add(new Cashier("Nandini", "Cashier", "nandini@restaurant.com", "Chn", 3005, 28, 30500, 'F'));

		// Chefs

		chefs.add(new Chef("Abhi", "Chef", "abhi@restaurant.com", "Chn", 3006, 39, 47000, 'M'));

		chefs.add(new Chef("Lokesh", "Chef", "lokesh@restaurant.com", "Chn", 3007, 37, 44000, 'M'));

		chefs.add(new Chef("Praveen", "Chef", "praveen@restaurant.com", "Chn", 3008, 35, 42500, 'M'));

		chefs.add(new Chef("Ganesh", "Chef", "ganesh@restaurant.com", "Chn", 3009, 40, 46000, 'M'));

		chefs.add(new Chef("Suraj", "Chef", "suraj@restaurant.com", "Chn", 3010, 36, 43500, 'M'));

		// Waiters

		waiters.add(new Waiter("Rushikesh", "Waiter", "rushikesh@restaurant.com", "Chn", 3011, 25, 23500, 'M'));

		waiters.add(new Waiter("Tejas", "Waiter", "tejas@restaurant.com", "Chn", 3012, 26, 24500, 'M'));

		waiters.add(new Waiter("Varun", "Waiter", "varun@restaurant.com", "Chn", 3013, 24, 22500, 'M'));

		waiters.add(new Waiter("Aditya", "Waiter", "aditya@restaurant.com", "Chn", 3014, 27, 24000, 'M'));

		waiters.add(new Waiter("Keshav", "Waiter", "keshav@restaurant.com", "Chn", 3015, 28, 25000, 'M'));

		new MenuItem("FishFry", 220, "Seafood", "Chn", 1);
		new MenuItem("FishBiryani", 260, "Seafood", "Chn", 2);
		new MenuItem("FishCurry", 240, "Seafood", "Chn", 3);
		new MenuItem("PrawnsFry", 280, "Seafood", "Chn", 4);
		new MenuItem("PrawnsBiryani", 300, "Seafood", "Chn", 5);
		new MenuItem("PrawnsCurry", 290, "Seafood", "Chn", 6);
		new MenuItem("ChilliPrawns", 300, "Seafood", "Chn", 7);
		new MenuItem("ApolloFish", 280, "Seafood", "Chn", 8);
		new MenuItem("FishTikka", 250, "Seafood", "Chn", 9);
		new MenuItem("CrabMasala", 320, "Seafood", "Chn", 10);
		
		try {
			Admin.con.prepareStatement("insert into seating values ('Chn',10,6,2)").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Branch("Chennai", manager, waiters, chefs, cashiers, receptionists);
	}
}