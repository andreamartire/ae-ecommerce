<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<a href="home.htm">Home</a> &gt; I miei ordini
<hr/>

<h3>Storico ordini - ${user}</h3>

<table id="ordiniTable">
	<thead>
		<tr>
			<td>#</td>
			<td>Data</td>
			<td>Totale</td>
			<td>Spedizione</td>
			<td>Stato</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="ordine" items="${listOrdini}">
		<tr>
			<td>${ordine.id}</td>
			<td>${ordine.data}</td>
			<td>${ordine.totaleDaPagare}</td>
			<td>${ordine.tipoSpedizione}</td>
			<td>${ordine.stato}</td>
			<td><a href="dettagliOrdine.htm?idOrdine=${ordine.id}">Dettagli</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>