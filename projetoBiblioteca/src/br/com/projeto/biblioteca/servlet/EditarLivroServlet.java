package br.com.projeto.biblioteca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.biblioteca.dao.LivroDAO;
import br.com.projeto.biblioteca.model.Livro;

@WebServlet(urlPatterns = { "/EditarLivro" })
public class EditarLivroServlet extends HttpServlet {

	private static final long serialVersionUID = -9169126319537685677L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			//String id = request.getParameter("id");
//			String nomeLivro =  request.getParameter("nomeLivro");
//			String edicao =  request.getParameter("edicao");
//			String editora =  request.getParameter("editora");
//			String area =  request.getParameter("area");
//			
//			Livro livro = new Livro();
//			livro.setArea(area);
//			livro.setEdicao(edicao);
//			livro.setEditora(editora);
//			livro.setNome(nomeLivro);
//			
//			new LivroDAO().updateLivro(livro);;

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
