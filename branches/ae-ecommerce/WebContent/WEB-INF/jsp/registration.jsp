<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
	.hide { display: none; }
</style>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if(document.getElementById("radioPrivato").checked)
		$(".privato").show('fast');
	if(document.getElementById("radioAzienda").checked)
		$(".azienda").show('fast');
});
function add(value){
	if(value=="Privato"){
		$(".privato").show('fast');
		$(".azienda").hide('fast');
	}
	else{
		$(".privato").hide('fast');
		$(".azienda").show('fast');
	}
	$(".error").text('');
}
function checkUsername() {
	var userRegExp = /^\w/;
	if( !$('#username').val().match(userRegExp) || $('#username').val() == ""){
		$('#userError').html("<h5 style=\"color: red;\">Non disponibile</h5>");
		return;
	}
	$(".error").html('');
	$.ajax({
		url : 'checkUsername.htm',
		type: "POST",
		data : ({
			username : $('#username').val()
		}),
		success : function(res) {
			if (res == "available") {
				$('#userError').html("<h5 style=\"color: green;\">Disponibile</h5>");
			} else if (res == "notAvailable") {
				$('#userError').html("<h5 style=\"color: red;\">Gia' in uso</h5>");
			} else {
				location.reload(); 
			}
		}
	});
}
function checkPassword() {
	$(".error").html('');
	if( $('#password').val().length < 8){
		$('#passwordError').html("<h5 style=\"color: red;\">Debole</h5>");
		return;
	}
	if( $('#password').val().length < 13){
		$('#passwordError').html("<h5 style=\"color: yellow;\">Media</h5>");
		return;
	}
	if( $('#password').val().length < 20){
		$('#passwordError').html("<h5 style=\"color: green;\">Forte</h5>");
		return;
	}
}
function checkConfirmPassword() {
	$(".error").html('');
	if( $('#password').val() != $('#confirmPassword').val()){
		$('#confirmPasswordError').html("<h5 style=\"color: red;\">Non coincide</h5>");
		return;
	}
	$('#confirmPasswordError').html("<h5 style=\"color: green;\">Coincide</h5>");
	return;
}
function checkEmail() {
	$(".error").html('');
	var mailRegExp = /^[a-z|A-Z|0-9|\.|\-|_]+@\w+\.[a-z|A-Z]+$/i;
	if( !$('#email').val().match(mailRegExp)){
		$('#emailError').html("<h5 style=\"color: red;\">Non e' valida</h5>");
		return;
	}
	$('#emailError').html("<h5 style=\"color: green;\">Ok</h5>");
	return;
}
function checkConfirmEmail() {
	$(".error").html('');
	if( $('#email').val() != $('#confirmEmail').val()){
		$('#confirmEmailError').html("<h5 style=\"color: red;\">Non coincide</h5>");
		return;
	}
	$('#confirmEmailError').html("<h5 style=\"color: green;\">Coincide</h5>");
	return;
}
function checkPiva() {
	$(".error").html('');
	var e = /^\d{11}$/;
	if( !$('#piva').val().match(e)){
		$('#pivaError').html("<h5 style=\"color: red;\">Non corretta</h5>");
		return;
	}
	$('#pivaError').html("<h5 style=\"color: green;\">Corretta</h5>");
	return;
}
function checkValue(campo,error) {
	$(".error").html('');
	var e = /^[a-zA-Z\s]+$/;
	if( !$(campo).val().match(e)){
		$(error).html("<h5 style=\"color: red;\">Errato</h5>");
		return;
	}
	$(error).html("<h5 style=\"color: green;\">Ok</h5>");
	return;
}
function checkCF() {
	$(".error").html('');
	var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
	if( !$('#codiceFiscale').val().match(e)){
		$('#codiceFiscaleError').html("<h5 style=\"color: red;\">Non valido</h5>");
		return;
	}
	$('#codiceFiscaleError').html("<h5 style=\"color: green;\">Ok</h5>");
	return;
}
function checkDate(date) {
	$(".error").html('');
	var dataRegExp = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)\d\d$/;
	
	if( !date.match( dataRegExp ) ) {
		$("#submit").addClass("hide");
		$("#dateError").html("<h5 style=\"color: red;\">Richiesto formato dd/MM/yyyy (es. 04/03/2011)</h5>");
		return false;
	}
	else {
		$("#dateError").html("<h5 style=\"color: green;\">Ok</h5>");
		$("#submit").removeClass("hide");
	}
}
</script>

Inserisci i tuoi dati

<form:form method="POST" commandName="registrationInfo">
	<table>
		<tr>
			<td>User Name </td>
			<td><form:input path="username" onkeyup="checkUsername()"/></td>
			<td><form:errors path="username" cssClass="error" /></td>
			<td><div id="userError"></div></td>
		</tr>
		<tr>
			<td>Password </td>
			<td><form:password path="password" onkeyup="checkPassword()"/></td>
			<td><form:errors path="password" cssClass="error" /></td>
			<td><div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>Confirm Password </td>
			<td><form:password path="confirmPassword" onkeyup="checkConfirmPassword()"/></td>
			<td><form:errors path="confirmPassword" cssClass="error" /></td>
			<td><div id="confirmPasswordError"></div></td>
		</tr>
		<tr>
			<td>eMail </td>
			<td><form:input path="email" onkeyup="checkEmail()"/></td>
			<td><form:errors path="email" cssClass="error" /></td>
			<td><div id="emailError"></div></td>
		</tr>
		<tr>
			<td>Confirm eMail </td>
			<td><form:input path="confirmEmail" onkeyup="checkConfirmEmail()"/></td>
			<td><form:errors path="confirmEmail" cssClass="error" /></td>
			<td><div id="confirmEmailError"></div></td>
		</tr>
		<tr>
			<td>Type </td>
			<td><form:radiobutton id="radioPrivato" path="type" value="Privato" label="Privato" onclick="add(this.value)"/>
				<form:radiobutton id="radioAzienda" path="type" value="Azienda" label="Azienda" onclick="add(this.value)"/>
				<form:errors path="type" cssClass="error" /></td>
		</tr>
<!-- 			Azienda -->
		<tr class="azienda hide">
			<td>Partita IVA </td>
			<td><form:input path="piva" onkeyup="checkPiva()"/></td>
			<td><form:errors path="piva" cssClass="error" /></td>
			<td><div id="pivaError"></div></td>
		</tr>
		<tr class="azienda hide">
			<td>Ragione Sociale </td>
			<td><form:input path="ragioneSociale" onkeyup="checkValue('#ragioneSociale','#ragSocialeError')"/></td>
			<td><form:errors path="ragioneSociale" cssClass="error" /></td>
			<td><div id="ragSocialeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Cognome </td>
			<td><form:input path="cognome" onkeyup="checkValue('#cognome','#cognomeError')"/></td>
			<td><form:errors path="cognome" cssClass="error" /></td>
			<td><div id="cognomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Nome </td>
			<td><form:input path="nome" onkeyup="checkValue('#nome','#nomeError')"/></td>
			<td><form:errors path="nome" cssClass="error" /></td>
			<td><div id="nomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Data di Nascita </td>
			<td><form:input path="dataNascita" onkeyup="checkDate(this.value)"/></td>
			<td><form:errors path="dataNascita" cssClass="error"/></td>
			<td><div id="dateError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Luogo di Nascita </td>
			<td><form:input path="luogoNascita" onkeyup="checkValue('#luogoNascita','#luogoNascitaError')"/></td>
			<td><form:errors path="luogoNascita" cssClass="error" /></td>
			<td><div id="luogoNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Codice Fiscale </td>
			<td><form:input path="codiceFiscale" onkeyup="checkCF()"/></td>
			<td><form:errors path="codiceFiscale" cssClass="error" /></td>
			<td><div id="codiceFiscaleError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit"></td>
		</tr>
	</table>
</form:form>
<a href="home.htm"><button>Back</button></a>
