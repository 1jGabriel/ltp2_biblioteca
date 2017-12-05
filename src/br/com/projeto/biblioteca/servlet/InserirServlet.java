package br.com.projeto.biblioteca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.biblioteca.dao.BibliotecaDAO;
import br.com.projeto.biblioteca.dao.LivroDAO;
import br.com.projeto.biblioteca.model.Biblioteca;
import br.com.projeto.biblioteca.model.Livro;

@WebServlet(urlPatterns = { "/Inserir" })
public class InserirServlet extends HttpServlet {

	private static final long serialVersionUID = -9169126319537685677L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomeBiblioteca = request.getParameter("nomeBiblioteca");
			String nomeLivro = request.getParameter("nomeLivro");
			String editora = request.getParameter("editora");
			String edicao = request.getParameter("edicao");
			String area = request.getParameter("area");

			if (nomeBiblioteca != null) {
				Biblioteca biblioteca = new Biblioteca();
				biblioteca.setNome(nomeBiblioteca);

				new BibliotecaDAO().inserir(biblioteca);

			} else {
				Livro livro = new Livro();
				livro.setArea(area);
				livro.setEdicao(edicao);
				livro.setEditora(editora);
				livro.setNome(nomeLivro);

				new LivroDAO().inserirLivro(livro);				
			}
			
			response.sendRedirect("/projetoBiblioteca/sucesso.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/projetoBiblioteca/erro.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
