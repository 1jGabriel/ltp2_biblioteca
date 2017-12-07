package br.com.projeto.biblioteca.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projeto.biblioteca.model.Livro;

public class LivroDAO {

	private Connection con;
	private Statement comando;

	private static final String INSERIR_LIVRO = " INSERT INTO livro (nome, editora, edicao, area) VALUES (?, ?, ?, ?);";

	private static final String CONSULTA_TODOS = "SELECT * FROM LIVRO";

	private static final String CONSULTA_POR_ID = "SELECT * FROM livro where id = ?";

	private static final String CONSULTA_lIVRO_BIBLIOTECA_ID = "SELECT DISTINCT l.id, l.nome, l.editora, l.edicao, l.area FROM LIVRO l INNER JOIN BIBLIOTECA_LIVRO bl ON bl.LIVRO_ID = l.id where bl.BIBLIOTECA_ID = ?";

	private static final String DELETAR_ID = "DELETE FROM Livro where id = ?";

	private static final String UPDATE_LIVRO = "UPDATE livro SET nome = ?, editora = ?, edicao = ?, area = ? WHERE livro.id = ?";

	private static final String CONSULTA_POR_NOME = "SELECT * FROM livro where nome like ?";
	
	private static final String CONSULTA_POR_EDITORA = "SELECT * FROM livro where editora like ? ";

	public Livro consultar(int id) {
		con = ConnectionFactory.getConnection();
		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
			con.prepareStatement(CONSULTA_POR_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(CONSULTA_POR_ID);

			preparedStmt.setInt(1, id);

			ResultSet resultado = preparedStmt.executeQuery();
			while (resultado.next()) {
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("editora"), resultado.getString("edicao"), resultado.getString("area")));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return livros.get(0);
	}
	
	public ArrayList<Livro> consultar(String editora) {
		con = ConnectionFactory.getConnection();
		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
			con.prepareStatement(CONSULTA_POR_EDITORA);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(CONSULTA_POR_EDITORA);

			preparedStmt.setString(1, editora+ "%");

			ResultSet resultado = preparedStmt.executeQuery();
			while (resultado.next()) {
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("editora"), resultado.getString("edicao"), resultado.getString("area")));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return livros;
	}

	//TODO AJUSTAR CONSULTA
	public ArrayList<Livro> consultarPorNome(String nome) {   
		con = ConnectionFactory.getConnection(); 
		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
						
			con.prepareStatement(CONSULTA_POR_NOME);
			java.sql.PreparedStatement preparedStmt = 
			con.prepareStatement(CONSULTA_POR_NOME);

			preparedStmt.setString(1, nome + "%");
			
			ResultSet resultado = preparedStmt.executeQuery();
								
			while (resultado.next()) {
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("editora"), resultado.getString("edicao"), resultado.getString("area")));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	public void inserirLivro(Livro livro) {

		con = ConnectionFactory.getConnection();

		try {
			con.prepareStatement(INSERIR_LIVRO);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(INSERIR_LIVRO);

			preparedStmt.setString(1, livro.getNome());
			preparedStmt.setString(2, livro.getEditora());
			preparedStmt.setString(3, livro.getEdicao());
			preparedStmt.setString(4, livro.getArea());

			preparedStmt.execute();

			con.close();
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
	}

	public ArrayList<Livro> consultarTodos() {
		con = ConnectionFactory.getConnection();

		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
			comando = con.createStatement();

			ResultSet resultado = comando.executeQuery(CONSULTA_TODOS);

			while (resultado.next()) {
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("editora"), resultado.getString("edicao"), resultado.getString("area")));
			}
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	public ArrayList<Livro> consultarLivrosPorBiblioteca(int id) {
		con = ConnectionFactory.getConnection();

		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
			con.prepareStatement(CONSULTA_lIVRO_BIBLIOTECA_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(CONSULTA_lIVRO_BIBLIOTECA_ID);

			preparedStmt.setInt(1, id);

			ResultSet resultado = preparedStmt.executeQuery();

			while (resultado.next()) {
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("editora"), resultado.getString("edicao"), resultado.getString("area")));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	public void deletarLivro(int id) {
		con = ConnectionFactory.getConnection();
		try {
			con.prepareStatement(DELETAR_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_ID);

			preparedStmt.setInt(1, id);

			preparedStmt.execute();

			con.close();
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}
	}

	public void updateLivro(Livro livro) {
		con = ConnectionFactory.getConnection();

		try {
			con.prepareStatement(UPDATE_LIVRO);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_LIVRO);
			preparedStmt.setString(1, livro.getNome());
			preparedStmt.setString(2, livro.getEditora());
			preparedStmt.setString(3, livro.getEdicao());
			preparedStmt.setString(4, livro.getArea());
			preparedStmt.setInt(5, livro.getId());
			preparedStmt.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
