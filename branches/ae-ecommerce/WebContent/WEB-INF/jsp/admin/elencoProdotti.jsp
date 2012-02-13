<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function aggiungiACarrello(idProdotto) {
		var qnt = $('#quantita').val();
		alert("Hai aggiunto al carrello " + qnt + " prodotti con id " + idProdotto);
	}
</script>

<h3>Elenco prodotti - Categoria: ${categoria.nome}</h3>

<div style="display: none" id="idCategoria">${categoria.id}</div>

<c:forEach var="prodotto" items="${prodotti}">
	<div class="prodotto${prodotto.id}">
		<table style="padding: 6px">
			<tr>
				<td>Nome: <b id="nomeProdotto${prodotto.id}">${prodotto.nome}</b></td>
				<td>Prezzo: <b id="prezzoProdotto${prodotto.id}" style="width: 50px">${prodotto.prezzoUnitario}</b> Euro</td>
			</tr>
			<tr>
				<td colspan="2">Descrizione:</td>
			</tr>
			<tr>
				<td colspan="2" width="510">
					<textarea rows="4" cols="60" name="descrizione" id="descrizioneProdotto${prodotto.id}">${prodotto.descrizione}</textarea>
				</td>
			</tr>
			<tr>
				<td>Peso: <b id="pesoProdotto${prodotto.id}" style="width: 30px">${prodotto.pesoApprossimato}</b> Kg</td>
				<td>IVA: <b id="ivaProdotto${prodotto.id}" style="width: 30px">${prodotto.percentualeIVA}</b>%</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					Quantita': <input id="quantita" type="number" style="width: 20px" value="1")"/>
					<input type="button" value="Aggiungi" onclick="aggiungiACarrello(${prodotto.id})"/>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>
