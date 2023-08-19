<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp"><input type="submit" value="Voltar"></a>
<form method="post" action="CadastrarUsuario">
<input type="text" name="nome" placeholder="Digite o seu nome" required>
<input type="text" name="login" placeholder="Digite o seu login" required>
<input type="password" name="senha" placeholder="Digite a sua senha" required>
<input type="submit" value="Cadastrar">
<input type="reset" value="limpar">
</form>
</body>
</html>