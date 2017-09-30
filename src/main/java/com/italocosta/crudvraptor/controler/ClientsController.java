package com.italocosta.crudvraptor.controler;

import javax.inject.Inject;

import com.italocosta.crudvraptor.service.ClientService;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
@Path("client")
public class ClientsController {
	
	@Inject
	private ClientService service;
	@Inject
	private Result result;
	
	@Get({"/",""})
	public void listClients() {
		result.include("clientList", service.getAllClients());
	}
	
	@Put("/{client.id}")
	public void toEdit() {
		result.forwardTo(this).listClients();
	}
	
	@Get("/{id}")
	public void editClient(Integer id) {		
		result.include("client", service.getClientById(id));
	}
}
