package com.resman.WaiterResMan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resman.ManagerResMan.Models.Orders;

@Service
public class WaiterService {

	@Autowired
	RestTemplate restTemplate;
	
	String ManagerURL="http://localhost:8181"+"/waiter";

	public List<Orders> viewOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public Orders makeOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Orders updateOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOrder() {
		// TODO Auto-generated method stub
		
	}
}
