import java.sql.Date;
import java.util.ArrayList;

public class Teste {
private static Empregado empregado;
	public static void main(String[] args) {
		EmpregadoDAO empDAO = new EmpregadoDAO();
		//dadosEmpregado();
		//empDAO.inserir(empregado);
		//empDAO.atualizarEmpregado(empregado, 5);
		//empDAO.atualizarNome(empregado, 5);
		//empDAO.atualizarSobrenome(empregado, 5);
		//empDAO.deletarPorNome(empregado);
		//empDAO.deletarPorSobreNome(empregado);
		//empDAO.deletarPorId(8);
		
		ArrayList<Empregado> empregados = 
				empDAO.consultar();
		

		imprimir(empregados);
	}

	public static void imprimir(ArrayList<?> lista){
		for (Object object : lista) {
			System.out.println(object);
		}
	}
	
	public static void dadosEmpregado(){
		empregado = new Empregado();
		empregado.setNome("id 5");
		empregado.setSobreNome("edilton");
		empregado.setDataNascimento(Date.valueOf("1847-03-14"));
	}
}
