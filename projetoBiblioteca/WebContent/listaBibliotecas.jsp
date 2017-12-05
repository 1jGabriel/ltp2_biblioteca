<%@page import="br.com.projeto.biblioteca.controller.BibliotecaController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projeto.biblioteca.dao.BibliotecaDAO"%>
<%@page import="br.com.projeto.biblioteca.model.Biblioteca"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Bibliotecas</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» Bibliotecas
		</h1>
	</div>
	<div class="div-action">
		<a href="/projetoBiblioteca/adicionarBiblioteca.jsp">• Adicionar
			biblioteca</a> &nbsp;&nbsp;&nbsp; <a href="/DeletarTodasBibliotecas">• Deletar todas</a>

	</div>
	<%-- </center> --%>
	<div align="center">
		<table border="5" cellpadding="10"
			style="margin-bottom: 3%; border-color: cadetblue;">

			<h2
				style="background-color: cadetblue; margin-bottom: auto; color: #ffffff">Bibliotecas</h2>

			<tr>
				<th style="width: 80em;">Nome</th>
				<th style="width: 10em;"></th>
			</tr>
			<%
				ArrayList<Biblioteca> listaBibliotecas = new BibliotecaController().listarTodasBibliotecas();
				for (Biblioteca biblioteca : listaBibliotecas) {
			%>
			<tr>
				<td><%=biblioteca.getNome()%></td>
				<td><%=biblioteca.getId()%></td>
				
				<%-- request.getSession().setAttribute("biblioteca", biblioteca); --%>
				<% request.setAttribute("biblioteca", biblioteca); %> 
				
				
				
				<td><a href="http://localhost:8080/projetoBiblioteca/EditarBiblioteca?id=${biblioteca.getId()}&nome=${biblioteca.getNome()}">Editar</a>
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="http://localhost:8080/projetoBiblioteca/DeletarBiblioteca?id=${biblioteca.getId()}" >Deletar</a></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>
</body>
</html>