<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle Financeiro Pessoal - Lista de Usuários</title>

<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

	<div class="container">

		

		<h1>Lista de Usuários</h1>

		<h3>${usuario.login }</h3>
		Email: ${usuario.email }, Saldo: ${usuario.saldo }

		<p>
		<form
			action="${pageContext.request.contextPath}/controller.do?op=logout"
			method="post">
			<button type="submit" class="btn btn-primary">Sair</button>
		</form>
		</p>
	</div>
	<%@ include file="../template/footer.html"%>
</body>
</html>