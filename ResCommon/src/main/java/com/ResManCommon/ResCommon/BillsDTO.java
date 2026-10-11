package com.ResManCommon.ResCommon;

public class BillsDTO {

	private int billID;
	private int dishName;
	private int Price;
	private int Discount=0;
	private int Quantity;
	public BillsDTO() {
		super();
	}
	public BillsDTO(int billID, int dishName, int price, int discount, int quantity) {
		super();
		this.billID = billID;
		this.dishName = dishName;
		Price = price;
		Discount = discount;
		Quantity = quantity;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getDishName() {
		return dishName;
	}
	public void setDishName(int dishName) {
		this.dishName = dishName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "BillsDTO [billID=" + billID + ", dishName=" + dishName + ", Price=" + Price + ", Discount=" + Discount
				+ ", Quantity=" + Quantity + "]";
	}
	
}
