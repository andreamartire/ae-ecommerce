<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		color: #ffffff;
	}
	
	#carrelloTable tr.alt td {
		color: #000000;
		background-color: #EAF2D3;
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
	<c:set var="totale" value="0" />
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
		<c:set var="totale" value="${totale + elementoCarrello.prodotto.prezzoUnitario * elementoCarrello.quantita}" />
	</c:forEach>
	</tbody>
		<tfoot>
		<tr>
			<td colspan='5'>Totale carrello: <b>${totale}</b></td>
		</tr>
	</tfoot>
</table>

