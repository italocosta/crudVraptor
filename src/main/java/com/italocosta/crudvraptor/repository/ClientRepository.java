package com.italocosta.crudvraptor.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.italocosta.crudvraptor.model.Client;


public class ClientRepository {
	
	private static final Set<Client> CLIENTS = new HashSet<Client>();
	
	public ClientRepository() {
		Client client = new Client(1, "ITALO COSTA", new Date(), 1.87, true);
		insertClient(client);
		client = new Client(2, "JESSICA COSTA", new Date(), 1.57, false);
		insertClient(client);
	}
	
	public List<Client> getAllClients(){
		return new ArrayList<Client>(CLIENTS);
	}
	
	public Client getClientById(Integer id) {
		for (Client client : CLIENTS) {
			if(client.getId().compareTo(id)==0)
				return client;
		}
		return null;
	}
	
	public Boolean updateClient(Client client) {
		CLIENTS.remove(getClientById(client.getId()));
		return CLIENTS.add(client);
	}
	
	public Boolean insertClient(Client client) {
		return CLIENTS.add(client);
	}
	
	public Boolean deleteClient(Client client) {
		return CLIENTS.remove(client);
	}
	
}
