package com.ResManCommon.ResCommon;

public class BillsDTO {

	private int billID;
	private int dishName;
	private int price;
	private int discount=0;
	private int quantity;
	public BillsDTO() {
		super();
	}
	public BillsDTO(int billID, int dishName, int price, int discount, int quantity) {
		super();
		this.billID = billID;
		this.dishName = dishName;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
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
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return this.discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BillsDTO [billID=" + billID + ", dishName=" + dishName + ", Price=" + price + ", Discount=" + discount
				+ ", Quantity=" + quantity + "]";
	}
	
}
