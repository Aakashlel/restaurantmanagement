package com.resman.ManagerResMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resman.ManagerResMan.Models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
