package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Biblioteca;

public class BibliotecaLivroDAO {



	private Connection con;
	private Statement comando;
	
	
	private static final String INSERIR_BIBLIOTECA= 
			" insert into biblioteca_livro (biblioteca_id) values (?)";
	

	private static final String CONSULTA_TODOS = 
			"SELECT * FROM Biblioteca";
	
	public void inserir (Biblioteca bib)  {

		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(INSERIR);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(INSERIR);

			preparedStmt.setString (1, bib.getNome());
			
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
}
