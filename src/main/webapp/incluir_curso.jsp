<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incluir Curso</title>
</head>
<body>
<a href="lista_curso.jsp"><input type="submit" value="Voltar"></a>
<jsp:include page="verificaSessao.jsp"></jsp:include>
<form method="post" action="IncluirCurso">
<label>Curso: </label>
<input type="text" name="nomecurso" placeholder="Digite o nome do curso" required/>
<input type="number" name="valorcurso" placeholder="Insira o valor" min="0.01" required /><br><br>
<input type="submit" value="Ok" />
<input type="reset" value="limpar" />
</form><br>
</body>
</html>