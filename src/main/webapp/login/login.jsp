<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cashflow - Login</title>

<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/style_cashflow/style_form.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">

		<div class="formulario">
			<h1>Login</h1>

			<c:if test="${not empty _msg}">
				<c:forEach var="_m" items="${_msg}">
					<div class="alert alert-danger">${_m}</div>
				</c:forEach>
			</c:if>

			<form class="form"
				action="${pageContext.request.contextPath}/controller.do?op=login"
				method="post">

				<div class="form-group">
					<label for="InputName">Login</label> <input type="text"
						name="login" class="form-control" id="exampleInputName" required
						autofocus value="${cookie['loginCookie'].value}"
						placeholder="O seu login de usuario." />
				</div>

				<div class="form-group">
					<label for="InputPassword1">Senha</label> <input type="password"
						name="senha" class="form-control" id="InputPassword"
						placeholder="Senha" />
				</div>

				<div class="checkbox">
					<label><input type="checkbox" value="sim" name="lembrar"
						id="lembrar"> Lembrar-me </label>
				</div>

				<div class="form-group" style="margin: 30px 10px;">
					<button class="btn btn-outline-dark" type="submit">Entrar</button>
				</div>
				
				<div class="form-group" style="margin: 30px 10px;">
					<a class="btn btn-outline-secondary"
						href="${pageContext.request.contextPath}/usuario/cadastro.jsp"
						role="button">Cadastrar-se</a>
				</div>

			</form>
		</div>
	</div>

</body>
</html>