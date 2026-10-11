package com.resman.ManagerResMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resman.ManagerResMan.Models.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills,Integer> {

}
