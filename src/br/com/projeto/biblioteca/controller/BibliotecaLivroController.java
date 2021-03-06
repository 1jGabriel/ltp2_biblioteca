package br.com.projeto.biblioteca.controller;

import java.util.ArrayList;

import br.com.projeto.biblioteca.dao.BibliotecaLivroDAO;
import br.com.projeto.biblioteca.model.Biblioteca;
import br.com.projeto.biblioteca.model.Livro;

public class BibliotecaLivroController {
	private LivroController livroController = new LivroController();
	private BibliotecaController bibliotecaController = new BibliotecaController();
	private BibliotecaLivroDAO bibliotecaLivroDAO = new BibliotecaLivroDAO();

	public void inserirLivro(Livro livro, Biblioteca biblioteca) {
		bibliotecaLivroDAO.inserirLivroBiblioteca(biblioteca.getId(), livro.getId());
	}

	public ArrayList<Livro> listarTodasLivros() {
		return null;
	}

	public ArrayList<Livro> listarLivrosPorBiblioteca(Biblioteca biblioteca) {
		return null;
	}

	public void updateLivro(Livro livro) {

	}

	public void deletarLivro(Livro livro, Biblioteca biblioteca) {
		livroController.deletarLivro(livro);
		bibliotecaLivroDAO.deletarLivro(livro.getId(), biblioteca.getId());
	}

	public void deletarBiblioteca(Biblioteca biblioteca) {
		bibliotecaController.deletarBiblioteca(biblioteca);
		bibliotecaLivroDAO.deletarBibliotecaLivro(biblioteca.getId());

	}

}
