<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".privato").hide('fast');
	$(".azienda").hide('fast');
	if($("#type").val() == "Privato")
		$(".privato").show('fast');
	else
		$(".azienda").show('fast');
});
function checkFields(){
	if($("#via").val() == "" || $("#numero").val() == "" || $("#citta").val() == ""
			|| $("#provincia").val() == "" || $("#cap").val() == "" ){
		alert("Alcuni campi sono vuoti");
		return false;
	}
}
function checkValue(campo,error,espr) {
	$(".error").html('');
	if( !$(campo).val().match(espr)){
		$(error).html("<h5 style=\"color: red;\">Non corretto</h5>");
		return;
	}
	$(error).html("<h5 style=\"color: green;\">Ok</h5>");
	return;
}
</script>
I tuoi dati

<form:form method="POST" onsubmit="return checkFields()" commandName="regInfo">
	<table>
		<tr>
			<td>Username </td>
			<td><form:input path="username" type="text" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>Old Password </td>
			<td><form:input path="password" type="password" /></td>
			<td><div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>New Password </td>
			<td><form:input path="password" type="password" /></td>
			<td><div id="passwordError"></div></td>
		</tr>
		<tr class="privato">
			<td>Nome </td>
			<td><form:input path="nome" type="text"/></td>
			<td><div id="nomeError"></div></td>
		</tr>
		<tr class="privato">
			<td>Cognome :</td>
			<td><form:input path="cognome" type="text"/></td>
			<td><div id="cognomeError"></div></td>
		</tr>
		<tr class="privato">
			<td>Codice Fiscale :</td>
			<td><form:input path="codiceFiscale" type="text"/></td>
			<td><div id="codiceFiscaleError"></div></td>
		</tr>
		<tr class="privato">
			<td>Data Nascita :</td>
			<td><form:input path="dataNascita" type="text"/></td>
			<td><div id="dataNascitaError"></div></td>
		</tr>
		<tr class="privato">
			<td>Luogo Nascita :</td>
			<td><form:input path="luogoNascita" type="text"/></td>
			<td><div id="luogoNascitaError"></div></td>
		</tr>
		<tr class="azienda">
			<td>Partita IVA :</td>
			<td><form:input path="piva" type="text" class="azienda"/></td>
			<td><div id="pivaError"></div></td>
		</tr>
		<tr class="azienda">
			<td>Ragione Sociale :</td>
			<td><form:input path="ragioneSociale" type="text" /></td>
			<td><div id="ragioneSocialeError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
<a href="home.htm"><button>Back</button></a>
