package com.italocosta.crudvraptor.service;

import java.util.List;

import javax.inject.Inject;

import com.italocosta.crudvraptor.model.Client;
import com.italocosta.crudvraptor.repository.ClientRepository;

public class ClientService {
	
	@Inject
	private ClientRepository repo;
	
	public List<Client> getAllClients(){
		return repo.getAllClients();
	}
	
	public Client getClientById(Integer id){
		return repo.getClientById(id);
	}
	
	public void createClient(Client client) {
		repo.insertClient(client);
	}
	
	public void updateClient(Client client) {
		repo.updateClient(client);
	}
}
