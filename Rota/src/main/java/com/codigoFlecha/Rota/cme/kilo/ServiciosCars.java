package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosCars {

	@Autowired 
	private RepositorioCars metodosCrud;

	public List <cars> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<cars> getCars(int idCars){
		
		return metodosCrud.getCars(idCars);
	}
	public cars save(cars carrito) {
		
		if(carrito.getIdCar( )==null) {
			return metodosCrud.save(carrito);
		}
		else {
			Optional<cars> evt=metodosCrud.getCars(carrito.getIdCar());
			if(evt.isEmpty()) {
				return metodosCrud.save(carrito);
			}
			else {
				return carrito;
			}
		}
		 
	}
	
}

