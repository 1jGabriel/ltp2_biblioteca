package br.com.projeto.biblioteca.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projeto.biblioteca.model.Biblioteca;

public class BibliotecaDAO {

	private Connection con;
	private Statement comando;

	private static final String INSERIR = " insert into biblioteca (nome) values (?)";

	private static final String CONSULTA_TODOS = "SELECT * FROM biblioteca";

	private static final String CONSULTA_POR_ID = "SELECT * FROM biblioteca where biblioteca.id = ?";

	private static final String DELETAR_BIBLIOTECA = "delete from biblioteca where biblioteca.id = ?";

	private static final String UPDATE_BIBLIOTECA = "UPDATE biblioteca SET nome = ? where biblioteca.id = ?";

	public void inserir(Biblioteca bib) {

		con = ConnectionFactory.getConnection();

		try {
			con.prepareStatement(INSERIR);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(INSERIR);

			preparedStmt.setString(1, bib.getNome());

			preparedStmt.execute();

			con.close();
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
	}

	public ArrayList<Biblioteca> consultar() {
		// obter conex�o chamando a classe ConnectionFactory
		con = ConnectionFactory.getConnection();

		// criar a lista resultante da consulta a ser retornada.
		ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

		try {
			// cria o comando.
			comando = con.createStatement();
			// executa a consulta

			ResultSet resultado = comando.executeQuery(CONSULTA_TODOS);

			// navega pelo resultado, montando objetos Empregado e
			// acrescentando � lista.
			while (resultado.next()) {
				Biblioteca bib = new Biblioteca();
				bib.setId(resultado.getInt("id"));
				bib.setNome(resultado.getString("nome"));
				bibliotecas.add(bib);
			}
			// fecha comando e conex�o.
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// retorna a lista de empregados.
		return bibliotecas;
	}

	public Biblioteca consultar(int id) {

		con = ConnectionFactory.getConnection();

		Biblioteca biblioteca = new Biblioteca();

		try {
			
			con.prepareStatement(CONSULTA_POR_ID);
			   java.sql.PreparedStatement preparedStmt = con.prepareStatement(CONSULTA_POR_ID);

			   preparedStmt.setInt (1, id);			

			ResultSet resultado = preparedStmt.executeQuery();
			resultado.next();
			biblioteca.setId(resultado.getInt("id"));
			biblioteca.setNome(resultado.getString("nome"));

//			comando.close();
			preparedStmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return biblioteca;
	}

	public void deletarBiblioteca(int bibliotecaId) {
		con = ConnectionFactory.getConnection();
		try {
			con.prepareStatement(DELETAR_BIBLIOTECA);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_BIBLIOTECA);

			preparedStmt.setInt(1, bibliotecaId);

			preparedStmt.execute();

			con.close();
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
	}

	public void updateBiblioteca(Biblioteca biblioteca) {
		con = ConnectionFactory.getConnection();

		try {
			con.prepareStatement(UPDATE_BIBLIOTECA);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_BIBLIOTECA);
			preparedStmt.setString(1, biblioteca.getNome());
			preparedStmt.setInt(2, biblioteca.getId());
			preparedStmt.executeUpdate();

			con.close();
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
	}

}
