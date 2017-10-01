package com.italocosta.crudvraptor.controler;

import javax.inject.Inject;

import com.italocosta.crudvraptor.model.Client;
import com.italocosta.crudvraptor.service.ClientService;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path("client")
public class ClientController {
	
	@Inject
	private ClientService service;
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	
	@Get({"/",""})
	public void listClients() {
		result.include("clientList", service.getAllClients());
	}
	
	@Get("add/")
	public void addClient() {		
	}
	
	@Post("/")
	public void toAdd(Client client) {
		validator.onErrorUsePageOf(this).editClient(client.getId());
		service.createClient(client);
		result.redirectTo(this).listClients();
	}
	
	@Put("/")
	public void toEdit(Client client) {
		validator.onErrorUsePageOf(this).editClient(client.getId());
		service.updateClient(client);
		result.redirectTo(this).listClients();
	}
	
	@Get("edit/{id}")
	public void editClient(Integer id) {		
		result.include("client", service.getClientById(id));
	}
	
	@Delete("/{id}")
	public void toDelete(Integer id) {
		service.removeClient(id);
		result.redirectTo(this).listClients();
	}
}
