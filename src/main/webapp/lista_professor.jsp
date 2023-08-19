<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  page import="br.com.cursosja.controlecursoja.model.dao.ProfessorDao" %>
<%@  page import="br.com.cursosja.controlecursoja.model.entidade.Professor" %>
<%@  page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de professores</title>
</head>
<body>
<a href="area_interna.jsp"><input type="submit" value="Voltar"></a>
<h1>Lista de professores</h1>

<jsp:include page="verificaSessao.jsp"></jsp:include>
<a href="incluir_professor.jsp"><input type="submit" value="Incluir Professor"></a>
<%
 String nomepBuscar = "";
if(request.getParameter("nomepBuscar") != null){
nomepBuscar = request.getParameter("nomepBuscar");	
}
%>

<form method="post" action="lista_professor.jsp">
<input type="text" name="nomepBuscar" value="<%= nomepBuscar %>" />
<input type="submit" value="Buscar"/>
<input type="reset" value="Limpar" />
</form>
 <table>
 <thead>
 <tr>
 <th>Nome do professor</th>
 <th>Celular</th>
 <th>Valor da hora</th>
 <th>Manipulação</th>
 </tr>
 </thead>
 <tbody>
 <%
 ProfessorDao daop = new ProfessorDao();
 List <Professor> professores = daop.listar(nomepBuscar);
 DecimalFormat fmt = new DecimalFormat("###,##0.00");
 for (Professor p: professores) {%>
 <tr>
 <td> <%= p.getNome() %> </td>
 <td> <%= p.getCelular() %> </td>
 <td> <%= fmt.format(p.getValorHora()) %> </td>
 <td><a href="IniciarAlterarProfessor?id=<%= p.getId()%>"><input type="submit" value="Alterar"></a> 
 <a href="ExcluirProfessor?id=<%= p.getId() %>" onclick="return confirm('Deseja excluir este professor?')"><input type="submit" value="Excluir"></a></td>
 </tr>
 <% } %>
 </tbody>
 </table>
</body>
</html>