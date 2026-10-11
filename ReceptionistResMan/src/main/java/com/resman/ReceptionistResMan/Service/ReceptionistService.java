package com.resman.ReceptionistResMan.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.ReservationDTO;
import com.ResManCommon.ResCommon.SeatingDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Service
public class ReceptionistService {

	@Autowired
	private RestTemplate restTemplate;
	public String ManagerURL="http://localhost:8181"+"/receptionist";
	
	public SeatingDTO checkAvailability(Branches branch) {
		SeatingDTO res= restTemplate.getForObject(ManagerURL+"/checkAvailability/"+String.valueOf(branch),SeatingDTO.class);
		System.out.println(res);
		return res;
	}
	
	public String makeReservation(ReservationDTO reservation) {
		restTemplate.postForObject(ManagerURL+"/make",reservation,ReservationDTO.class);
		return "created";
	}

	public List<ReservationDTO> viewReservation(Branches branch) {
		System.out.println(branch);
		ResponseEntity<ReservationDTO[]> response= restTemplate.getForEntity(ManagerURL+"/reservation/"+String.valueOf(branch),ReservationDTO[].class);
		return Arrays.asList(response.getBody());
	}
	public ReservationDTO cancelReservation(int id) {
		ReservationDTO r=restTemplate.getForObject(ManagerURL+"/"+String.valueOf(id),ReservationDTO.class);
		restTemplate.delete(ManagerURL+"/"+String.valueOf(id),ReservationDTO.class);
		return r;
	}
	public String occupyTable(int id){
		restTemplate.postForObject(ManagerURL+"/occupy",id,ReservationDTO.class);
		return "occupied";
	}
	public String freeTable(int id) {
		restTemplate.delete(ManagerURL+"/free?id="+id);
		return "freed";
	}
}
