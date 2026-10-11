package com.resman.ManagerResMan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.Roles;
import com.resman.ManagerResMan.Models.Employee;
import com.resman.ManagerResMan.Models.Menu;
import com.resman.ManagerResMan.Models.Seating;
import com.resman.ManagerResMan.Repository.BillsRepository;
import com.resman.ManagerResMan.Repository.EmployeeRepository;
import com.resman.ManagerResMan.Repository.MenuRepository;
import com.resman.ManagerResMan.Repository.OrdersRepository;
import com.resman.ManagerResMan.Repository.ReservationRepository;
import com.resman.ManagerResMan.Repository.SeatingRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ManagerService {

	@Autowired
	BillsRepository br;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	MenuRepository menuRepo;

	@Autowired
	OrdersRepository or;

	@Autowired
	ReservationRepository rr;

	@Autowired
	SeatingRepository seatingRepo;

	public String initializeBranch(Branches branch) {
		employeeRepo
				.save(new Employee(1001, "Kumar", 45, Roles.MANAGER, 'M', 90000, "kumar@restaurant.com", Branches.HYD));

		employeeRepo.save(
				new Employee(2001, "Arvind", 48, Roles.MANAGER, 'M', 92000, "arvind@restaurant.com", Branches.BLR));

		employeeRepo
				.save(new Employee(3001, "Ashok", 46, Roles.MANAGER, 'M', 95000, "ashok@restaurant.com", Branches.CHN));
		if (branch == Branches.HYD) {
			
			employeeRepo.save(new Employee(1002, "Priya", 26, Roles.RECEPTIONIST, 'F', 30000, "priya@restaurant.com",
					Branches.HYD));

			employeeRepo.save(new Employee(1003, "Anjali", 29, Roles.RECEPTIONIST, 'F', 32000, "anjali@restaurant.com",
					Branches.HYD));

			employeeRepo.save(
					new Employee(1004, "Rohit", 31, Roles.CASHIER, 'M', 28000, "rohit@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1005, "Sneha", 27, Roles.CASHIER, 'F', 29000, "sneha@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1006, "Vikram", 38, Roles.CHEF, 'M', 45000, "vikram@restaurant.com", Branches.HYD));

			employeeRepo
					.save(new Employee(1007, "Arun", 36, Roles.CHEF, 'M', 42000, "arun@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1008, "Suresh", 34, Roles.CHEF, 'M', 40000, "suresh@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1009, "Mohan", 39, Roles.CHEF, 'M', 43000, "mohan@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1010, "Kiran", 35, Roles.CHEF, 'M', 41000, "kiran@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1011, "Rahul", 24, Roles.WAITER, 'M', 22000, "rahul@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1012, "Amit", 25, Roles.WAITER, 'M', 23000, "amit@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1013, "Deepak", 23, Roles.WAITER, 'M', 21000, "deepak@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1014, "Naveen", 26, Roles.WAITER, 'M', 22500, "naveen@restaurant.com", Branches.HYD));

			employeeRepo.save(
					new Employee(1015, "Ajay", 27, Roles.WAITER, 'M', 24000, "ajay@restaurant.com", Branches.HYD));
			menuRepo.save(new Menu(1, "PaneerButter Masala", 180, "Veg", Branches.HYD));

			menuRepo.save(new Menu(2, "KajuPaneer", 200, "Veg", Branches.HYD));

			menuRepo.save(new Menu(3, "VegBiryani", 160, "Veg", Branches.HYD));

			menuRepo.save(new Menu(4, "MushroomBiryani", 180, "Veg", Branches.HYD));

			menuRepo.save(new Menu(5, "GobiManchurian", 140, "Veg", Branches.HYD));

			menuRepo.save(new Menu(6, "PaneerTikka", 180, "Veg", Branches.HYD));

			menuRepo.save(new Menu(7, "VegFriedRice", 150, "Veg", Branches.HYD));

			menuRepo.save(new Menu(8, "BabyCornManchurian", 150, "Veg", Branches.HYD));

			menuRepo.save(new Menu(9, "DalTadka", 130, "Veg", Branches.HYD));

			menuRepo.save(new Menu(10, "VegNoodles", 140, "Veg", Branches.HYD));
			seatingRepo.save(new Seating(Branches.HYD, 15, 10, 2));
		} else if (branch == Branches.BLR) {
			employeeRepo.save(new Employee(2002, "Pooja", 24, Roles.RECEPTIONIST, 'F', 31000, "pooja@restaurant.com",
					Branches.BLR));

			employeeRepo.save(new Employee(2003, "Neha", 31, Roles.RECEPTIONIST, 'F', 34000, "neha@restaurant.com",
					Branches.BLR));

			employeeRepo.save(
					new Employee(2004, "Sanjay", 29, Roles.CASHIER, 'M', 29500, "sanjay@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2005, "Meera", 33, Roles.CASHIER, 'F', 31500, "meera@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2006, "Rakesh", 42, Roles.CHEF, 'M', 48000, "rakesh@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2007, "Manish", 38, Roles.CHEF, 'M', 45500, "manish@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2008, "Nitin", 35, Roles.CHEF, 'M', 43000, "nitin@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2009, "Harish", 40, Roles.CHEF, 'M', 46500, "harish@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2010, "Vivek", 37, Roles.CHEF, 'M', 44500, "vivek@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2011, "Sharma", 23, Roles.WAITER, 'M', 23000, "sharma@restaurant.com", Branches.BLR));

			employeeRepo.save(
					new Employee(2012, "Tarun", 25, Roles.WAITER, 'M', 24000, "tarun@restaurant.com", Branches.BLR));

			employeeRepo.save(new Employee(2013, "Karthik", 22, Roles.WAITER, 'M', 22000, "karthik@restaurant.com",
					Branches.BLR));

			employeeRepo.save(
					new Employee(2014, "Sohel", 27, Roles.WAITER, 'M', 24500, "sohel@restaurant.com", Branches.BLR));

			employeeRepo.save(new Employee(2015, "Yashwanth", 26, Roles.WAITER, 'M', 25000, "yashwanth@restaurant.com",
					Branches.BLR));
			menuRepo.save(new Menu(1, "ChickenBiryani", 250, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(2, "MuttonBiryani", 320, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(3, "Chicken65", 190, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(4, "ChickenTikka", 220, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(5, "ChickenFry", 200, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(6, "ChickenCurry", 220, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(7, "ButterChicken", 240, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(8, "ChickenLollipop", 230, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(9, "ChickenKebab", 220, "Non-Veg", Branches.BLR));

			menuRepo.save(new Menu(10, "ChickenFried Rice", 200, "Non-Veg", Branches.BLR));
			seatingRepo.save(new Seating(Branches.BLR, 12, 8, 2));

		} else if (branch == Branches.CHN) {

			// Employees

			employeeRepo.save(new Employee(3002, "Divya", 27, Roles.RECEPTIONIST, 'F', 31000, "divya@restaurant.com",
					Branches.CHN));

			employeeRepo.save(new Employee(3003, "Anusha", 29, Roles.RECEPTIONIST, 'F', 33000, "anusha@restaurant.com",
					Branches.CHN));

			employeeRepo.save(new Employee(3004, "Vamsi Krishna", 30, Roles.CASHIER, 'M', 29500, "vamsi@restaurant.com",
					Branches.CHN));

			employeeRepo.save(new Employee(3005, "Nandini", 28, Roles.CASHIER, 'F', 30500, "nandini@restaurant.com",
					Branches.CHN));

			employeeRepo
					.save(new Employee(3006, "Abhi", 39, Roles.CHEF, 'M', 47000, "abhi@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3007, "Lokesh", 37, Roles.CHEF, 'M', 44000, "lokesh@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3008, "Praveen", 35, Roles.CHEF, 'M', 42500, "praveen@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3009, "Ganesh", 40, Roles.CHEF, 'M', 46000, "ganesh@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3010, "Suraj", 36, Roles.CHEF, 'M', 43500, "suraj@restaurant.com", Branches.CHN));

			employeeRepo.save(new Employee(3011, "Rushikesh", 25, Roles.WAITER, 'M', 23500, "rushikesh@restaurant.com",
					Branches.CHN));

			employeeRepo.save(
					new Employee(3012, "Tejas", 26, Roles.WAITER, 'M', 24500, "tejas@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3013, "Varun", 24, Roles.WAITER, 'M', 22500, "varun@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3014, "Aditya", 27, Roles.WAITER, 'M', 24000, "aditya@restaurant.com", Branches.CHN));

			employeeRepo.save(
					new Employee(3015, "Keshav", 28, Roles.WAITER, 'M', 25000, "keshav@restaurant.com", Branches.CHN));

			// Menu

			menuRepo.save(new Menu(1, "FishFry", 220, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(2, "FishBiryani", 260, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(3, "FishCurry", 240, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(4, "PrawnsFry", 280, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(5, "PrawnsBiryani", 300, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(6, "PrawnsCurry", 290, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(7, "ChilliPrawns", 300, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(8, "ApolloFish", 280, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(9, "FishTikka", 250, "Seafood", Branches.CHN));

			menuRepo.save(new Menu(10, "CrabMasala", 320, "Seafood", Branches.CHN));

			// Seating

			seatingRepo.save(new Seating(Branches.CHN, 10, 6, 2));

		} else {
			return "Enter a valid branch";
		}
		return "Success";
	}

	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}
	
	public Employee getByID(int id) {
		return employeeRepo.findById(id).get();
	}
	public List<Employee> addEmployee(List<Employee> e){
		for(Employee emp:e) {
			employeeRepo.save(emp);
		}
		return e;
	}
	public Employee updateEmployee(Employee e) {
		employeeRepo.save(e);
		return e;
	}
	public Employee deleteEmployee(int id) {
		Employee e=employeeRepo.findById(id).get();
		employeeRepo.deleteById(id);
		return e;
	}
	public List<Menu> getMenu(Branches branch){
		return menuRepo.findByBranch(branch);
	}
	public List<Menu> addMenu(List<Menu> m){
		for(Menu item:m) {
			menuRepo.save(item);
		}
		return m;
	}
	public Menu updateMenu(Menu m) {
		menuRepo.save(m);
		return m;
	}
	public Menu deleteMenu(int id) {
		Menu m=menuRepo.findById(id).get();
		menuRepo.deleteById(id);
		return m;
	}
}
