package com.resman.ManagerResMan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResManCommon.ResCommon.Branches;
import com.resman.ManagerResMan.Models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

	List<Reservation> findByBranch(Branches branch);
}
