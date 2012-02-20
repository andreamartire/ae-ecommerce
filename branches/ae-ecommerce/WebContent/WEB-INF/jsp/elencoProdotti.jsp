<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function aggiungiACarrello(idProdotto) {
		var qnt = $('#quantita'+idProdotto).val();
		var nomeProd = $('#nomeProdotto'+idProdotto).text();
		
		$.ajax({
			url : 'addToCart.htm',
			type: "POST",
			data : ({
				idProdotto : idProdotto,
				qnt : qnt
			}),
			success : function(res) {
				if (res == "ok") {
					alert("Hai aggiunto al carrello " + qnt + "x " + nomeProd);
					location.reload();
				} else {
					alert("Accedi per poter creare un carrello");
				}
			}
		});
	}
</script>

<h3>Elenco prodotti - Categoria: ${categoria.nome}</h3>

<div style="display: none" id="idCategoria">${categoria.id}</div>

<c:forEach var="prodotto" items="${prodotti}">
	<div class="prodotto${prodotto.id}">
		<table style="width: 600px; border-spacing: 5px">
			<tr>
				<td width="500">
					<a href="prodotti?id=${prodotto.id}">
						<b id="nomeProdotto${prodotto.id}">${prodotto.nome}</b>
					</a>
				</td>
				<td align="right"><b id="prezzoProdotto${prodotto.id}">${prodotto.prezzoUnitario}</b> Euro</td>
			</tr>
			<tr>
				<td align="right" valign="middle">
					<a onclick="aggiungiACarrello(${prodotto.id})"><img src="resources/images/addToCart.gif" /></a>
				</td>
				<td>
					<input id="quantita${prodotto.id}" type="number" style="width: 40px" value="1"/>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>

