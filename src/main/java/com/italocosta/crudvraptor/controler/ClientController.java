package com.italocosta.crudvraptor.controler;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import com.italocosta.crudvraptor.model.Client;
import com.italocosta.crudvraptor.service.ClientService;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
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
	
	@Put("/{client.id}")
	public void toEdit(Client client) {
		validator.onErrorUsePageOf(this).editClient(client.getId());
		service.updateClient(client);
		result.redirectTo(this).listClients();
	}
	
	@Get("/{id}")
	public void editClient(Integer id) {		
		result.include("client", service.getClientById(id));
	}
}
