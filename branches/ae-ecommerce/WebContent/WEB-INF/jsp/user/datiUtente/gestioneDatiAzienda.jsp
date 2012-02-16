<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<a href="home.htm">Home</a> > <a href="account.htm">Gestione Account</a> > Gestione Dati Azienda
<hr></hr>
<script type="text/javascript">
function checkFields(){
	var error = false;
	if(!$("#piva").val().match(/^\d{11}$/)){
		$("#pivaError").html("<h5 style=\"color: red;\">Non valida</h5>");
		$("#submit").hide('fast');
		error = true;
	}
	else
		$("#pivaError").html("<h5 style=\"color: green;\">Ok</h5>");
	if(!$("#ragioneSociale").val().match(/^[a-zA-Z\s]+$/)){
		$("#ragioneSocialeError").html("<h5 style=\"color: red;\">Non valida</h5>");
		$("#submit").hide('fast');
		error = true;
	}
	else
		$("#ragioneSocialeError").html("<h5 style=\"color: green;\">Ok</h5>");
	if(error)
		$("#submit").hide('fast');
	else
		$("#submit").show('fast');
}
</script>
<form:form method="POST" commandName="userInfo">
	<table>
		<tr class="azienda">
			<td>Partita IVA :</td>
			<td><form:input path="piva" type="text" class="azienda" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="pivaError"></div></td>
		</tr>
		<tr class="azienda">
			<td>Ragione Sociale :</td>
			<td><form:input path="ragioneSociale" type="text" onkeyup="checkFields()" onkeypress="return event.keyCode!=13"/></td>
			<td><div id="ragioneSocialeError"></div></td>
		</tr>
		<tr id="submit">
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>