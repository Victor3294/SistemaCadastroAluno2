<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado da pesquisa</title>
</head>
<body>
<% String usuario = (String) session.getAttribute("usuario"); %>
<% if(usuario == null) {
	response.sendRedirect("index.jsp?erro=2");
}%> 

Clique <a href="cadastrarAluno.jsp">aqui</a> para cadastrar um novo aluno

<form action="PesquisarMatriculaNomeServlet" method="post">
	Pesquisar por:
	<input type="radio" name="meio" value="Matricula" required>
	Matricula
	<input type="radio" name="meio" value="Nome" required>
	Nome
	<br><br>
	<input type="text" name="pesquisa" required>
	<input type="submit" value="Pesquisar">
</form>

<%List<Aluno> listaAlunosSelecionados = (List<Aluno>) request.getAttribute("listaAlunosSelecionados");  %>

<% if (listaAlunosSelecionados == null) { %>
		<h3>Nenhum aluno cadastrado</h3>
<% } else { %>
		<h2>Alunos Procurados</h2>
		<table border="1">
			<tr>
				<th>Detalhar</th>
				<th>Nome</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Semestre</th>
				<th>Matricula</th>
				<th>Excluir</th>
			</tr>
			<% for (Aluno aluno : listaAlunosSelecionados) { %>
			<tr>
				<td><a href="DetalharServlet?id=<%=aluno.getId()%>">Detalhar</a></td>
				<td><%=aluno.getNome()%> </td>
				<td><%=aluno.getIdade()%> </td>
				<td><%=aluno.getGenero()%> </td>
				<td><%=aluno.getSemestre()%> </td>
				<td><%=aluno.getMatricula() %></td>
				<td><a href="ExcluirServlet?id=<%=aluno.getId()%>">Excluir</a></td>
			</tr>
			<% } %>
		</table>
<% } %>
<a href="ListarServlet">Voltar para a lista</a>
</body>
</html>