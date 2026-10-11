package com.RestrauntManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuItem implements Admin {
	
	String DishName;
	int Price;
	String FoodType;
	String Branch;
	int DishID;
	public MenuItem(String dishName, int price, String foodType, String branch, int dishID) {
		super();
		DishName = dishName;
		Price = price;
		FoodType = foodType;
		Branch = branch;
		DishID = dishID;
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into menu(DishName,Price,FoodType,Branch,DishID) values(?,?,?,?,?)");
			pstmt.setString(1, this.DishName);
			pstmt.setInt(2, this.Price);
			pstmt.setString(3, this.FoodType);
			pstmt.setString(4, this.Branch);
			pstmt.setInt(5, this.DishID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
