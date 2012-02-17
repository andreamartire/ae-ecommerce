<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function aggiungiACarrello(idProdotto) {
		var qnt = $('#quantita').val();
		
		$.ajax({
			url : 'addToCart.htm',
			type: "POST",
			data : ({
				idProdotto : idProdotto,
				qnt : qnt
			}),
			success : function(prod) {
				alert("Hai aggiunto al carrello " + qnt + "x " + prod);
				/* location.reload(); */
			}
		});
	}
</script>

<h3>Elenco prodotti - Categoria: ${categoria.nome}</h3>

<div style="display: none" id="idCategoria">${categoria.id}</div>

<c:forEach var="prodotto" items="${prodotti}">
	<div class="prodotto${prodotto.id}">
		<table style="width: 600px; padding: 5px">
			<tr>
				<td width="400">
					<a href="prodotti?id=${prodotto.id}">
						<b id="nomeProdotto${prodotto.id}">${prodotto.nome}</b>
					</a>
				</td>
				<td align="right"><b id="prezzoProdotto${prodotto.id}">${prodotto.prezzoUnitario}</b> Euro</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					Quantita': <input id="quantita" type="number" style="width: 20px" value="1")"/>
					<input type="button" value="Aggiungi" onclick="aggiungiACarrello(${prodotto.id})"/>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>

