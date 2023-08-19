<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionando professor</title>
</head>
<body>
<a href="lista_professor.jsp"><input type="submit" value="Voltar"></a>
<jsp:include page="verificaSessao.jsp"></jsp:include>
<form method="post" action="IncluirProfessor">
<label>Professor:</label>
<input type="text" name="nomeprofessor" placeholder="Digite o nome do professor" required/>
<input type="text" name="celular" placeholder="Insira o telefone celular" required />
<input type="number" name="valorhora" placeholder="Insira o valor da hora" min="0.01" required /><br><br>
<input type="submit" value="Ok" />
<input type="reset" value="limpar" />
</form>
</body>
</html>