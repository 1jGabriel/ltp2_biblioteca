package br.com.projeto.biblioteca.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.biblioteca.dao.BibliotecaDAO;
import br.com.projeto.biblioteca.dao.LivroDAO;
import br.com.projeto.biblioteca.model.Livro;

@WebServlet(urlPatterns = { "/VisualizarLivros" })
public class VisualizarLivrosServlet extends HttpServlet {
	
	private ArrayList<Livro> livros;
	private String id;

	private static final long serialVersionUID = -9169126319537685677L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			id = request.getParameter("id");
			
			livros = new LivroDAO().consultarLivrosPorBiblioteca(new Integer(id));
			request.getSession().setAttribute("idBiblioteca", id);

			response.sendRedirect("/projetoBiblioteca/livrosPorBiblioteca.jsp");

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
