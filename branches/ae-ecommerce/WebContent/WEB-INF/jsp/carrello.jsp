<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				alert("Quantita' aggiornata");
				location.reload();
			}
		});
	}
	
	function aggiornaTotale() {
		var totaleCarrello = parseFloat($('#totaleCarrello').text());
		var spedID = $("input[name='spedizione']:checked").val();
		var costoSpedizione = parseFloat($("#"+spedID).text());
		var pagID = $("input[name='pagamento']:checked").val();
		var costoPagamento = parseFloat($("#"+pagID).text());
		var totale = totaleCarrello + costoPagamento + costoSpedizione;
		$('#totale').text(totale);
	}
	
	function ordina() {
		$('#idSpedizione').val($("input[name='spedizione']:checked").val());
		$('#idPagamento').val($("input[name='pagamento']:checked").val());
		$('#pesoTotale').val($("#pesoTot").text());
		$('#totaleDaPagare').val($('#totale').text());
		$('#ordineForm').submit();
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
	<c:forEach var="elementoCarrello" items="${carrelloList}">
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
			<td colspan='5'>Peso Totale: <span id="pesoTot">${pesoTotale}</span>Kg - Totale carrello: <b id='totaleCarrello'>${totaleCarrello} &euro;</b></td>
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
				<input type="radio" checked="checked" name="spedizione" value="${spedizione.id}"/>
			</td>
			<td><b>${spedizione.nome}</b></td>
			<td id="${spedizione.id}">${spedizione.prezzoBase}</td>
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
				<input type="radio" checked="checked" name="pagamento" value="${pagamento.id}"/>
			</td>
			<td><b>${pagamento.nome}</b></td>
			<td id="${pagamento.id}">${pagamento.commissioni}</td>
		</tr>
	</c:forEach>
</table>

<div id='totaleDiv'>
	Totale: <b><span id='totale'></span> &euro;</b>
</div>

<div style="text-align: center; margin: 30px; width: 540px">
	<button onclick='ordina()'>Ordina</button>
</div>

<div style="display: none">
	<form action="ordine.htm" method="post" id="ordineForm">
		<input type="hidden" id="idSpedizione" name="idSpedizione"/>
		<input type="hidden" id="idPagamento" name="idPagamento"/>
		<input type="hidden" id="totaleDaPagare" name="totaleDaPagare"/>
		<input type="hidden" id="pesoTotale" name="pesoTotale"/>
	</form>
</div>