<%@page import="br.com.projeto.biblioteca.controller.LivroController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projeto.biblioteca.dao.LivroDAO"%>
<%@page import="br.com.projeto.biblioteca.model.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Livros Por Editora</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» <a href="/projetoBiblioteca/listaLivros.jsp" style="color: white;">Livros</a>
			»» Listar Por Editora
		</h1>
	</div>
	<div class="div-action">
		<a> </a>

	</div>
	<%-- </center> --%>
	<div align="center">
		<table border="5" cellpadding="10"
			style="margin-bottom: 3%; border-color: cadetblue;">

			<h2
				style="background-color: cadetblue; margin-bottom: auto; color: #ffffff">Livros</h2>

			<tr>
				<th style="width: 40em;">Nome</th>
				<th style="width: 15em;">Editora</th>
				<th>Edição</th>
				<th style="width: 10em;">Área</th>
				<th style="width: 10em;"></th>
			</tr>
					
			<%
				Object listarPorEditora = session.getAttribute("listarPorEditora");
				ArrayList<Livro> listaLivros = new LivroController().listarPorEditora(listarPorEditora.toString());
				for (Livro listar : listaLivros) {
					System.out.println(listarPorEditora);
			%>

			
			<tr>
				<td><%=listar.getNome()%></td>
				<td><%=listar.getEditora()%></td>
				<td><%=listar.getEdicao()%></td>
				<td><%=listar.getArea()%></td>
				<%
					request.setAttribute("listar", listar);
				%>
				<td><a
					href="/projetoBiblioteca/EditarLivro?id=${listar.getId()}">Editar</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="/projetoBiblioteca/DeletarLivro?id=${listar.getId()}">Deletar</a></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>
</body>
</html>

