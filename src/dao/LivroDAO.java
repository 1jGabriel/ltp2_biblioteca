package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Livro;

public class LivroDAO {
	
	private Connection con;
	private Statement comando;
	
	private static final String INSERIR_LIVRO= 
			" INSERT INTO livro (nome, editora, edicao, area) VALUES (?, ?, ?, ?);";
	
	private static final String CONSULTA_TODOS = 
			"SELECT * FROM LIVRO";
	
	private static final String CONSULTA_lIVRO_BIBLIOTECA_ID= 
			"SELECT DISTINCT id, nome, editora, edicao, area FROM LIVRO INNER JOIN BIBLIOTECA_LIVRO ON BIBLIOTECA_LIVRO.LIVRO_ID = LIVRO_ID WHERE BIBLIOTECA_LIVRO.BIBLIOTECA_ID = ?";
	
	private static final String DELETAR_ID= "DELETE FROM Livro where id = ?";
	
	private static final String DELETAR_ALL= "DELETE FROM Livro ";	
	
	private static final String UPDATE_LIVRO = "UPDATE livro SET nome = ?, editora = ?, edicao = ?, area = ? WHERE livro.id = ?";
	
	
	
	public void inserirLivro (Livro livro)  {

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

			while(resultado.next())
			{
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("editora"),resultado.getString("edicao"), resultado.getString("area")));
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
			comando = con.createStatement();

			ResultSet resultado = comando.executeQuery(CONSULTA_lIVRO_BIBLIOTECA_ID);

			while(resultado.next())
			{
				livros.add(new Livro(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("editora"),resultado.getString("edicao"), resultado.getString("area")));
				
			}
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	} 
	
	
	public void deletarLivro(int id){
		con = ConnectionFactory.getConnection(); 
		try {
			con.prepareStatement(DELETAR_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_ID);

			preparedStmt.setInt (1, id);


			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}
	
	public void updateLivro(Livro livro){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(UPDATE_LIVRO);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_LIVRO);
			preparedStmt.setString (1, livro.getNome());
			preparedStmt.setString (2, livro.getEditora());
			preparedStmt.setString (3, livro.getEdicao());
			preparedStmt.setString (4, livro.getArea());
			preparedStmt.setInt (5, livro.getId());
			preparedStmt.executeUpdate();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}

}
