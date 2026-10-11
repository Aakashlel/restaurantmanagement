package com.resman.ManagerResMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resman.ManagerResMan.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
