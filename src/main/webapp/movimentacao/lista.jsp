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
	<c:import url="../template/navbar.jsp" />

	<div class="container">
		<h4 style="text-align: center; margin: 20px 0;">Movimentações</h4>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Descrição</th>
					<th scope="col">Valor (R$)</th>
					<th scope="col" >Editar</th>
					<th scope="col" >Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mov" items="${movimentacoes}">
					<tr>
						<th scope="row"></th>
						<td>${mov.descricao}</td>
						<td>${mov.valor}</td>
<td scope="col" ><a href="${pageContext.request.contextPath}/controller.do?op=edtmov">
									<img
							src="${pageContext.request.contextPath}/template/imagens/open-iconic-master/png/pencil-2x.png">
					</a></td>
<td scope="col"><a href="${pageContext.request.contextPath}/controller.do?op=delmov">
									<img
							src="${pageContext.request.contextPath}/template/imagens/open-iconic-master/png/trash-2x.png">
					</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="../template/footer.html" />

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

