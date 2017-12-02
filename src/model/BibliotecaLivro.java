package model;
import java.sql.*;

public class BibliotecaLivro {

	
	private Biblioteca biblioteca;
	private Livro livro;
	
	public BibliotecaLivro() {
			biblioteca = new Biblioteca();
			livro = new Livro();
	}

	public int getBiblioteca() {
		return biblioteca.getId();
	}
	public void setBiblioteca(int id) {
		biblioteca.setId(id);
	}
	public int getLivro() {
		return livro.getId();
	}
	public void setLivro(int id) {
		livro.setId(id);;
	}
	
	
}
