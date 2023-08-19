<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursosja.controlecursoja.model.entidade.Curso" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição campos</title>
</head>
<body>
<a href="lista_curso.jsp"><input type="submit" value="Voltar"></a>
<jsp:include page="verificaSessao.jsp"></jsp:include>
<%
Curso curso = (Curso) request.getAttribute("curso");

%>
 <form method="post" action="AlterarCurso">
 <h1>Curso: </h1>
 <input type="hidden" name="id" value="<%= curso.getId()%>" required />
 <input type="text" name="nome" value="<%= curso.getNome() %>" required />
 <input type="number" name="valorcurso" step ="0.01" value="<%= curso.getValor() %>"/>

 <input type="submit" value="Editar" />
 <input type="reset" value="Limpar" />
 
 </form>
</body>
</html>