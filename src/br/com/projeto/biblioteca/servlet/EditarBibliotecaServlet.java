package br.com.projeto.biblioteca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.biblioteca.dao.BibliotecaDAO;
import br.com.projeto.biblioteca.model.Biblioteca;

@WebServlet(urlPatterns = { "/EditarBiblioteca" })
public class EditarBibliotecaServlet extends HttpServlet {

	private static final long serialVersionUID = -9169126319537685677L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*String nomeBiblioteca =  request.getParameter("nome");
			int id = Integer.parseInt(request.getParameter("id"));	
			
			Biblioteca biblioteca = new Biblioteca();			
			biblioteca.setNome(nomeBiblioteca);
			biblioteca.setId(id);
			
			new BibliotecaDAO().updateBiblioteca(biblioteca);*/

			//response.sendRedirect("/projetoBiblioteca/sucesso.jsp");

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