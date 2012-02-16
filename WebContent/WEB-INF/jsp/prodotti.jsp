<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>${prodotto.nome}</h2>

<table style="width: 500px; padding: 5px">
	<tr>
		<td><b id="nomeProdotto${prodotto.id}">${prodotto.nome}</b></td>
		<td align="right"><b>${prodotto.prezzoUnitario}</b> Euro</td>
	</tr>
	<tr>
		<td colspan="2">Descrizione:</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea rows="20" cols="59" readonly="readonly">${prodotto.descrizione}</textarea>
		</td>
	</tr>
</table>