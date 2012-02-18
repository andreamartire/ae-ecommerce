<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="home.htm">Home</a> > Spedizioni Disponibili
<hr></hr> 

<c:forEach var="TipoSpedizione" items="${spedizioni}">
	<div class="TipoSpedizione${TipoSpedizione.id}">
		<table style="width: 500px; padding: 5px">
			<tr>
				<td><b>Nome</b></td><td>${TipoSpedizione.nome}</td>
			</tr>
			<tr>
				<td><b>Prezzo</b></td><td>${TipoSpedizione.prezzoBase} euro</td>
			</tr>
			<tr>
				<td><b>Descrizione</b></td><td>${TipoSpedizione.descrizione}</td>
			</tr>
		</table>
	</div>
	<hr class="TipoSpedizione${TipoSpedizione.id}"/>
</c:forEach>
