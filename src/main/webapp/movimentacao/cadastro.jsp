<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nova Movimentação</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/style_cashflow/style_form.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="../template/navbar.jsp" />
	<div class="container">
		<div class="formulario">
			<h1>Movimentação</h1>

			<c:if test="${not empty _msg}">
				<c:forEach var="_m" items="${_msg}">
					<div class="alert alert-danger">${_m}</div>
				</c:forEach>
			</c:if>

			<form class="form-group"
				action="${pageContext.request.contextPath}/controller.do?op=cadmov"
				method="post">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Descrição</span>
						</div>
						<textarea class="form-control" aria-label="With textarea"
							placeholder="Breve descrição da movimentação monetária."
							name="descricao" id="descricao"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">Valor
								da movimentação</span> <span class="input-group-text">R$</span>
						</div>
						<input type="text" class="form-control" aria-label="Default"
							placeholder="00.00" name="valor" id="valor">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="inputGroupSelect01">Tipo
								de movimentação</label>
						</div>
						<select class="custom-select" id="operacao" name="operacao">
							<option selected>Selecione</option>
							<option value="en">Entrada</option>
							<option value="sa">Saída</option>
						</select>
					</div>
				</div>
				<div class="form-group" style="margin: 30px 20px 0px;">
					<button type="submit" class="btn btn-outline-dark">Salvar</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>