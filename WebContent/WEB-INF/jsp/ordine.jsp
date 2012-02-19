<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<script type="text/javascript">
	function addIndirizzo() {
		$.ajax({
			url : "aggiungiIndirizzoAJAX.htm",
			type: "POST",
			data : ({
				destinatario : $('#destinatario').val(),
				via : $('#via').val(),
				numero : $('#numero').val(),
				citta : $('#citta').val(),
				provincia : $('#provincia').val(),
				cap : $('#cap').val()
			}),
			success : function(res) {
				$('#addIndirizzo').fadeOut(200);
				alert("indirizzo aggiunto");
			}
		});
	}
</script>

<p>
	Seleziona l'indirizzo a cui consegnare il pacco.
</p>

<table id='spedTable'>
	<thead>
		<tr>
			<td>Seleziona</td>
			<td width="550">Indirizzo</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="indirizzo" items="${ordine.carrello.cliente.indirizzi}">
		<tr>
			<td align="center">
				<input type="radio" checked="checked" name="indirizzo" value="${indirizzo.id}"/>
			</td>
			<td>
				${indirizzo.destinatario}<br/>
				${indirizzo.via} ${indirizzo.numero}<br/>
				${indirizzo.cap} ${indirizzo.citta} ${indirizzo.provincia}<br/>
			</td>
		</tr>
	</c:forEach>
</table>

<span style="margin: 10px"><button onclick="$('#addIndirizzo').fadeIn(200); $('#spedTable').fadeOut(200);">Altro Indirizzo</button></span>
<div style="display: none; margin-top: 20px" id="addIndirizzo">
<table style="border: 1px solid blue">
	<tr>
		<td>Nome: </td>
		<td colspan="5">
			<input style="width: 100px" type="text" id="destinatario" 
				value="${ordine.carrello.cliente.nome} ${ordine.carrello.cliente.cognome}"/>
		</td>
	</tr>
	<tr>
		<td>via: </td><td><input style="width: 100px" type="text" id="via"/></td>
		<td>numero: </td><td colspan="3"><input style="width: 100px" type="text" id="numero"/></td>
	</tr>
	<tr>
		<td>cap: </td><td><input style="width: 100px" type="text" id="cap"/></td>
		<td>citta': </td><td><input style="width: 100px" type="text" id="citta"/></td>
		<td>provincia: </td><td><input style="width: 100px" type="text" id="provincia"/></td>
	</tr>
	<tr>
		<td colspan="6" align="right">
			<input type="button" value="Accetta" onclick="addIndirizzo()"/>
			<input type="button" value="Annulla" onclick="$('#addIndirizzo').fadeOut(200); $('#spedTable').fadeIn(200);"/>
		</td>
	</tr>
</table>
</div>