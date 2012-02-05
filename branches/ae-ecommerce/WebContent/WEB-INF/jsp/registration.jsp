<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	Insert your data

	<form:form method="POST" commandName="registrationInfo">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><form:password path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><form:radiobutton id="radioPrivato" path="type" value="Privato" label="Privato" onclick="add(this.value)"/>
					<form:radiobutton id="radioAzienda" path="type" value="Azienda" label="Azienda" onclick="add(this.value)"/>
					<form:errors path="type" cssClass="error" /></td>
			</tr>
<!-- 			Azienda -->
			<tr class="azienda hide">
				<td>Partita IVA :</td>
				<td><form:input path="piva"/></td>
				<td><form:errors path="piva" cssClass="error" /></td>
			</tr>
			<tr class="azienda hide">
				<td>Ragione Sociale :</td>
				<td><form:input path="ragioneSociale"/></td>
				<td><form:errors path="ragioneSociale" cssClass="error" /></td>
			</tr>
			<tr class="privato hide">
				<td>Cognome :</td>
				<td><form:input path="cognome"/></td>
				<td><form:errors path="cognome" cssClass="error" /></td>
			</tr>
			<tr class="privato hide">
				<td>Nome :</td>
				<td><form:input path="nome"/></td>
				<td><form:errors path="nome" cssClass="error" /></td>
			</tr>
			<tr class="privato hide">
				<td>Data di Nascita :</td>
				<td><form:input path="dataNascita"/></td>
				<td><form:errors path="dataNascita" cssClass="error" /></td>
			</tr>
			<tr class="privato hide">
				<td>Luogo di Nascita :</td>
				<td><form:input path="luogoNascita"/></td>
				<td><form:errors path="luogoNascita" cssClass="error" /></td>
			</tr>
			<tr class="privato hide">
				<td>Codice Fiscale :</td>
				<td><form:input path="codiceFiscale"/></td>
				<td><form:errors path="codiceFiscale" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<a href="home.htm"><button>Back</button></a>
</body>
</html>