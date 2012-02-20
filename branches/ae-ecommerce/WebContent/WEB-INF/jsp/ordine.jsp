<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<script type="text/javascript">
	function prosegui() {
		var destinatario, via, numero, citta, provincia, cap;
		var id = $("input[name='indirizzo']:checked").val();
		
		if (id == "other") {
			destinatario = $('#destinatario').val();
			via = $('#via').val();
			numero = $('#numero').val();
			citta = $('#citta').val();
			provincia = $('#provincia').val();
			cap = $('#cap').val();
			
		} else {
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
	
	var checkedValue;
	
	function registered() {
		$('#altro').hide();
		$("input[name='indirizzo']").filter('[value='+checkedValue+']').attr('checked', true);
		$('#avanti').removeAttr("disabled");  
	}
	
	function other() {
		$('#altro').show(); 
		checkedValue = $("input[name='indirizzo']:checked").val();
		$("input[name='indirizzo']").filter('[value=other]').attr('checked', true);
		check();
	}
	
	function checkDest() {
		if (!$('#destinatario').val().match(/^\w+$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#destinatario').css({'border-color' : 'red'});
		} else {
			$('#destinatario').css({'border-color' : 'white'});
		}
	}
	
	function checkCAP() {
		if (!$('#cap').val().match(/^\d{5}$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#cap').css({'border-color' : 'red'});
		} else {
			$('#cap').css({'border-color' : 'white'});
		}
	}
	
	function checkNumero() {
		if (!$('#numero').val().match(/^\d+$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#numero').css({'border-color' : 'red'});
		} else {
			$('#numero').css({'border-color' : 'white'});
		}
	}
	
	function checkVia() {
		if (!$('#via').val().match(/^\w+$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#via').css({'border-color' : 'red'});
		} else {
			$('#via').css({'border-color' : 'white'});
		}
	}
	
	function checkCitta() {
		if (!$('#citta').val().match(/^\w+$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#citta').css({'border-color' : 'red'});
		} else {
			$('#citta').css({'border-color' : 'white'});
		}
	}
	
	function checkProvincia() {
		if (!$('#provincia').val().match(/^\w{2}$/)) {
			$('#avanti').attr("disabled", "disabled");
			$('#provincia').css({'border-color' : 'red'});
		} else {
			$('#provincia').css({'border-color' : 'white'});
		}
	}
	
	window.setInterval(check, 1000);

	function check() {
		if ($("input[name='indirizzo']:checked").val() == "other") {
			$('#avanti').removeAttr("disabled");
			checkDest();
			checkCAP();
			checkCitta();
			checkProvincia();
			checkNumero();
			checkVia();
		}
	}
	
	$(document).ready( function() {
		registered();
	});
</script>

<p>
	Seleziona l'indirizzo a cui consegnare il pacco.
</p>

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
					<span id="dest${indirizzo.id}">${ordine.carrello.cliente}</span>
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
	<tr id="altro">
		<td align="center">
			<input type="radio" name="indirizzo" value="other"/>
		</td>
		<td>
			<table style="border: 0px">
				<tr>
					<td style="border: 0px">
						Destinatario: <input onblur="checkDest()" style="width: 280px" type="text" id="destinatario" value="${ordine.carrello.cliente}"/>
					</td>
				</tr>
				<tr>
					<td style="border: 0px">
						Via: <input onblur="checkVia()" style="width: 218px" type="text" id="via"/> 
						Numero: <input onblur="checkNumero()" style="width: 50px" type="text" id="numero"/>
					</td>
				</tr>
				<tr>
					<td style="border: 0px">
						CAP: <input onblur="checkCAP()" style="width: 60px" type="text" id="cap" maxlength="5"/>
						Citta': <input onblur="checkCitta()" style="width: 100px" type="text" id="citta"/>
						Provincia: <input onblur="checkProvincia()" style="width: 30px" type="text" maxlength="2" id="provincia"/>
					</td>
				</tr>
				<tr>
					<td style="border: 0px" align="right">
						<input type="button" value="Annulla" onclick="registered()"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<span style="margin-top: 10px; margin-bottom: 20px"><button onclick="other()">Altro Indirizzo</button></span>
</div>

<div style="text-align: right; float: right">
	<form action="proseguiOrdine.htm" method="post" id="ordineForm">
		<input type="hidden" id="destinatarioForm" name="dest"/>
		<input type="hidden" id="viaForm" name="via"/>
		<input type="hidden" id="numeroForm" name="num"/>
		<input type="hidden" id="cittaForm" name="citta"/>
		<input type="hidden" id="provinciaForm" name="prov"/>
		<input type="hidden" id="capForm" name="cap"/>
		<button onclick="prosegui()" id="avanti" style="margin: auto; font-size: 12pt; font-weight: bold;">Avanti</button>
	</form>
</div>

<div style="text-align: right; float:right">
		<a href="carrello.htm"><button style="font-size: 12pt; font-weight: bold;">Indietro</button></a>
</div>