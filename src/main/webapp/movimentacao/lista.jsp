<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Descrição</th>
			<th scope="col">Valor (R$)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="mov" items="${usuario.movimentacoes}">
			<tr>
				<th scope="row"></th>
				<td>${mov.descricao}</td>
				<td>${mov.valor}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
