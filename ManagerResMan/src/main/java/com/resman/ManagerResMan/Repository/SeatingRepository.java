package com.resman.ManagerResMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResManCommon.ResCommon.Branches;
import com.resman.ManagerResMan.Models.Seating;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Repository
public interface SeatingRepository extends JpaRepository<Seating,Branches> {


	@Enumerated(EnumType.STRING)
	Seating findByBranch(Branches branch);
}
