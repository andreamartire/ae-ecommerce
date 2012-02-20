<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<a href="home.htm">Home</a> &gt; <a href="account.htm">Gestione Account</a> &gt; Gestione Dati Azienda
<hr></hr>
<script type="text/javascript">
function checkFields(){
	var error = false;
	if(!$("#piva").val().match(/^\d{11}$/)){
		$("#pivaError").html("<font style=\"color: red;\">Non valida</font>");
		$("#submit").hide('fast');
		error = true;
	}
	else
		$("#pivaError").html("<font style=\"color: green;\">Ok</font>");
	if(!$("#ragioneSociale").val().match(/^[a-zA-Z\s]+$/)){
		$("#ragioneSocialeError").html("<font style=\"color: red;\">Non valida</font>");
		$("#submit").hide('fast');
		error = true;
	}
	else
		$("#ragioneSocialeError").html("<font style=\"color: green;\">Ok</font>");
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