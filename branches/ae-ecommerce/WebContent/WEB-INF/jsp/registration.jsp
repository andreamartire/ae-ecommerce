<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<a href="home.htm">Home</a> > Registrazione
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
	
	function checkPassword(obj){
		//password
		if ($('#password').val().length < 8)
			$('#passwordError').html("<div style=\"color: red; font-weight: bold;\">Debole</div>");
		else if ($('#password').val().length < 13)
			$('#passwordError').html("<div style=\"color: yellow; font-weight: bold;\">Media</div>");
		else if ($('#password').val().length < 20)
			$('#passwordError').html("<div style=\"color: green; font-weight: bold;\">Forte</div>");
		if ($('#password').val() == ""){
			$('#passwordError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
// 			alert("errore pass");
		}

		//confirm password
		if ($('#password').val() != $('#confirmPassword').val()) {
			$('#confirmPasswordError').html("<div style=\"color: red; font-weight: bold;\">Non coincide</div>");
			obj.error = true;
// 			alert("errore c pass");
		} else
			$('#confirmPasswordError').html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
	}
	
	function checkEmail(obj){
		//email
		var mailRegExp = /^[a-z|A-Z|0-9|\.|\-|_]+@\w+\.[a-z|A-Z]+$/i;
		if (!$('#email').val().match(mailRegExp)) {
			$('#emailError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
// 			alert("errore email");
			
		} else
			$('#emailError').html("<div style=\"color: green; font-weight: bold;\">Ok</div>");

		//confirm email
		if ($('#email').val() != $('#confirmEmail').val()) {
			$('#confirmEmailError').html("<div style=\"color: red; font-weight: bold;\">Non coincide</div>");
			obj.error = true;
// 			alert("errore email c");
		} else
			$('#confirmEmailError').html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
	}
	
	function checkAzienda(obj){
		//piva
		var e = /^\d{11}$/;
		if (!$('#piva').val().match(e)) {
			$('#pivaError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
// 			alert("errore piva");
		} else
			$('#pivaError').html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
		
		//ragSociale
		if(!$("#ragioneSociale").val().match(/^[a-zA-Z\s]+$/)){
			$("#ragioneSocialeError").html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
// 			alert("errore rag soc");
		}
		else
			$("#ragioneSocialeError").html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
	}
	
	function checkPrivato(obj){
		//cognome
		if(!$("#cognome").val().match(/^[a-zA-Z\s]+$/)){
			$("#cognomeError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
// 			alert("errore cognome");
		}
		else
			$("#cognomeError").html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
		
		//nome
		if(!$("#nome").val().match(/^[a-zA-Z\s]+$/)){
			$("#nomeError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
// 			alert("errore nome");
		}
		else
			$("#nomeError").html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
		
		//dataNascita
		if(!$("#dataNascita").val().match(/^\d{4}\-\d{2}\-\d{2}$/)){
			$("#dataNascitaError").html("<div style=\"color: red; font-weight: bold;\">Richiesto yyyy-MM-dd</div>");
			obj.error = true;
// 			alert("errore dn");
		}
		else
			$("#dataNascitaError").html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
		
		//luogoNascita
		if(!$("#luogoNascita").val().match(/^[a-zA-Z\s]+$/)){
			$("#luogoNascitaError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
// 			alert("errore ln");
		}
		else
			$("#luogoNascitaError").html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
		
		//codice fiscale
		var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
		if (!$('#codiceFiscale').val().match(e)) {
			$('#codiceFiscaleError').html(
					"<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
// 			alert("errore cf");
		}
		else
			$('#codiceFiscaleError').html("<div style=\"color: green; font-weight: bold;\">Ok</div>");
	}
	
	function checkUsername(){
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
				if (res == "available" && $('#username').val().match(/^\w+$/)){
					$('#usernameError').html("<div style=\"color: green; font-weight: bold;\">Disponibile</div>");
					$("#submit").show('fast');
				}
				else {
					$('#usernameError').html("<div style=\"color: red; font-weight: bold;\">Non disponibile</div>");
					$("#submit").hide('fast');
				}
			}
		});
	}
	
	function checkFields() {
		error = false;

		checkPassword(this);
		checkEmail(this);
		
		var value = $("input[@name=type]:checked").val();

		if (value == "Azienda")
			checkAzienda(this);
		if (value == "Privato")
			checkPrivato(this);
			
		if (error)
			$("#submit").hide('fast');
		else
			$("#submit").show('fast');
	
		checkUsername();
		if(error)
			return false;
		return true;
	}
	function add(value) {
		if (value == "Privato") {
			$(".privato").removeClass("hide");
			$(".azienda").addClass("hide");
		} else {
			$(".privato").addClass("hide");
			$(".azienda").removeClass("hide");
			$("#dataNascita").val("1900-01-01");
		}
	}
</script>

<form:form method="POST" commandName="registrationInfo" onsubmit="return checkFields()">
	<table>
		<tr>
			<td>User Name</td>
			<td><form:input path="username" onkeyup="checkUsername(this)" /></td>
			<td><form:errors path="username" cssClass="error" /><div id="usernameError"></div></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" onkeyup="checkPassword(this)" /></td>
			<td><form:errors path="password" cssClass="error" /><div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><form:password path="confirmPassword" onkeyup="checkPassword(this)"  /></td>
			<td><form:errors path="confirmPassword" cssClass="error" /><div id="confirmPasswordError"></div></td>
		</tr>
		<tr>
			<td>eMail</td>
			<td><form:input path="email" onkeyup="checkEmail(this)" /></td>
			<td><form:errors path="email" cssClass="error" /><div id="emailError"></div></td>
		</tr>
		<tr>
			<td>Confirm eMail</td>
			<td><form:input path="confirmEmail" onkeyup="checkEmail(this)" /></td>
			<td><form:errors path="confirmEmail" cssClass="error" /><div id="confirmEmailError"></div></td>
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
			<td><form:input path="piva" onkeyup="checkAzienda(this)" /></td>
			<td><form:errors path="piva" cssClass="error" /><div id="pivaError"></div></td>
		</tr>
		<tr class="azienda hide">
			<td>Ragione Sociale</td>
			<td><form:input path="ragioneSociale" onkeyup="checkAzienda(this)" /></td>
			<td><form:errors path="ragioneSociale" cssClass="error" /><div id="ragioneSocialeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Cognome</td>
			<td><form:input path="cognome" onkeyup="checkPrivato(this)" /></td>
			<td><form:errors path="cognome" cssClass="error" /><div id="cognomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Nome</td>
			<td><form:input path="nome" onkeyup="checkPrivato(this)" /></td>
			<td><form:errors path="nome" cssClass="error" /><div id="nomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Data di Nascita</td>
			<td><form:input path="dataNascita" onkeyup="checkPrivato(this)" /></td>
			<td><form:errors path="dataNascita" cssClass="error" /><div id="dataNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Luogo di Nascita</td>
			<td><form:input path="luogoNascita" onkeyup="checkPrivato(this)" /></td>
			<td><form:errors path="luogoNascita" cssClass="error" /><div id="luogoNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Codice Fiscale</td>
			<td><form:input path="codiceFiscale" onkeyup="checkPrivato(this)" /></td>
			<td><form:errors path="codiceFiscale" cssClass="error" /><div id="codiceFiscaleError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit"></td>
		</tr>
	</table>
</form:form>
