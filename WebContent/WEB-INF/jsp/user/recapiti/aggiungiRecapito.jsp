<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
function checkFields(){
	if($("#tipo").val() == "" || $("#valore").val() == ""){
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
<a href="home.htm">Home</a> &gt; <a href="account.htm">Gestione Account</a> &gt; <a href="gestioneRecapiti.htm?id=${id}">Gestione Recapiti</a> &gt; Aggiungi Recapito
<hr></hr>
<form:form method="POST" onsubmit="checkFields()" commandName="recapito">
	<table>
		<tr>
			<td>Tipo :</td>
			<td><form:input path="tipo" type="text" /></td>
			<td><div id="tipoError"></div></td>
		</tr>
		<tr>
			<td>Valore :</td>
			<td><form:input path="valore" type="text" onkeyup="checkFields()"/></td>
			<td><div id="valoreError"></div></td>
		</tr>
		<tr><td colspan="2"><hr></hr></td></tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>