package com.resman.ManagerResMan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ResManCommon.ResCommon.Branches;
import com.resman.ManagerResMan.Models.Employee;
import com.resman.ManagerResMan.Models.Menu;
import com.resman.ManagerResMan.Service.ManagerService;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	ManagerService ms;
	
	@GetMapping("/initializeBranch/{branch}")
	@Enumerated(EnumType.STRING)
	public String initializeBranch(@PathVariable Branches branch) {
		return ms.initializeBranch(branch);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAll(){
		return ms.getAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getByID(@PathVariable int id) {
		return ms.getByID(id);
	}
	@PostMapping("/employee")
	public List<Employee> addEmployee(@RequestBody List<Employee> e){
		ms.addEmployee(e);
		return e;
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee e) {
		ms.updateEmployee(e);
		return e;
	}
	@DeleteMapping("/employee")
	public Employee deleteEmployee(@RequestParam int id) {
		return ms.deleteEmployee(id);
	}
	@GetMapping("/menu/{branch}")
	@Enumerated(EnumType.STRING)
	public List<Menu> viewMenu(@PathVariable Branches branch){
		return ms.getMenu(branch);
	}
	@PostMapping("/menu")
	public List<Menu> addMenu(@RequestBody List<Menu> m){
		ms.addMenu(m);
		return m;
	}
	@PutMapping("/menu")
	public Menu updateMenu(@RequestBody Menu m) {
		ms.updateMenu(m);
		return m;
	}
	@DeleteMapping("/menu")
	public Menu deleteMenu(@RequestParam int id) {
		return ms.deleteMenu(id);
	}
}
