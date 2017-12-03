package controller;

import java.util.ArrayList;

import dao.LivroDAO;
import model.Biblioteca;
import model.Livro;

public class LivroController {
	private LivroDAO livroDAO = new LivroDAO();
	private BibliotecaLivroController bibliotecaLivroController = new BibliotecaLivroController();
	
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
		bibliotecaLivroController.deletarLivro(livro);
		livroDAO.deletarLivro(livro.getId());
	}
	
	

}
