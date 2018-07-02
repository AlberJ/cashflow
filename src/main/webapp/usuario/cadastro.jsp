<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Controle Financeiro Pessoal - Cadastro de Usuário</title>

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
			<h1>Cadastro de Usuário</h1>

			<c:if test="${not empty _msg}">
				<c:forEach var="_m" items="${_msg}">
					<div class="alert alert-danger">${_m}</div>
				</c:forEach>
			</c:if>

			<form class="form"
				action="${pageContext.request.contextPath}/controller.do?op=cadusu"
				method="post">

				<div class="form-group">
					<label for="InputEmail1">Email</label> <input type="email"
						name="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Seu email para contato." />
					<small id="emailHelp" class="form-text text-muted">We'll
						never share your email with anyone else.</small>
				</div>

				<div class="form-group">
					<label for="InputName">Login</label> <input type="text"
						name="login" class="form-control" id="exampleInputName"
						aria-describedby="NameHelp" placeholder="Seu login de usuario." />
				</div>

				<div class="form-group">
					<label for="InputPassword1">Senha</label> <input type="password"
						name="senha" class="form-control" id="exampleInputPassword1"
						placeholder="Senha" />
				</div>

				<div class="form-group" style="margin: 30px 10px;">
					<button class="btn btn-outline-dark" type="submit">Cadastrar</button>
				</div>
				
				<div class="form-group" style="margin: 30px 10px;">
					<a class="btn btn-outline-secondary"
						href="${pageContext.request.contextPath}/login/login.jsp"
						role="button">Ir para Login</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>