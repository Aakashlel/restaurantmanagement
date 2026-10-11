package com.resman.ManagerResMan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResManCommon.ResCommon.Branches;
import com.resman.ManagerResMan.Models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
	
	List<Menu> findByBranch(Branches branch);

}
