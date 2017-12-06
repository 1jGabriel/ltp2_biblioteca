package br.com.projeto.biblioteca.controller;

import java.util.ArrayList;

import br.com.projeto.biblioteca.dao.LivroDAO;
import br.com.projeto.biblioteca.model.Biblioteca;
import br.com.projeto.biblioteca.model.Livro;

public class LivroController {
	private LivroDAO livroDAO = new LivroDAO();
	
	public void inserirLivro(Livro livro){
		livroDAO.inserirLivro(livro);
	}
	
	public ArrayList<Livro> listarTodasLivros(){
		return livroDAO.consultarTodos();
	}
	
	public ArrayList<Livro> listarLivrosPorBiblioteca(Biblioteca biblioteca){
		return livroDAO.consultarLivrosPorBiblioteca(biblioteca.getId());
	}
	
	public void updateLivro(Livro livro){
		livroDAO.updateLivro(livro);
		
	}
	
	public void deletarLivro(Livro livro){
		livroDAO.deletarLivro(livro.getId());
	}
	
	public Livro consultar(int id) {
		return livroDAO.consultar(id);
	}
	
	

}

