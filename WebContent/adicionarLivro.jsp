<%@page import="br.com.projeto.biblioteca.dao.BibliotecaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projeto.biblioteca.controller.BibliotecaController"%>
<%@page import="br.com.projeto.biblioteca.model.Biblioteca"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Adicionar Livro</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>
	<div class="div-top">
		<h1 class="font">
			<a href="/projetoBiblioteca/home.jsp" style="color: white;">Home</a>
			»» <a href="/projetoBiblioteca/listaLivros.jsp" style="color: white;">Livros</a>
			»» Adicionar Livros
		</h1>
	</div>
	<div class="div-action">
		<a href="/projetoBiblioteca/home.jsp">• Cancelar</a>
		&nbsp;&nbsp;&nbsp;

	</div>

	<form action="Inserir" method="post">
		<div align="center">
			<table border="5" cellpadding="10"
				style="margin-bottom: 3%; border-color: cadetblue;">

				<h2
					style="background-color: cadetblue; margin-bottom: auto; color: #ffffff">Livro</h2>

				<tr>
					<th style="width: 15em;">Nome: *</th>
					<td style="width: 80em;"><input type="text" name="nomeLivro"
						style="width: 100%;" value="<c:out value='${book.title}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Editora: *</th>
					<td style="width: 80em;"><input type="text" name="editora"
						style="width: 100%;" value="<c:out value='${book.title}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Edição: *</th>
					<td style="width: 80em;"><input type="text" name="edicao"
						style="width: 100%;" value="<c:out value='${book.title}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Área: *</th>
					<td style="width: 80em;"><input type="text" name="area"
						style="width: 100%;" value="<c:out value='${book.title}' />" /></td>
				</tr>
				<tr>
					<th style="width: 15em;">Biblioteca: *</th>
					<td style="width: 80em;">
					<select name="biblioteca" style="width: 90em;" >
                        <%
                            List<Biblioteca> list = new BibliotecaController().listarTodasBibliotecas();
                            Biblioteca biblioteca;
                            for (Object obj : list){
                            	biblioteca = (Biblioteca)obj;
                            	 out.println("<option value= " + biblioteca.getId() + ">" + biblioteca.getNome() + "</option>");
                            }
                        %> 
                      </select>
					</td>				

					
				</tr> 

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Salvar" /></td>
				</tr>

			</table>
		</div>
	</form>

	<%--      
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert" method="post">
        </c:if>
        <table cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                        />
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Salvar" />
                </td>
            </tr>
        </table>
       <!--  </form> -->
    </div>   --%>
</body>
</html>