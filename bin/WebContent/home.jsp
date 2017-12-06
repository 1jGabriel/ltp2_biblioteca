<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link rel="StyleSheet" type="text/css" href="css/style.css"
	media="screen">
</head>
<body>
	<%-- <center> --%>

	<h2
		style="background-color: cadetblue; margin-bottom: auto; color: #ffffff; text-align: center">Seja
		Bem-Vindo!</h2>
	<h3
		style="background-color: cadetblue; margin-bottom: auto; color: #ffffff; margin-top: auto; text-align: center">Navegue
		pela nossa aplicação</h3>

	<div style="display: flex;" align="center">
		<div class="div-home">
			<div style="padding-top: 15%;">
				<a href="/projetoBiblioteca/listaBibliotecas.jsp" style="color:#ffffff">Bibliotecas</a>
			</div>
		</div>
		<div class="div-home">
			<div style="padding-top: 15%;">
				<a href="/projetoBiblioteca/listaLivros.jsp" style="color:#ffffff">Livros</a>
			</div>
		</div>
	</div>
</body>
</html>
</body>
</html>