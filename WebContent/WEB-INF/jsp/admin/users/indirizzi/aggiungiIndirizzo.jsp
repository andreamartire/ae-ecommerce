<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function checkFields(){
	if($("#via").val() == "" || $("#numero").val() == "" || $("#citta").val() == ""
			|| $("#provincia").val() == "" || $("#cap").val() == "" ){
		alert("Alcuni campi sono vuoti");
		return false;
	}
}
function checkValue(campo,error,espr) {
	if( !$(campo).val().match(espr)){
		$(error).html("<div style=\"color: red; font-weight: bold;\">Non corretto</div>");
		return;
	}
	$(error).html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
	return;
}
</script>
<a href="home.htm">Home</a> > <a href="gestioneUtenti.htm">Gestione Utenti</a> > <a href="gestioneUtente.htm?id=${id}">Gestione Utente</a> > <a href="gestioneIndirizziAdmin.htm?id=${id}">Gestione Indirizzi</a> > Aggiungi Indirizzo
<hr></hr>
<form:form method="POST" onsubmit="return checkFields()" commandName="indirizzo">
	<table>
		<tr>
			<td>Via :</td>
			<td><form:input path="via" type="text" onkeyup="checkValue('#via','#viaError',/^[a-zA-Z\s]+$/)"/></td>
			<td><div id="viaError"></div></td>
		</tr>
		<tr>
			<td>Numero :</td>
			<td><form:input path="numero" type="text" onkeyup="checkValue('#numero','#numeroError',/^\d+$/)"/></td>
			<td><div id="numeroError"></div></td>
		</tr>
		<tr>
			<td>Citta' :</td>
			<td><form:input path="citta" type="text" onkeyup="checkValue('#citta','#cittaError',/^[a-zA-Z\s]+$/)"/></td>
			<td><div id="cittaError"></div></td>
		</tr>
		<tr>
			<td>Provincia :</td>
			<td><form:input path="provincia" type="text" onkeyup="checkValue('#provincia','#provinciaError',/^[A-Za-z]{2}$/)"/></td>
			<td><div id="provinciaError"></div></td>
		</tr>
		<tr>
			<td>CAP :</td>
			<td><form:input path="cap" type="text" onkeyup="checkValue('#cap','#capError',/^\d{5}$/)"/></td>
			<td><div id="capError"></div></td>
		</tr>
		<tr><td colspan="2"><hr></hr></td></tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>