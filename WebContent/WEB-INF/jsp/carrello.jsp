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
</script>

<h3>Carrello della spesa</h3>

<c:forEach var="elementoCarrello" items="${carrello.elementiCarrello}">
	<div>
		<table style="padding: 6px">
			<tr>
				<td>Nome: <b>${elementoCarrello.prodotto.nome}</b></td>
				<td>Prezzo: <b style="width: 50px">${elementoCarrello.prodotto.prezzoUnitario}</b> Euro</td>
			</tr>
			<tr>
				<td>Peso: <b style="width: 30px">${elementoCarrello.prodotto.pesoApprossimato}</b> Kg</td>
				<td>IVA: <b style="width: 30px">${elementoCarrello.prodotto.percentualeIVA}</b>%</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					Quantita': <b id="quantita" style="width: 20px")">${elementoCarrello.quantita}</b>
					<input type="button" value="Elimina" onclick="elimina(${elementoCarrello.id})"/>
				</td>
			</tr>
		</table>
	</div>
	<hr/>
</c:forEach>

