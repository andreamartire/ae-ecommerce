<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<a href="home.htm">Home</a> &gt; <a href="account.htm">Gestione Account</a> &gt; Gestione Dati Privato
<hr></hr>

<link rel="stylesheet" href="resources/css/jquery-ui.css" type="text/css" media="all" />
<link rel="stylesheet" href="resources/css/ui-lightness/jquery-ui-style.css" type="text/css" media="all" />

<script src="resources/js/jquery-ui-1.8.17.min.js" type="text/javascript"></script>

<style type="text/css">
	.ui-datepicker {
		font-family: monospace; 
		font-size: 10pt; 
	} 
	.hide {
		display: none;
	}
</style>

<script type="text/javascript">
$(document).ready(function() {
	// inizializza il datepicker
	$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	
	$.datepicker.regional['it'] = {
		closeText : 'Chiudi',
		prevText : '&#x3c;Prec',
		nextText : 'Succ&#x3e;',
		currentText : 'Oggi',
		monthNames : [ 'Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio',
				'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre',
				'Novembre', 'Dicembre' ],
		monthNamesShort : [ 'Gen', 'Feb', 'Mar', 'Apr', 'Mag', 'Giu',
				'Lug', 'Ago', 'Set', 'Ott', 'Nov', 'Dic' ],
		dayNames : [ 'Domenica', 'Luned&#236', 'Marted&#236',
				'Mercoled&#236', 'Gioved&#236', 'Venerd&#236', 'Sabato' ],
		dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab' ],
		dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Me', 'Gi', 'Ve', 'Sa' ],
		weekHeader : 'Sm',
		dateFormat : 'yy-mm-dd',
		firstDay : 1,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : ''
	};
	$.datepicker.setDefaults($.datepicker.regional['it']);
});

function checkFields(){
	var error = false;
	if(!$("#nome").val().match(/^[a-zA-Z\s]+$/)){
		$("#nomeError").html("<font style=\"color: red;\">Non valido</font>");
		error = true;
	}
	else
		$("#nomeError").html("<font style=\"color: green;\">Ok</font>");
	
	if(!$("#cognome").val().match(/^[a-zA-Z\s]+$/)){
		$("#cognomeError").html("<font style=\"color: red;\">Non valido</font>");
		error = true;
	}
	else
		$("#cognomeError").html("<font style=\"color: green;\">Ok</font>");
	
	var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
	if(!$("#codiceFiscale").val().match(e)){
		$("#codiceFiscaleError").html("<font style=\"color: red;\">Non valido</font>");
		error = true;
	}
	else
		$("#codiceFiscaleError").html("<font style=\"color: green;\">Ok</font>");
	
	if(!$("#dataNascita").val().match(/^\d{4}\-\d{2}\-\d{2}$/)){
		$("#dataNascitaError").html("<font style=\"color: red;\">Richiesto yyyy-MM-dd</font>");
		error = true;
	}
	else
		$("#dataNascitaError").html("<font style=\"color: green;\">Ok</font>");
	
	if(!$("#luogoNascita").val().match(/^[a-zA-Z\s]+$/)){
		$("#luogoNascitaError").html("<font style=\"color: red;\">Non valido</font>");
		error = true;
	}
	else
		$("#luogoNascitaError").html("<font style=\"color: green;\">Ok</font>");
	
	if(error)
		$("#submit").hide('fast');
	else
		$("#submit").show('fast');
}
</script>
<form:form method="POST" commandName="userInfo">
	<form:input path="id" type="hidden" />
	<form:input path="username" type="hidden" />
	<form:input path="password" type="hidden" />
	<table>
		<tr class="privato">
			<td>Nome </td>
			<td><form:input path="nome" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="nomeError"></div></td>
		</tr>
		<tr class="privato">
			<td>Cognome :</td>
			<td><form:input path="cognome" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="cognomeError"></div></td>
		</tr>
		<tr class="privato">
			<td>Codice Fiscale :</td>
			<td><form:input path="codiceFiscale" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="codiceFiscaleError"></div></td>
		</tr>
		<tr class="privato">
			<td>Data Nascita :</td>
			<td><form:input path="dataNascita" id="datepicker" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="dataNascitaError"></div></td>
		</tr>
		<tr class="privato">
			<td>Luogo Nascita :</td>
			<td><form:input path="luogoNascita" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="luogoNascitaError"></div></td>
		</tr>
		<tr id="submit">
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
