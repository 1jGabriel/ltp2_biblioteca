<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Editar Livro</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» <a href="/projetoBiblioteca/listaLivros.jsp"
				style="color: white;">Livros</a> »» Editar Livros
		</h1>
	</div>
	<div class="div-action">
		<a href="/projetoBiblioteca/home.jsp">• Cancelar</a>
		&nbsp;&nbsp;&nbsp;

	</div>

	<form action="EditarLivro" method="post">
		<div align="center">
			<table border="5" cellpadding="10"
				style="margin-bottom: 3%; border-color: cadetblue;">

				<h2
					style="background-color: cadetblue; margin-bottom: auto; color: #ffffff">Livro</h2>

				<c:if test="${livro != null}">
					<input type="hidden" name="id" value="<c:out value='${livro.getId()}' />" />
				</c:if>

				<tr>
					<th style="width: 15em;">Nome: *</th>
					<td style="width: 80em;"><input type="text" name="nomeLivro"
						style="width: 100%;" value="<c:out value='${livro.getNome()}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Editora: *</th>
					<td style="width: 80em;"><input type="text" name="editora"
						style="width: 100%;" value="<c:out value='${livro.getEditora()}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Edição: *</th>
					<td style="width: 80em;"><input type="text" name="edicao"
						style="width: 100%;" value="<c:out value='${livro.getEdicao()}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Área: *</th>
					<td style="width: 80em;"><input type="text" name="area"
						style="width: 100%;" value="<c:out value='${livro.getArea()}' />" /></td>
				</tr>
				<%-- <tr>
					<th style="width: 15em;">Biblioteca: *</th>
					<td style="width: 80em;"><input type="text" name="biblioteca"
						style="width: 100%;" value="<c:out value='${book.title}' />" />
					</td>

					<%
						ArrayList<Biblioteca> bibliotecas = new BibliotecaDAO().consultar();
						for (int i = 0; i < bibliotecas.size(); i++) {
							Biblioteca linhaLocal = bibliotecas.get(i);
					%>
					<select name="biblioteca">
						<option value=<%=linhaLocal.getId()%>>
							<%=linhaLocal.getNome()%>
						</option>
					</select>
					<%
						} //fecha for
					%>
				</tr> --%>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Salvar" /></td>
				</tr>

			</table>
		</div>
	</form>
</body>
</html>

