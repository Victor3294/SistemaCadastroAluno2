<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>
<% String usuario = (String) session.getAttribute("usuario"); %>
<% if(usuario == null) {
	response.sendRedirect("index.jsp?erro=2");
}%> 
<% Aluno aluno = (Aluno) request.getAttribute("aluno"); %>


<h2>Alterar Aluno:</h2>

<form action="ConfirmarAlteracaoServlet" method="post">

<input type="hidden" name="id" value="<%=aluno.getId() %>">
<input type="hidden" name="matricula" value="<%=aluno.getMatricula() %>">

Nome:
<input type="text" name="nome" value="<%=aluno.getNome() %>">
<br><br>

Idade:
<input type="number" name="idade" value="<%=aluno.getIdade() %>">
<br><br>

Semestre:
<select name="semestre">
	<option value="Primeiro" <%=aluno.getSemestre().equals("Primeiro")  ? "selected" : ""%>>Primeiro</option>   
	<option value="Segundo" <%=aluno.getSemestre().equals("Segundo")  ? "selected" : ""%>>Segundo</option>   
</select>
<br><br>


Genero:<br>
<input type="radio" name="genero" value="masculino" <%=aluno.getGenero().equals("Masculino") ? "checked": "" %> required >
Masculino<br>
<input type="radio" name="genero" value="feminino" <%=aluno.getGenero().equals("Feminino") ? "checked": "" %> required>
Feminino
<br><br>


<input type="submit" value="Confirmar Alteração">
<a href="ListarServlet">Voltar</a>
</form>





</body>
</html>