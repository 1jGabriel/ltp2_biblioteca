<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.projeto.biblioteca.dao.BibliotecaDAO"%>
<%@page import="br.com.projeto.biblioteca.model.Biblioteca"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Editar Biblioteca</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» <a href="/projetoBiblioteca/listaBibliotecas.jsp"
				style="color: white;">Bibliotecas</a> »» Editar Biblioteca
		</h1>
	</div>
	<div class="div-action">
		<a href="/projetoBiblioteca/home.jsp">• Cancelar</a>
		&nbsp;&nbsp;&nbsp;

	</div>

	<form action="Update" method="post">
		<div align="center">
			<table border="5" cellpadding="10"
				style="margin-bottom: 3%; border-color: cadetblue;">

				<h2
					style="background-color: cadetblue; margin-bottom: auto; color: #ffffff">Biblioteca</h2>			

				<%
					Object idBibliotecaEditar = session.getAttribute("idBibliotecaEditar");
					Biblioteca biblioteca = new BibliotecaDAO().consultar(new Integer(idBibliotecaEditar.toString()));
				%>
				
				<%
					request.setAttribute("biblioteca", biblioteca);
				%>
				
				<c:if test="${biblioteca != null}">
					<input type="hidden" name="bibliotecaId" value="<c:out value='${biblioteca.getId()}' />" />
				</c:if>

				<tr>
					<th style="width: 15em;">Nome: *</th>
					<td style="width: 80em;"><input type="text"
						name="nomeBiblioteca" style="width: 100%;"
						value="<c:out value='${biblioteca.getNome()}' />" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Salvar" /></td>
				</tr>

			</table>
		</div>
	</form>
</body>
</html>

