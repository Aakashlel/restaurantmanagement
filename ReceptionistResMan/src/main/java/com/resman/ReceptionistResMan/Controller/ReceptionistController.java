package com.resman.ReceptionistResMan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.ReservationDTO;
import com.ResManCommon.ResCommon.SeatingDTO;
import com.resman.ReceptionistResMan.Service.ReceptionistService;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	ReceptionistService rs;
	
	@Enumerated(EnumType.STRING)
	@GetMapping("/check/{branch}")
	public SeatingDTO checkAvailability(@PathVariable Branches branch) {
		return rs.checkAvailability(branch);
	}
	@PostMapping("/reservation")
	public void makeReservation(@RequestBody ReservationDTO reservation) {
		rs.makeReservation(reservation);
		return;
	}
	@Enumerated(EnumType.STRING)
	@GetMapping("/reservation/{branch}")
	public List<ReservationDTO> viewReservation(Branches branch){
		return rs.viewReservation(branch);
	}
	@DeleteMapping("/reservation")
	public ReservationDTO deleteReservation(@RequestParam int id) {
		return rs.cancelReservation(id);
	}
	@PostMapping("/occupy")
	public String occupyTable(@RequestParam int id) {
		return rs.occupyTable(id);
	}
	@DeleteMapping("/free")
	public String freeTable(@RequestParam int id) {
		return rs.freeTable(id);
	}
}
