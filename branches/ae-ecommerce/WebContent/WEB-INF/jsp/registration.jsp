<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<a href="home.htm">Home</a>
> Registrazione
<br />
<style type="text/css">
.hide {
	display: none;
}
</style>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// All'avvio usa di default i campi del privato
		add("Privato");
	});
	function checkFields() {
		var error = false;

		//password
		if ($('#password').val().length < 8)
			$('#passwordError').html("<h5 style=\"color: red;\">Debole</h5>");
		else if ($('#password').val().length < 13)
			$('#passwordError').html("<h5 style=\"color: yellow;\">Media</h5>");
		else if ($('#password').val().length < 20)
			$('#passwordError').html("<h5 style=\"color: green;\">Forte</h5>");
		if ($('#password').val() == ""){
			$('#passwordError').html("<h5 style=\"color: red;\">Non valida</h5>");
			error = true;
		}

		//confirm password
		if ($('#password').val() != $('#confirmPassword').val()) {
			$('#confirmPasswordError').html("<h5 style=\"color: red;\">Non coincide</h5>");
			error = true;
		} else
			$('#confirmPasswordError').html("<h5 style=\"color: green;\">Coincide</h5>");

		//email
		var mailRegExp = /^[a-z|A-Z|0-9|\.|\-|_]+@\w+\.[a-z|A-Z]+$/i;
		if (!$('#email').val().match(mailRegExp)) {
			$('#emailError').html("<h5 style=\"color: red;\">Non e' valida</h5>");
			error = true;
		} else
			$('#emailError').html("<h5 style=\"color: green;\">Ok</h5>");

		//confirm email
		/*if ($('#email').val() != $('#confirmEmail').val()) {
			$('#confirmEmailError').html("<h5 style=\"color: red;\">Non coincide</h5>");
			error = true;
		} else
			$('#confirmEmailError').html("<h5 style=\"color: green;\">Coincide</h5>");*/

		var value = $("input[@name=type]:checked").val();

		azienda = false;
		if (value == "Azienda")
			azienda = true;
		privato = false;
		if (value == "Privato")
			privato = true;

		if (azienda) {
			//piva
			var e = /^\d{11}$/;
			if (!$('#piva').val().match(e)) {
				$('#pivaError').html("<h5 style=\"color: red;\">Non corretta</h5>");
				error = true;
			} else
				$('#pivaError').html("<h5 style=\"color: green;\">Corretta</h5>");
			
			//ragSociale
			if(!$("#ragioneSociale").val().match(/^[a-zA-Z\s]+$/)){
				$("#ragioneSocialeError").html("<h5 style=\"color: red;\">Non valida</h5>");
				error = true;
			}
			else
				$("#ragioneSocialeError").html("<h5 style=\"color: green;\">Ok</h5>");
		}
		
		if(privato){
			//cognome
			if(!$("#cognome").val().match(/^[a-zA-Z\s]+$/)){
				$("#cognomeError").html("<h5 style=\"color: red;\">Non valido</h5>");
				error = true;
			}
			else
				$("#cognomeError").html("<h5 style=\"color: green;\">Ok</h5>");
			
			//nome
			if(!$("#nome").val().match(/^[a-zA-Z\s]+$/)){
				$("#nomeError").html("<h5 style=\"color: red;\">Non valido</h5>");
				error = true;
			}
			else
				$("#nomeError").html("<h5 style=\"color: green;\">Ok</h5>");
			
			//dataNascita
			if(!$("#dataNascita").val().match(/^\d{4}\-\d{2}\-\d{2}$/)){
				$("#dataNascitaError").html("<h5 style=\"color: red;\">Richiesto yyyy-MM-dd</h5>");
				error = true;
			}
			else
				$("#dataNascitaError").html("<h5 style=\"color: green;\">Ok</h5>");
			
			//luogoNascita
			if(!$("#luogoNascita").val().match(/^[a-zA-Z\s]+$/)){
				$("#luogoNascitaError").html("<h5 style=\"color: red;\">Non valido</h5>");
				error = true;
			}
			else
				$("#luogoNascitaError").html("<h5 style=\"color: green;\">Ok</h5>");
			
			//codice fiscale
			var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
			if (!$('#codiceFiscale').val().match(e)) {
				$('#codiceFiscaleError').html(
						"<h5 style=\"color: red;\">Non valido</h5>");
				error = true;
			}
			else
				$('#codiceFiscaleError').html("<h5 style=\"color: green;\">Ok</h5>");
		}
		$('#nomeError').html("<h5 style=\"color: green;\">" + error + "</h5>");
		if (error)
			$("#submit").hide('fast');
		else
			$("#submit").show('fast');
		
		// username
		if(!$('#username').val().match(/^\w+$/))
			$("#submit").hide('fast');
		$.ajax({
			url : 'checkUsername.htm',
			type : "POST",
			data : ({
				username : $('#username').val()
			}),
			success : function(res) {
				if (res == "available" && $('#username').val().match(/^\w+$/))
					$('#usernameError').html("<h5 style=\"color: green;\">Disponibile</h5>");
				else {
					$('#usernameError').html("<h5 style=\"color: red;\">Non disponibile</h5>");
					$("#submit").hide('fast');
				}
			}
		});
	}
	function add(value) {
		checkFields();
		if (value == "Privato") {
			$(".privato").removeClass("hide");
			$(".azienda").addClass("hide");
		} else {
			$(".privato").addClass("hide");
			$(".azienda").removeClass("hide");
		}
	}
</script>

<form:form method="POST" commandName="registrationInfo">
	<table>
		<tr>
			<td>User Name</td>
			<td><form:input path="username" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="username" cssClass="error" /></td>
			<td><div id="usernameError"></div></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
			<td><div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><form:password path="confirmPassword"
					onkeyup="checkFields()" onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="confirmPassword" cssClass="error" /></td>
			<td><div id="confirmPasswordError"></div></td>
		</tr>
		<tr>
			<td>eMail</td>
			<td><form:input path="email" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
			<td><div id="emailError"></div></td>
		</tr>
		<tr>
			<td>Confirm eMail</td>
			<td><form:input path="confirmEmail" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="confirmEmail" cssClass="error" /></td>
			<td><div id="confirmEmailError"></div></td>
		</tr>
		<tr>
			<td>Type</td>
			<td><form:radiobutton id="radioPrivato" path="type"
					value="Privato" label="Privato" checked="yes"
					onclick="add(this.value)" /> <form:radiobutton id="radioAzienda"
					path="type" value="Azienda" label="Azienda"
					onclick="add(this.value)" /> <form:errors path="type"
					cssClass="error" /></td>
		</tr>
		<!-- Azienda -->
		<tr class="azienda hide">
			<td>Partita IVA</td>
			<td><form:input path="piva" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="piva" cssClass="error" /></td>
			<td><div id="pivaError"></div></td>
		</tr>
		<tr class="azienda hide">
			<td>Ragione Sociale</td>
			<td><form:input path="ragioneSociale"
					onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="ragioneSociale" cssClass="error" /></td>
			<td><div id="ragioneSocialeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Cognome</td>
			<td><form:input path="cognome" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="cognome" cssClass="error" /></td>
			<td><div id="cognomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Nome</td>
			<td><form:input path="nome" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="nome" cssClass="error" /></td>
			<td><div id="nomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Data di Nascita</td>
			<td><form:input path="dataNascita" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="dataNascita" cssClass="error" /></td>
			<td><div id="dataNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Luogo di Nascita</td>
			<td><form:input path="luogoNascita" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="luogoNascita" cssClass="error" /></td>
			<td><div id="luogoNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Codice Fiscale</td>
			<td><form:input path="codiceFiscale" onkeyup="checkFields()"
					onkeypress="return event.keyCode!=13" /></td>
			<td><form:errors path="codiceFiscale" cssClass="error" /></td>
			<td><div id="codiceFiscaleError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit"></td>
		</tr>
	</table>
</form:form>
