<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<style type="text/css">
	#carrelloTable {
		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		width: 600px;
		border-spacing: 5px;
	}
	
	#carrelloTable td {
		font-size: 1em;
		border: 1px solid green;
		padding: 3px 7px 2px 7px;
	}
	
	#carrelloTable tfoot {
		background-color: orange;
		text-align: right;
	}
	
	#carrelloTable thead {
		font-size: 10pt;
		text-align: center;
		padding-top: 5px;
		padding-bottom: 4px;
		background-color: orange;
		color: black;
	}
	

	#spedTable {
		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		width: 600px;
		border-spacing: 0px 5px;
	}
	
	#spedTable td {
		font-size: 1em;
		border: 1px solid #6699FF;
		padding: 3px 7px 2px 7px;
	}
	
	#spedTable tfoot {
		background-color: #66FFFF;
		text-align: right;
	}
	
	#spedTable thead {
		font-size: 10pt;
		font-weight: bold;
		text-align: center;
		padding-top: 5px;
		padding-bottom: 4px;
		background-color: #D1F0FF;
		color: #3366CC;
	}
	
	
	#totaleDiv {
		width: 600px;
		font-size: 14pt;
		font-weight: bold;
		text-align: center;
		padding-top: 5px;
		padding-bottom: 5px;
		color: white;
		background-color: #FF9900;
	}
</style>

<script type="text/javascript">
	function elimina(elementoCarrello) {
		$.ajax({
			url : 'delFromCart.htm',
			type: "POST",
			data : ({
				elementoCarrello : elementoCarrello
			}),
			success : function(res) {
				alert("Elemento rimosso");
				location.reload();
			}
		});
	}
	
	function aggiorna(elementoCarrello) {
		$.ajax({
			url : 'updateCart.htm',
			type: "POST",
			data : ({
				elementoCarrello : elementoCarrello,
				qnt : $('#quantita'+elementoCarrello).val()
			}),
			success : function(res) {
				alert("Quantita' aggironata");
				location.reload();
			}
		});
	}
	
	function aggiornaTotale() {
		var totaleCarrello = parseFloat($('#totaleCarrello').text());
		var costoSpedizione = parseFloat($("input[name='spedizione']:checked").val());
		var costoPagamento = parseFloat($("input[name='pagamento']:checked").val());
		var totale = totaleCarrello + costoPagamento + costoSpedizione;
		$('#totale').text(totale);
	}
	
	$(document).ready( function() {
		
		aggiornaTotale();
		
		$("input").click( function(event) {
			aggiornaTotale();
		});
	});

</script>

<h3>Carrello della spesa</h3>

<table id='carrelloTable'>
	<thead>
		<tr>
			<td width="250">Prodotto</td>
			<td>Prezzo</td>
			<td>Quantita'</td>
			<td>Totale</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:set var="totaleCarrello" value="0" />
	<c:set var="pesoTotale" value="0" />
	<c:forEach var="elementoCarrello" items="${carrello}">
		<tr>
			<td><a href="prodotti?id=${elementoCarrello.prodotto.id}"><b>${elementoCarrello.prodotto.nome}</b></a></td>
			<td align="center"><b>${elementoCarrello.prodotto.prezzoUnitario}</b></td>
			<td align="center"><input id="quantita${elementoCarrello.id}" type="number" style="width: 30px" value="${elementoCarrello.quantita}"/>
			<td align="center"><b>${elementoCarrello.prodotto.prezzoUnitario * elementoCarrello.quantita}</b></td>
			<td>
				<button onclick="aggiorna(${elementoCarrello.id})"><img src="resources/images/refresh.png" /></button>
				<button onclick="elimina(${elementoCarrello.id})"><img src="resources/images/delete.png" /></button>
			</td>
		</tr>
		<c:set var="totaleCarrello" value="${totaleCarrello + elementoCarrello.prodotto.prezzoUnitario * elementoCarrello.quantita}" />
		<c:set var="pesoTotale" value="${pesoTotale + elementoCarrello.prodotto.pesoApprossimato * elementoCarrello.quantita}" />
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan='5'>Peso Totale: ${pesoTotale}Kg - Totale carrello: <b id='totaleCarrello'>${totaleCarrello} &euro;</b></td>
		</tr>
	</tfoot>
</table>

<table id='spedTable'>
	<thead>
		<tr>
			<td>Seleziona</td>
			<td width="450">Tipo di Spedizione</td>
			<td>Costo</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="spedizione" items="${spedizioni}">
		<tr>
			<td align="center">
				<input type="radio" checked="checked" name="spedizione" value="${spedizione.prezzoBase}"/>
			</td>
			<td><b>${spedizione.nome}</b></td>
			<td>${spedizione.prezzoBase}</td>
		</tr>
	</c:forEach>
</table>

<table id='spedTable'>
	<thead>
		<tr>
			<td>Seleziona</td>
			<td width="450">Tipo di Pagamento</td>
			<td>Costo</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="pagamento" items="${pagamenti}">
		<tr>
			<td align="center">
				<input type="radio" checked="checked" name="pagamento" value="${pagamento.commissioni}"/>
			</td>
			<td><b>${pagamento.nome}</b></td>
			<td>${pagamento.commissioni}</td>
		</tr>
	</c:forEach>
</table>

<div id='totaleDiv'>
	Totale: <b><span id='totale'></span> &euro;</b>
</div>
