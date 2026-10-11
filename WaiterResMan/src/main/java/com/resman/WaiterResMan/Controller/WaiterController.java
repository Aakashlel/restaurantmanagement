package com.resman.WaiterResMan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resman.ManagerResMan.Models.Orders;
import com.resman.WaiterResMan.Service.WaiterService;

@RestController
@RequestMapping("/waiter")
public class WaiterController {

	@Autowired
	WaiterService ws;
	@GetMapping("/order")
	public List<Orders> viewOrders(){
		return ws.viewOrders();
	}
	
	@PostMapping("/order")
	public Orders makeOrder(@RequestBody Orders order) {
		return ws.makeOrder();
	}
	
	@PutMapping("/order")
	public Orders updateOrder(@RequestBody Orders order) {
		return ws.updateOrder();
	}
	
	@DeleteMapping("/order")
	public Orders deleteOrder(@RequestParam int id) {
		ws.deleteOrder();
	}
}
