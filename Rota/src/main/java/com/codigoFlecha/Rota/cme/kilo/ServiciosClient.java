package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosClient {

	@Autowired 
	private RepositorioClient metodosCrud;

	public List <client> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<client> getClient(int idClient){
		
		return metodosCrud.getClient(idClient);
	}
	public client save(client client) {
		
		if(client.getIdClient( )==null) {
			return metodosCrud.save(client);
		}
		else {
			Optional<client> evt=metodosCrud.getClient(client.getIdClient());
			if(evt.isEmpty()) {
				return metodosCrud.save(client);
			}
			else {
				return client;
			}
		}
		 
	}
	
}

