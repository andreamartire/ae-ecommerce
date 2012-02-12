<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<a href="home.htm">Home</a> > <a href="gestioneUtenti.htm">Gestione Utenti</a> > Gestione Dati Privato
<hr></hr>
<script type="text/javascript">
function checkFields(){
	var error = false;
	if(!$("#nome").val().match(/^[a-zA-Z\s]+$/)){
		$("#nomeError").html("<h5 style=\"color: red;\">Non valido</h5>");
		error = true;
	}
	else
		$("#nomeError").html("<h5 style=\"color: green;\">Ok</h5>");
	
	if(!$("#cognome").val().match(/^[a-zA-Z\s]+$/)){
		$("#cognomeError").html("<h5 style=\"color: red;\">Non valido</h5>");
		error = true;
	}
	else
		$("#cognomeError").html("<h5 style=\"color: green;\">Ok</h5>");
	
	var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
	if(!$("#codiceFiscale").val().match(e)){
		$("#codiceFiscaleError").html("<h5 style=\"color: red;\">Non valido</h5>");
		error = true;
	}
	else
		$("#codiceFiscaleError").html("<h5 style=\"color: green;\">Ok</h5>");
	
	if(!$("#dataNascita").val().match(/^\d{4}\-\d{2}\-\d{2}$/)){
		$("#dataNascitaError").html("<h5 style=\"color: red;\">Richiesto yyyy-MM-dd</h5>");
		error = true;
	}
	else
		$("#dataNascitaError").html("<h5 style=\"color: green;\">Ok</h5>");
	
	if(!$("#luogoNascita").val().match(/^[a-zA-Z\s]+$/)){
		$("#luogoNascitaError").html("<h5 style=\"color: red;\">Non valido</h5>");
		error = true;
	}
	else
		$("#luogoNascitaError").html("<h5 style=\"color: green;\">Ok</h5>");
	
	if(error)
		$("#submit").hide('fast');
	else
		$("#submit").show('fast');
}
</script>
<form:form method="POST" commandName="userInfo">
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
			<td><form:input path="dataNascita" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
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
