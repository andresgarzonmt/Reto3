package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {

	@Autowired 
	private RepositorioMessage metodosCrud;

	public List <message> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<message> getMessage(int idMessage){
		
		return metodosCrud.getMessage(idMessage);
	}
	public message save(message messages) {
		
		if(messages.getIdMessage( )==null) {
			return metodosCrud.save(messages);
		}
		else {
			Optional<message> evt=metodosCrud.getMessage(messages.getIdMessage());
			if(evt.isEmpty()) {
				return metodosCrud.save(messages);
			}
			else {
				return messages;
			}
		}
		 
	}
	
}

