import java.sql.Date;
import java.util.ArrayList;

import controller.BibliotecaController;
import controller.BibliotecaLivroController;
import controller.LivroController;
import dao.BibliotecaDAO;
import model.Biblioteca;
import model.BibliotecaLivro;
import model.Livro;

public class Teste {
private static Biblioteca biblioteca;
private static Biblioteca biblioteca2;
private static BibliotecaLivro bl;
private static Livro livro;
private static LivroController lc = new LivroController();
private static BibliotecaController bc = new BibliotecaController();
private static BibliotecaLivroController blc = new BibliotecaLivroController();

public static void main(String[] args) {
	bc = new BibliotecaController();
	ArrayList<Livro> livros = new  ArrayList<Livro>();
	dadosBiblioteca();
	dadosLivros();
	
	//blc.inserirLivro(livro, biblioteca);
	//blc.deletarBiblioteca(biblioteca);
	//blc.deletarLivro(livro, biblioteca);
	//livros = lc.listarLivrosPorBiblioteca(biblioteca);
	//imprimir(livros);
		//lc.inserirLivro(livro);
		//lc.updateLivro(livro);
		//lc.deletarLivro(livro);
		//lc.listarTodasLivros();
		//bc.inserirBiblioteca(biblioteca);
		//bc.listarTodasBibliotecas();
		//bc.updateBiblioteca(biblioteca2);
		//bc.deletarBiblioteca(biblioteca2);
	}

	public static void imprimir(ArrayList<?> lista){
		for (Object object : lista) {
			System.out.println(object.toString());
		}
	}
	
	public static void dadosBiblioteca(){
		biblioteca = new Biblioteca();
		biblioteca.setNome("Bib 2");
		biblioteca.setId(3);
		
		/*biblioteca2 = new Biblioteca();
		biblioteca2.setId(2);
		biblioteca2.setNome("Cultura");*/

	}
	
	public static void dadosLivros(){
		livro= new Livro(4 ,"update", "update", "update", "update");
		
	}
	
	public void dadosBLC(Biblioteca bib, Livro liv){
		bl = new BibliotecaLivro();
		bl.setBiblioteca(bib.getId());
		bl.setLivro(liv.getId());
		
	}
}
