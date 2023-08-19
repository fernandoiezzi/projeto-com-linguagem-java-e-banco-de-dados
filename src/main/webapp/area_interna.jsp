<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Área Interna</title>
</head>
<body>
<jsp:include page="verificaSessao.jsp"></jsp:include>
<%
Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
%>
<h1>Bem-Vindo <%= usuario.getNome() %></h1>
<ul>
<li><a href="lista_professor.jsp">Professores</a>
<li><a href="incluir_turma.jsp">Incluir Turma</a>
<li><a href="lista_turma.jsp">Listar turma</a>
<li><a href="lista_curso.jsp">Cursos</a>
<li><a href="lista_turma.jsp">Turmas</a>
</ul>
<a href="LogoutServlet">Sair</a>
</body>
</html>