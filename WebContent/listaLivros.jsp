<%@page import="br.com.projeto.biblioteca.controller.LivroController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projeto.biblioteca.dao.LivroDAO"%>
<%@page import="br.com.projeto.biblioteca.model.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Livros</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» Livros
		</h1>
	</div>
	<div class="div-action">
		<a href="/projetoBiblioteca/adicionarLivro.jsp">• Adicionar Livro</a>
		&nbsp;&nbsp;&nbsp; <a href="/projetoBiblioteca/DeletarTodosLivros">•
			Deletar todos</a>

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
				ArrayList<Livro> listaLivros = new LivroController().listarTodasLivros();
				for (Livro livro : listaLivros) {
			%>
			<tr>
				<td><%=livro.getNome()%></td>
				<td><%=livro.getEditora()%></td>
				<td><%=livro.getEdicao()%></td>
				<td><%=livro.getArea()%></td>
				<% request.setAttribute("livro", livro); %>
				<td><a href="/projetoBiblioteca/EditarLivro?id=${livro.getId()}" >Editar</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="/projetoBiblioteca/DeletarLivro?id=${livro.getId()}" >Deletar</a></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>
</body>
</html>

