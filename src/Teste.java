import java.sql.Date;
import java.util.ArrayList;

import dao.BibliotecaDAO;
import model.Biblioteca;

public class Teste {
private static Biblioteca empregado;
	public static void main(String[] args) {
		BibliotecaDAO bibDAO = new BibliotecaDAO();
		//dadosEmpregado();
		//bibDAO.inserir(empregado);

		
		ArrayList<Biblioteca> empregados = 
				bibDAO.consultar();
		

		imprimir(empregados);
	}

	public static void imprimir(ArrayList<?> lista){
		for (Object object : lista) {
			System.out.println(object.toString());
		}
	}
	
	public static void dadosEmpregado(){
		empregado = new Biblioteca();
		empregado.setNome("Saraiva");

	}
}
