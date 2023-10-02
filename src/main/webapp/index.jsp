<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de cadastro de Alunos</title>
</head>
<body>

<h1>Sistema de cadastro de Alunos</h1> <br>

<h2>Informe seu usuário e senha</h2>

<form action="LoginServlet"  method="post">
<br>
	Login: <input type="text" name="usuario" required>
	<br><br>
	Senha: <input type="password" name="senha" required>
	<br><br>
	<input type="submit" value="Efetuar Login">
	<br><br>
</form>

<%String erro = (String) request.getParameter("erro"); %>
<%if(erro!=null){ 
	if(erro.toString().equals("1")){
%>	<p>Usuário ou senha incorreta</p>
<%} if(erro.toString().equals("2"))  {%>
	<p>Sessão encerrada faça login novamente<p>

<%} } %>



</body>
</html>