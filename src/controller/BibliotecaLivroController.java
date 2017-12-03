package controller;

import java.util.ArrayList;

import dao.BibliotecaLivroDAO;
import model.Biblioteca;
import model.Livro;

public class BibliotecaLivroController {

	private BibliotecaLivroDAO bibliotecaLivroDAO = new BibliotecaLivroDAO();
	
	
	public void inserirLivro(Livro livro, Biblioteca biblioteca){
		bibliotecaLivroDAO.inserirLivroBiblioteca(biblioteca.getId(), livro.getId());
	}
	
	public ArrayList<Livro> listarTodasLivros(){
		return null;
	}
	
	public ArrayList<Livro> listarLivrosPorBiblioteca(Biblioteca biblioteca){
		return null;
	}
	
	public void updateLivro(Livro livro){
		
	}
	
	public void deletarLivro(Livro livro, Biblioteca biblioteca){
		//livroController.deletarLivro(livro);
		bibliotecaLivroDAO.deletarLivro(livro.getId(), biblioteca.getId());
	}
	public void deletarLivro(Livro livro){
		//livroController.deletarLivro(livro);
		bibliotecaLivroDAO.deletarLivro(livro.getId());
	}
	
	public void deletarBiblioteca(Biblioteca biblioteca){
		bibliotecaLivroDAO.deletarBibliotecaLivro(biblioteca.getId());
		//bibliotecaController.deletarBiblioteca(biblioteca);
		
	}
	
	
}
