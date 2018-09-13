package com.moreiraronaldo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moreiraronaldo.cursomc.domain.Categoria;
import com.moreiraronaldo.cursomc.domain.Cidade;
import com.moreiraronaldo.cursomc.domain.Estado;
import com.moreiraronaldo.cursomc.domain.Produto;
import com.moreiraronaldo.cursomc.reposotories.CategoriaRepository;
import com.moreiraronaldo.cursomc.reposotories.CidadeRepository;
import com.moreiraronaldo.cursomc.reposotories.EstadoRepository;
import com.moreiraronaldo.cursomc.reposotories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaReporisory;
	@Autowired
	private ProdutoRepository produtoReporisory;
	@Autowired
	private EstadoRepository estadoReporisory;
	@Autowired
	private CidadeRepository cidadeReporisory;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaReporisory.save(Arrays.asList(cat1, cat2));
		produtoReporisory.save(Arrays.asList(p1, p2, p3));
		estadoReporisory.save(Arrays.asList(est1, est2));
		cidadeReporisory.save(Arrays.asList(c1,c2,c3));
		
	}
}
