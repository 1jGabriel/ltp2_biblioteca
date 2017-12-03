package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Biblioteca;
import model.BibliotecaLivro;

public class BibliotecaLivroDAO {
	private Connection con;
	private Statement comando;
	
	private static final String INSERIR_BIBLIOTECA= 
			" insert into biblioteca_livro (biblioteca_id) values (?)";
	
	private static final String INSERIR_BIBLIOTECA_LIVRO= 
			" insert into biblioteca_livro (biblioteca_id, livro_id) values (?, ?)";
	
	private static final String CONSULTA_TODOS = 
			"SELECT * FROM biblioteca_livro";
	
	private static final String CONSULTA_ID_BIBLIOTECA = 
			"SELECT * FROM biblioteca_livro where id = ?";
	
	
	private static final String DELETAR_LIVRO = 
			"DELETE FROM biblioteca_livro where biblioteca_livro.livro_id = ? and biblioteca_livro.biblioteca_id = ?";
	
	private static final String DELETAR_LIVRO_BIBLIOTECA = "DELETE FROM biblioteca_livro where and biblioteca_livro.biblioteca_id = ?";
	
	
	public void inserirBiblioteca (int id)  {

		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(INSERIR_BIBLIOTECA);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(INSERIR_BIBLIOTECA);

			preparedStmt.setInt(1, id);
			
			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}     
	
	
	public void inserirLivroBiblioteca (int idBiblioteca, int idLivro)  {

		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(INSERIR_BIBLIOTECA_LIVRO);
			java.sql.PreparedStatement preparedStmt = 
					con.prepareStatement(INSERIR_BIBLIOTECA);

			preparedStmt.setInt(1, idBiblioteca);
			preparedStmt.setInt(2, idLivro);
			
			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}  
	

	public ArrayList<Biblioteca> consultar() {   
		//obter conex�o chamando a classe ConnectionFactory
		con = ConnectionFactory.getConnection(); 

		//criar a lista resultante da consulta a ser retornada.
		ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

		try {
			//cria o comando.
			comando = con.createStatement();
			//executa a consulta

			ResultSet resultado = comando.executeQuery(CONSULTA_TODOS);

			//navega pelo resultado, montando objetos Empregado e 
			//acrescentando � lista.
			while(resultado.next())
			{
				Biblioteca bib = new Biblioteca();
				bib.setId(resultado.getInt("id"));
				bib.setNome(resultado.getString("nome"));
				bibliotecas.add(bib);
			}
			//fecha comando e conex�o.
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//retorna a lista de empregados.
		return bibliotecas;
	} 
	
	public ArrayList<BibliotecaLivro> consultar(int id) {   
		//obter conex�o chamando a classe ConnectionFactory
		con = ConnectionFactory.getConnection(); 

		//criar a lista resultante da consulta a ser retornada.
		ArrayList<BibliotecaLivro> bibliotecas = new ArrayList<BibliotecaLivro>();

		try {
			//cria o comando.
			comando = con.createStatement();
			//executa a consulta

			ResultSet resultado = comando.executeQuery(CONSULTA_ID_BIBLIOTECA);

			//navega pelo resultado, montando objetos Empregado e 
			//acrescentando � lista.
			while(resultado.next())
			{
				BibliotecaLivro bib = new BibliotecaLivro();
				bib.setBiblioteca(resultado.getInt("biblioteca_id"));
				
				bibliotecas.add(bib);
			}
			//fecha comando e conex�o.
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//retorna a lista de empregados.
		return bibliotecas;
	} 
	
	public void deletarLivro(int idLivro, int idBiblioteca){
		con = ConnectionFactory.getConnection(); 
		try {
			con.prepareStatement(DELETAR_LIVRO);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_LIVRO);

			preparedStmt.setInt (1, idLivro);
			preparedStmt.setInt (2, idBiblioteca);


			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		
	}
	
	public void deletarBibliotecaLivro(int idBiblioteca){
		con = ConnectionFactory.getConnection(); 
		try {
			con.prepareStatement(DELETAR_LIVRO_BIBLIOTECA);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_LIVRO_BIBLIOTECA);

			preparedStmt.setInt (1, idBiblioteca);


			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}
	
}
