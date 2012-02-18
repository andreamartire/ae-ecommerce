<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="home.htm">Home</a> > Modalita' di pagamento Disponibili
<hr></hr> 

<c:forEach var="ModalitaPagamento" items="${pagamenti}">
	<div class="ModalitaPagamento${ModalitaPagamento.id}">
		<table style="width: 500px; padding: 5px">
			<tr>
				<td><b>Nome</b></td><td>${ModalitaPagamento.nome}</td>
			</tr>
			<tr>
				<td><b>Commissioni</b></td><td>${ModalitaPagamento.commissioni} euro</td>
			</tr>
			<tr>
				<td><b>Descrizione</b></td><td>${ModalitaPagamento.descrizione}</td>
			</tr>
		</table>
	</div>
	<hr class="ModalitaPagamento${ModalitaPagamento.id}"/>
</c:forEach>
