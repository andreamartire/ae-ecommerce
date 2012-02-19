<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Riepilogo Ordine</h3>

<table id='spedTable'>
	<thead>
		<tr>
			<td width="350">Prodotto</td>
			<td>Prezzo</td>
			<td>Quantita'</td>
			<td>Totale</td>
		</tr>
	</thead>
	<tbody>
	<c:set var="totaleCarrello" value="0" />
	<c:set var="pesoTotale" value="0" />
	<c:forEach var="elementoCarrello" items="${carrelloList}">
		<tr>
			<td><b>${elementoCarrello.prodotto.nome}</b></td>
			<td align="center"><b>${elementoCarrello.prodotto.prezzoUnitario}</b></td>
			<td align="center">${elementoCarrello.quantita}</td>
			<td align="center"><b>${elementoCarrello.prodotto.prezzoUnitario * elementoCarrello.quantita}</b></td>
		</tr>
		<c:set var="totaleCarrello" value="${totaleCarrello + elementoCarrello.prodotto.prezzoUnitario * elementoCarrello.quantita}" />
		<c:set var="pesoTotale" value="${pesoTotale + elementoCarrello.prodotto.pesoApprossimato * elementoCarrello.quantita}" />
	</c:forEach>
	
	<tr>
		<td><b>${ordine.tipoSpedizione.nome}</b></td>
		<td align="center"><b>${ordine.tipoSpedizione.prezzoBase}</b></td>
		<td align="center">1</td>
		<td align="center"><b>${ordine.tipoSpedizione.prezzoBase}</b></td>
	</tr>
	<c:set var="totaleCarrello" value="${totaleCarrello + ordine.tipoSpedizione.prezzoBase}" />
	
	<tr>
		<td><b>${ordine.modalitaPagamento.nome}</b></td>
		<td align="center"><b>${ordine.modalitaPagamento.commissioni}</b></td>
		<td align="center">1</td>
		<td align="center"><b>${ordine.modalitaPagamento.commissioni}</b></td>
	</tr>
	<c:set var="totaleCarrello" value="${totaleCarrello + ordine.modalitaPagamento.commissioni}" />
	
	</tbody>
	<tfoot>
		<tr>
			<td colspan='4'>Peso Totale: <span id="pesoTot">${pesoTotale}</span>Kg - Totale carrello: <b id='totaleCarrello'>${totaleCarrello} &euro;</b></td>
		</tr>
	</tfoot>
</table>

<h3>Spedizione all'indirizzo:</h3>
<div style="margin: 10px; font-size: 14pt">
	${ordine.destinazione.destinatario}<br/>
	${ordine.destinazione.via} ${ordine.destinazione.numero}<br/>
	${ordine.destinazione.cap} ${ordine.destinazione.citta} ${ordine.destinazione.provincia}
</div>

<div style="text-align: center;">
	<a href="concludiOrdine.htm">
		<button style="font-size: 14pt; font-weight: bold;">Conferma Ordine</button>
	</a>
</div>
