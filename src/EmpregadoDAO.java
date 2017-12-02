import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//Classe ou objeto de acesso a dados
//DAO (Data access object).
public class EmpregadoDAO {

	private Connection con;
	private Statement comando;

	//consulta
	private static final String CONSULTA_TODOS = 
			"SELECT * FROM Empregado";

	private static final String CONSULTAR_POR_ID = "SELECT * FROM Empregado where id = ?";
	//fim consulta


	//insert
	private static final String INSERIR= 
			" insert into empregado (nome, sobrenome, data_nascimento) values (?, ?, ?)";
	//fim insert

	//update
	private static final String UPDATE_NOME_PELO_ID= 
			"update empregado set nome = ? where id = ?";

	private static final String UPDATE_SOBRENOME_PELO_ID= 
			"update empregado set sobrenome = ? where id = ?";

	private static final String UPDATE_EMPREGADO_PELO_ID= 
			"update empregado set nome = ?, sobrenome = ?, data_nascimento = ? where id = ?";
	//fim update

	//delete
	private static final String DELETAR_NOME = "DELETE FROM Empregado where nome = ?";
	private static final String DELETAR_SOBRENOME = "DELETE FROM Empregado where sobrenome = ?";
	private static final String DELETAR_ID= "DELETE FROM Empregado where id = ?";
	//fim delete

	public void deletarPorNome (Empregado emp){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(DELETAR_NOME);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_NOME);

			preparedStmt.setString (1, emp.getNome());


			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}

	}

	public void deletarPorSobreNome (Empregado emp){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(DELETAR_SOBRENOME);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(DELETAR_SOBRENOME);

			preparedStmt.setString (1, emp.getSobreNome());


			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}

	}

	public void deletarPorId (int id){
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


	public void inserir (String nome, String sobrenome,String matricula){

	}
	public void inserir (Empregado emp)  {

		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(INSERIR);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(INSERIR);

			preparedStmt.setString (1, emp.getNome());
			preparedStmt.setString (2, emp.getSobreNome());
			preparedStmt.setDate   (3, emp.getDataNascimento());

			preparedStmt.execute();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}                              

	public void atualizarNome(Empregado emp, int id){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(UPDATE_NOME_PELO_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_NOME_PELO_ID);

			preparedStmt.setString (1, emp.getNome());
			preparedStmt.setInt(2, id);

			preparedStmt.executeUpdate();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}

	public void atualizarSobrenome (Empregado emp, int id){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(UPDATE_SOBRENOME_PELO_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_SOBRENOME_PELO_ID);

			preparedStmt.setString (1, emp.getSobreNome());
			preparedStmt.setInt(2, id);

			preparedStmt.executeUpdate();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}

	public void atualizarEmpregado (Empregado emp, int id){
		con = ConnectionFactory.getConnection(); 


		try {
			con.prepareStatement(UPDATE_EMPREGADO_PELO_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(UPDATE_EMPREGADO_PELO_ID);
			preparedStmt.setString (1, emp.getNome());
			preparedStmt.setString (2, emp.getSobreNome());
			preparedStmt.setDate (3, emp.getDataNascimento());
			preparedStmt.setInt(4, id);

			preparedStmt.executeUpdate();     

			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}

	public ArrayList<Empregado> consultar(int id) {
		con = ConnectionFactory.getConnection(); 
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();
		try {
			con.prepareStatement(CONSULTAR_POR_ID);
			java.sql.PreparedStatement preparedStmt = con.prepareStatement(CONSULTAR_POR_ID);

			preparedStmt.setInt(1, id);

			ResultSet resultado = preparedStmt.executeQuery();     
			while(resultado.next())
			{
				Empregado emp = new Empregado();
				emp.setId(resultado.getInt("id"));
				emp.setNome(resultado.getString("nome"));
				emp.setSobreNome(resultado.getString("sobrenome"));
				emp.setDataNascimento(resultado.getDate("data_nascimento"));
				empregados.add(emp);
			}
			con.close();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		return empregados;
	}

	public ArrayList<Empregado> consultar() {   
		//obter conex�o chamando a classe ConnectionFactory
		con = ConnectionFactory.getConnection(); 

		//criar a lista resultante da consulta a ser retornada.
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();

		try {
			//cria o comando.
			comando = con.createStatement();
			//executa a consulta

			ResultSet resultado = comando.executeQuery(CONSULTA_TODOS);

			//navega pelo resultado, montando objetos Empregado e 
			//acrescentando � lista.
			while(resultado.next())
			{
				Empregado emp = new Empregado();
				emp.setId(resultado.getInt("id"));
				emp.setNome(resultado.getString("nome"));
				emp.setSobreNome(resultado.getString("sobrenome"));
				emp.setDataNascimento(resultado.getDate("data_nascimento"));
				empregados.add(emp);
			}
			//fecha comando e conex�o.
			comando.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//retorna a lista de empregados.
		return empregados;
	}  
}
