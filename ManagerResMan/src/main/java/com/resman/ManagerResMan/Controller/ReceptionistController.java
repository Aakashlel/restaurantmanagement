package com.resman.ManagerResMan.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.ReservationDTO;
import com.ResManCommon.ResCommon.SeatingDTO;
import com.resman.ManagerResMan.Service.ReceptionistService;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	ReceptionistService rs;
	
	@Enumerated(EnumType.STRING)
	@GetMapping("/checkAvailability/{branch}")
	public SeatingDTO checkAvailability(@PathVariable Branches branch) {
		SeatingDTO dto=rs.checkAvailability(branch);
		System.out.println(dto.getClass());
		return dto;
	}
	@PostMapping("/make")
	public void makeReservation(@RequestBody ReservationDTO reservation) {
		try {
			rs.makeReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	@Enumerated(EnumType.STRING)
	@GetMapping("/{branch}")
	public List<ReservationDTO> viewReservation(@PathVariable Branches branch){
		return rs.viewReservation(branch);
	}
	
	@GetMapping("/{id}")
	public ReservationDTO getReservationById(@PathVariable int id) {
		return rs.findById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		rs.deleteById(id);
		return;
	}
	@PostMapping("/occupy")
	public void occupyTable(@RequestBody int id) {
		rs.occupyTable(id);
		return;
	}
	@DeleteMapping("/free")
	public void freeTable(@RequestBody int id) {
		rs.freeTable(id);
		return;
	}
	

}
