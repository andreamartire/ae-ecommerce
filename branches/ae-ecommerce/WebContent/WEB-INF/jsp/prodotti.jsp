<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function aggiungiACarrello(idProdotto) {
		var qnt = $('#quantita').val();
		var nomeProd = $('#nomeProdotto').text();
		
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

<h2 style="margin-left: 15px" id="nomeProdotto">${prodotto.nome}</h2>

<table style="width: 615px; padding: 5px">
	<tr>
		<td colspan="2" align="right"><font size="5"><b>${prodotto.prezzoUnitario}</b> Euro</font></td>
	</tr>
	<tr>
		<td width="500px" align="right" valign="middle">
			<a onclick="aggiungiACarrello(${prodotto.id})"><img src="resources/images/addToCart.gif" /></a>
		</td>
		<td>
			<input id="quantita" type="number" style="width: 40px" value="1"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">Descrizione:</td>
	</tr>
	<tr>
		<td colspan="2">
			<div style="border: 1px solid black; padding: 5px">
				${prodotto.descrizione}
			</div>
		</td>
	</tr>
</table>