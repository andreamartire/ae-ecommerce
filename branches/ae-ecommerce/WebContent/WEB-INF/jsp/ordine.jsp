<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<script type="text/javascript">
	function prosegui() {
		var destinatario, via, numero, citta, provincia, cap;
		if ($('#type').val() == "other") {
			destinatario = $('#destinatario').val();
			via = $('#via').val();
			numero = $('#numero').val();
			citta = $('#citta').val();
			provincia = $('#provincia').val();
			cap = $('#cap').val();
			
		} else {
			var id = $("input[name='indirizzo']:checked").val();
			
			destinatario = $('#dest'+id).text();
			via = $('#via'+id).text();
			numero = $('#num'+id).text();
			citta = $('#citta'+id).text();
			provincia = $('#prov'+id).text();
			cap = $('#cap'+id).text();
		}
		
		$('#destinatarioForm').val(destinatario);
		$('#viaForm').val(via);
		$('#numeroForm').val(numero);
		$('#cittaForm').val(citta);
		$('#provinciaForm').val(provincia);
		$('#capForm').val(cap);
		
		$('#ordineForm').submit();
	}
	
	function registered() {
		$('#addIndirizzo').hide(); 
		$('#spedDiv').show();
		$('#type').val("registered");
	}
	
	function other() {
		$('#addIndirizzo').show(); 
		$('#spedDiv').hide();
		$('#type').val("other");
	}
</script>

<p>
	Seleziona l'indirizzo a cui consegnare il pacco.
</p>

<input type="hidden" id="type" value="registered"/>

<div id="spedDiv">
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
				<c:if test="${empty indirizzo.destinatario}">
					<span id="dest${indirizzo.id}">${ordine.carrello.cliente.nome} ${ordine.carrello.cliente.cognome}</span>
				</c:if>
				<c:if test="${not empty indirizzo.destinatario}">
					<span id="dest${indirizzo.id}">${indirizzo.destinatario} </span>
				</c:if>
				<br/>
				<span id="via${indirizzo.id}">${indirizzo.via}</span> <span id="num${indirizzo.id}">${indirizzo.numero}</span><br/>
				<span id="cap${indirizzo.id}">${indirizzo.cap}</span> <span id="citta${indirizzo.id}">${indirizzo.citta}</span> <span id="prov${indirizzo.id}">${indirizzo.provincia}</span><br/>
			</td>
		</tr>
	</c:forEach>
</table>

<span style="margin: 10px"><button onclick="other()">Altro Indirizzo</button></span>
</div>

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
		<td>Via: </td><td><input style="width: 100px" type="text" id="via"/></td>
		<td>Numero: </td><td colspan="3"><input style="width: 100px" type="text" id="numero"/></td>
	</tr>
	<tr>
		<td>CAP: </td><td><input style="width: 100px" type="text" id="cap"/></td>
		<td>Citta': </td><td><input style="width: 100px" type="text" id="citta"/></td>
		<td>Provincia: </td><td><input style="width: 100px" type="text" id="provincia"/></td>
	</tr>
	<tr>
		<td colspan="6" align="right">
			<input type="button" value="Annulla" onclick="registered()"/>
		</td>
	</tr>
</table>
</div>

<div style="width: 600px; text-align: right; margin: 10px">
	<form action="proseguiOrdine.htm" method="post" id="ordineForm">
		<input type="hidden" id="destinatarioForm" name="dest"/>
		<input type="hidden" id="viaForm" name="via"/>
		<input type="hidden" id="numeroForm" name="num"/>
		<input type="hidden" id="cittaForm" name="citta"/>
		<input type="hidden" id="provinciaForm" name="prov"/>
		<input type="hidden" id="capForm" name="cap"/>
		<input type="button" onclick="prosegui()" value="Prosegui nell'ordine"/>
	</form>
</div>