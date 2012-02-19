<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<a href="home.htm">Home</a> &gt; Registrazione
<hr />

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
		// All'avvio usa di default i campi del privato
		add("Privato");
		
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

	function checkPassword(obj) {
		//password
		$('#passwordError').html("");
		if ($('#password').val() == "") {
			$('#passwordError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
		} else if ($('#password').val().length < 8)
			$('#passwordError').html("<div style=\"color: red; font-weight: bold;\">Debole</div>");
		else if ($('#password').val().length < 13)
			$('#passwordError').html("<div style=\"color: orange; font-weight: bold;\">Media</div>");
		else if ($('#password').val().length < 20)
			$('#passwordError').html("<div style=\"color: green; font-weight: bold;\">Forte</div>");
	}
	
	function checkConfirmPassword(obj) {
		//confirm password
		$('#confirmPasswordError').html("");
		if ($('#password').val() != $('#confirmPassword').val()) {
			$('#confirmPasswordError').html("<div style=\"color: red; font-weight: bold;\">Non coincide</div>");
			obj.error = true;
		} 
	}

	function checkEmail(obj) {
		//email
		$('#emailError').html("");
		var mailRegExp = /^[a-z|A-Z|0-9|\.|\-|_]+@\w+\.[a-z|A-Z]+$/i;
		if (!$('#email').val().match(mailRegExp)) {
			$('#emailError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
		}
	}

	function checkConfirmMail(obj) {
		//confirm email
		$('#confirmEmailError').html("");
		if ($('#email').val() != $('#confirmEmail').val()) {
			$('#confirmEmailError').html("<div style=\"color: red; font-weight: bold;\">Non coincide</div>");
			obj.error = true;
		}
	}
	
	function checkPiva(obj) {
		//piva
		$('#pivaError').html("");
		var e = /^\d{11}$/;
		if (!$('#piva').val().match(e)) {
			$('#pivaError').html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
		}
	}

	function checkRagioneSociale(obj) {
		//ragSociale
		$("#ragioneSocialeError").html("");
		if (!$("#ragioneSociale").val().match(/^[a-zA-Z\s]+$/)) {
			$("#ragioneSocialeError").html("<div style=\"color: red; font-weight: bold;\">Non valida</div>");
			obj.error = true;
		}
	}
	
	function checkCognome(obj) {
		//cognome
		$("#cognomeError").html("");
		if (!$("#cognome").val().match(/^[a-zA-Z\s]+$/)) {
			$("#cognomeError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
		}
	}
	
	function checkNome(obj) {
		//nome
		$("#nomeError").html("");
		if (!$("#nome").val().match(/^[a-zA-Z\s]+$/)) {
			$("#nomeError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
		}
	}
	
	function checkDataNascita(obj) {
		//dataNascita
		$("#dataNascitaError").html("");
		if (!$("#datepicker").val().match(/^\d{4}\-\d{2}\-\d{2}$/)) {
			$("#dataNascitaError").html("<div style=\"color: red; font-weight: bold;\">Richiesto yyyy-MM-dd</div>");
			obj.error = true;
		}
	}
	
	function checkLuogoNascita(obj) {
		//luogoNascita
		$("#luogoNascitaError").html("");
		if (!$("#luogoNascita").val().match(/^[a-zA-Z\s]+$/)) {
			$("#luogoNascitaError").html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
		}
	}

	function checkCodFisc(obj) {
		//codice fiscale
		$('#codiceFiscaleError').html("");
		var e = /^[a-zA-Z]{6}\d{2}[a-zA-Z]{1}\d{2}[a-zA-Z]{1}\d{3}[a-zA-Z]{1}$/;
		if (!$('#codiceFiscale').val().match(e)) {
			$('#codiceFiscaleError').html("<div style=\"color: red; font-weight: bold;\">Non valido</div>");
			obj.error = true;
		}
	}
	
	function checkUsername() {
		// username
		if (!$('#username').val().match(/^\w+$/)) {
			$("#submit").hide('fast');
			$('#usernameError').html("<div style=\"color: red; font-weight: bold;\">Username richiesto</div>");
		} else {
			$.ajax({
				url : 'checkUsername.htm',
				type : "POST",
				data : ({
					username : $('#username').val()
				}),
				success : function(res) {
					if (res == "available") {
						$('#usernameError').html("<div style=\"color: green; font-weight: bold;\">Disponibile</div>");
						$("#submit").show('fast');
					} else {
						$('#usernameError').html("<div style=\"color: red; font-weight: bold;\">Non disponibile</div>");
						$("#submit").hide('fast');
					}
				}
			});
		}
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
		if (error)
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

<form:form method="POST" commandName="registrationInfo">
	<table>
		<tr>
			<td>User Name</td>
			<td><form:input path="username" onblur="checkUsername(this)" /></td>
			<td><form:errors path="username" cssClass="error" />
				<div id="usernameError"></div></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" onblur="checkPassword(this)" /></td>
			<td><form:errors path="password" cssClass="error" />
				<div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><form:password path="confirmPassword" onblur="checkConfirmPassword(this)" /></td>
			<td><form:errors path="confirmPassword" cssClass="error" />
				<div id="confirmPasswordError"></div></td>
		</tr>
		<tr>
			<td>eMail</td>
			<td><form:input path="email" onblur="checkEmail(this)" /></td>
			<td><form:errors path="email" cssClass="error" />
				<div id="emailError"></div></td>
		</tr>
		<tr>
			<td>Confirm eMail</td>
			<td><form:input path="confirmEmail" onblur="checkConfirmMail(this)" /></td>
			<td><form:errors path="confirmEmail" cssClass="error" />
				<div id="confirmEmailError"></div></td>
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
			<td><form:input path="piva" onblur="checkPiva(this)" /></td>
			<td><form:errors path="piva" cssClass="error" />
				<div id="pivaError"></div></td>
		</tr>
		<tr class="azienda hide">
			<td>Ragione Sociale</td>
			<td><form:input path="ragioneSociale"
					onblur="checkRagioneSociale(this)" /></td>
			<td><form:errors path="ragioneSociale" cssClass="error" />
				<div id="ragioneSocialeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Cognome</td>
			<td><form:input path="cognome" onblur="checkCognome(this)" /></td>
			<td><form:errors path="cognome" cssClass="error" />
				<div id="cognomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Nome</td>
			<td><form:input path="nome" onblur="checkNome(this)" /></td>
			<td><form:errors path="nome" cssClass="error" />
				<div id="nomeError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Data di Nascita</td>
			<td><form:input path="dataNascita" id="datepicker" type="text"
					onblur="checkDataNascita(this)" value="1980-01-01" /></td>
			<td><form:errors path="dataNascita" cssClass="error" />
				<div id="dataNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Luogo di Nascita</td>
			<td><form:input path="luogoNascita" onblur="checkLuogoNascita(this)" /></td>
			<td><form:errors path="luogoNascita" cssClass="error" />
				<div id="luogoNascitaError"></div></td>
		</tr>
		<tr class="privato hide">
			<td>Codice Fiscale</td>
			<td><form:input path="codiceFiscale"
					onblur="checkCodFisc(this)" /></td>
			<td><form:errors path="codiceFiscale" cssClass="error" />
				<div id="codiceFiscaleError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input id="submit" type="submit"></td>
		</tr>
	</table>
</form:form>
