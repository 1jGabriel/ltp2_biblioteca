package br.com.projeto.biblioteca.controller;

import java.util.ArrayList;

import br.com.projeto.biblioteca.dao.BibliotecaDAO;
import br.com.projeto.biblioteca.model.Biblioteca;

public class BibliotecaController {
	private BibliotecaDAO bibliotecaDao = new BibliotecaDAO();

	public void inserirBiblioteca(Biblioteca biblioteca) {
		bibliotecaDao.inserir(biblioteca);
	}

	public void updateBiblioteca(Biblioteca biblioteca) {
		bibliotecaDao.updateBiblioteca(biblioteca);

	}

	public void deletarBiblioteca(Biblioteca biblioteca) {
		bibliotecaDao.deletarBiblioteca(biblioteca.getId());
	}

	public ArrayList<Biblioteca> listarTodasBibliotecas() {
		return bibliotecaDao.consultar();
	}

	public ArrayList<Biblioteca> listarBibliotecaPorId(Biblioteca biblioteca) {
		return bibliotecaDao.consultar(biblioteca.getId());
	}

}
