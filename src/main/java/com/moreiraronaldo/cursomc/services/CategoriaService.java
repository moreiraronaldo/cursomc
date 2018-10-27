package com.moreiraronaldo.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moreiraronaldo.cursomc.domain.Categoria;
import com.moreiraronaldo.cursomc.reposotories.CategoriaRepository;
import com.moreiraronaldo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj == null ) {
			throw new ObjectNotFoundException("Objeto nao encontrado - ID: "  + id
					+  ", Tipo: " + Categoria.class.getName());
		}
		
		return obj;
	}
	
	public Categoria insert(Categoria obj ) {
		obj.setId(null);
		return repo.save(obj);
	}
}
