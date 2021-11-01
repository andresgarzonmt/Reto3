package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservation {

	@Autowired 
	private RepositorioReservation metodosCrud;

	public List <reservation> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<reservation> getReservation(int idReservation){
		
		return metodosCrud.getReservation(idReservation);
	}
	public reservation save(reservation reservations) {
		
		if(reservations.getIdReservation( )==null) {
			return metodosCrud.save(reservations);
		}
		else {
			Optional<reservation> evt=metodosCrud.getReservation(reservations.getIdReservation());
			if(evt.isEmpty()) {
				return metodosCrud.save(reservations);
			}
			else {
				return reservations;
			}
		}
		 
	}
	
}

