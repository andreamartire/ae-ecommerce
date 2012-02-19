<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function aggiungiACarrello(idProdotto) {
		var qnt = $('#quantita').val();
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


<h2>${prodotto.nome}</h2>

<table style="width: 600px; padding: 5px">
	<tr>
		<td><b id="nomeProdotto${prodotto.id}">${prodotto.nome}</b></td>
		<td align="right"><b>${prodotto.prezzoUnitario}</b> Euro</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			Quantita': <input id="quantita" type="number" style="width: 20px" value="1"/>
			<input type="button" value="Aggiungi" onclick="aggiungiACarrello(${prodotto.id})"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">Descrizione:</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea rows="20" cols="70" readonly="readonly">${prodotto.descrizione}</textarea>
		</td>
	</tr>
</table>