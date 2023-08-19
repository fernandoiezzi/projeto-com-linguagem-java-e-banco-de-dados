<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  page import="br.com.cursosja.controlecursoja.model.dao.CursoDao" %>
<%@  page import="br.com.cursosja.controlecursoja.model.entidade.Curso" %>
<%@  page import="br.com.cursosja.controlecursoja.model.dao.ProfessorDao" %>
<%@  page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>
<%@  page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inclusão de turma</title>
</head>
<body>
<a href="lista_turma.jsp"><input type="submit" value="Voltar"></a>
<jsp:include page="verificaSessao.jsp"></jsp:include>

<form method="post" action="IncluirTurma">
<label>Curso: </label>
<select name="curso" required> 
<%
CursoDao dao = new CursoDao();

List<Curso> lista = dao.listar("");
for(Curso c: lista){

%>
 <option value="<%= c.getId() %>"> <%= c.getNome() %> </option>

<% } %>
</select>

<label>Professor: </label>
<select name="professor" required>
<% 
ProfessorDao daop = new ProfessorDao();
List<Professor> listap = daop.listar("");
for (Professor p: listap){
%>
<option value="<%= p.getId() %>"><%= p.getNome() %>
</option>

<% } %>
</select>
<label>Data de Início: </label>
<input type="date" name="inicio" placeholder="Data de início" required />
<label>Data de término: </label>
<input type="date" name="fim" placeholder="Data fim" required />
<input type="submit" value="Gravar" />
</form>

</body>
</html>