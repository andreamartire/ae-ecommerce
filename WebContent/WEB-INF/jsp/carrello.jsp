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
				$('.'+elementoCarrello).fadeOut('fast');
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
			}
		});
	}
</script>

<h3>Carrello della spesa</h3>

<c:forEach var="elementoCarrello" items="${carrello}">
	<div class="${elementoCarrello.id}" >
		<table style="width: 500px; padding: 5px">
			<tr>
				<td><a href="prodotti?id=${elementoCarrello.prodotto.id}"><b>${elementoCarrello.prodotto.nome}</b></a></td>
				<td align="right"><b>${elementoCarrello.prodotto.prezzoUnitario}</b> Euro</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					Quantita': <input id="quantita${elementoCarrello.id}" type="number" style="width: 20px" value="${elementoCarrello.quantita}"/>
					<input type="button" value="Aggiorna" onclick="aggiorna(${elementoCarrello.id})"/>
					<input type="button" value="Elimina" onclick="elimina(${elementoCarrello.id})"/>
				</td>
			</tr>
		</table>
	</div>
	<hr class="${elementoCarrello.id}"/>
</c:forEach>

