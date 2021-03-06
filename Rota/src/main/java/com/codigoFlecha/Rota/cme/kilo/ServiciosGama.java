package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGama {

	@Autowired 
	private RepositorioGama metodosCrud;

	public List <gama> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<gama> getGama(int idGama){
		
		return metodosCrud.getGama(idGama);
	}
	public gama save(gama gama) {
		
		if(gama.getIdGama( )==null) {
			return metodosCrud.save(gama);
		}
		else {
			Optional<gama> evt=metodosCrud.getGama(gama.getIdGama());
			if(evt.isEmpty()) {
				return metodosCrud.save(gama);
			}
			else {
				return gama;
			}
		}
		 
	}
	
}

