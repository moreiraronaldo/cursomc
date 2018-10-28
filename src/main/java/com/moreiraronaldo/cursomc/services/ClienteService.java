package com.moreiraronaldo.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moreiraronaldo.cursomc.domain.Cliente;
import com.moreiraronaldo.cursomc.reposotories.ClienteRepository;
import com.moreiraronaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Cliente obj = repo.findOne(id);
		
		if(obj == null ) {
			throw new ObjectNotFoundException("Objeto nao encontrado - ID: "  + id
					+  ", Tipo: " + Cliente.class.getName());
		}
		
		return obj;
	}
}
