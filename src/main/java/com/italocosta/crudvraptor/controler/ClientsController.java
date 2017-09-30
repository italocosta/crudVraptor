package com.italocosta.crudvraptor.controler;

import javax.inject.Inject;

import com.italocosta.crudvraptor.service.ClientService;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class ClientsController {
	
	@Inject
	private ClientService service;
	@Inject
	private Result result;
	
	@Get("/")
	public void listClients() {
		result.include("clientList", service.getAllClients());
	}
}
