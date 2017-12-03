package controller;

import java.util.ArrayList;

import dao.BibliotecaDAO;
import model.Biblioteca;

public class BibliotecaController {
	private BibliotecaDAO bibliotecaDao = new BibliotecaDAO();
	private BibliotecaLivroController bibliotecaLivroController = new BibliotecaLivroController();
	
	public void inserirBiblioteca(Biblioteca biblioteca){
		bibliotecaDao.inserir(biblioteca);
	}
	
	public void updateBiblioteca(Biblioteca biblioteca){
		bibliotecaDao.updateBiblioteca(biblioteca);
		
	}
	
	public void deletarBiblioteca(Biblioteca biblioteca){
		bibliotecaLivroController.deletarBiblioteca(biblioteca);
		bibliotecaDao.deletarBiblioteca(biblioteca.getId());
	}
	
	public ArrayList<Biblioteca> listarTodasBibliotecas(){
		return bibliotecaDao.consultar();
	}
	
	public ArrayList<Biblioteca> listarBibliotecaPorId(Biblioteca biblioteca){
		return bibliotecaDao.consultar(biblioteca.getId());
	}
	
	
	
}
