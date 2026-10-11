package com.resman.ManagerResMan.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ResManCommon.ResCommon.Branches;
import com.ResManCommon.ResCommon.ReservationDTO;
import com.ResManCommon.ResCommon.SeatingDTO;
import com.resman.ManagerResMan.Models.Reservation;
import com.resman.ManagerResMan.Models.Seating;
import com.resman.ManagerResMan.Repository.ReservationRepository;
import com.resman.ManagerResMan.Repository.SeatingRepository;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ReceptionistService {

	@Autowired
	SeatingRepository seatingRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Enumerated(EnumType.STRING)
	public SeatingDTO checkAvailability(Branches branch) {

		SeatingDTO sdto=new SeatingDTO();
		Seating s=seatingRepo.findByBranch(branch);
		if(s != null) {
		BeanUtils.copyProperties(s,sdto);
		return sdto;
		}
		else {
			return sdto;
		}
	}
	
	public void makeReservation(ReservationDTO reservation) throws Exception {

		Seating seating=seatingRepo.findById(reservation.getBranch()).orElseThrow();
		List<Integer> tables=getRequired(reservation.getCount());
		int s3=seating.getSeats3();
		int s5=seating.getSeats5();
		int s10=seating.getSeats10();
		for(int cat:tables) {
			if(cat == 10) {
				--s10;
			}
			else if(cat == 5) {
				--s5;
			}
			else {
				--s3;
			}
			if(s10<0 || s5<0 || s3<0) {
				throw new Exception("Not Enough seats");
			}
		}
		seating.setSeats3(s3);
		seating.setSeats5(s5);
		seating.setSeats10(s10);
		seatingRepo.save(seating);
		Reservation res = new Reservation();
		BeanUtils.copyProperties(reservation,res);
		reservationRepo.save(res);
		
	}
		
	
	public List<Integer> getRequired(int numCust){
		List<Integer> table=new ArrayList<Integer>();
		while(numCust>=0) {
			int s=(numCust>=10)?10:(numCust>=5)?5:3;
			table.add(s);
			numCust-=s;
		}
		return table;
	}
	
	public List<ReservationDTO> viewReservation(Branches branch) {
		List<Reservation> res=reservationRepo.findByBranch(branch);
		List<ReservationDTO> resdto=new ArrayList<ReservationDTO>();
		for(Reservation r:res) {
			ReservationDTO dto=new ReservationDTO();
			BeanUtils.copyProperties(r,dto);
			resdto.add(dto);
		}
		return resdto;
	}

	public ReservationDTO findById(int id) {

		ReservationDTO r=new ReservationDTO();
		BeanUtils.copyProperties(reservationRepo.findById(id).get(),r);
		return r;
	}

	public void deleteById(int id) {

		Reservation r=reservationRepo.findById(id).get();
		int count=r.getNumCustomers();
		List<Integer> tables=getRequired(count);
		Seating s=seatingRepo.findByBranch(r.getBranch());
		for(int table:tables) {
			if(table == 10) {
				s.setSeats10(s.getSeats10()+1);
			}
			else if(table == 5) {
				s.setSeats5(s.getSeats5()+1);
			}
			else {
				s.setSeats3(s.getSeats3()+1);
			}
		}
		seatingRepo.save(s);
		reservationRepo.deleteById(id);
		return;
	}

	public void occupyTable(int id) {

		Reservation r=reservationRepo.findById(id).get();
		r.setStatus('o');
		reservationRepo.save(r);
		return;
	}

	public void freeTable(int id) {
		deleteById(id);
	}
}
