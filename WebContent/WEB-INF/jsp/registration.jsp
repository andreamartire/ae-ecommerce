<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 	<script type="text/javascript" src="/js/jquery-1.7.1.js"></script> -->
<!-- 	<script type="text/javascript" src="../js/jquery-1.7.1.js"></script> -->
<!-- 	<script type="text/javascript" src="js/jquery-1.7.1.js"></script> -->
<!-- 	<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script> -->
	<script type="text/javascript">
	function add(value){
		if(value=="privato"){
			$("input.privato").removeAttr("disabled");
			$("input.azienda").attr("disabled","disabled");
		}
		else{
			$("input.azienda").removeAttr("disabled");
			$("input.privato").attr("disabled","disabled");
		}
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
				<td><form:radiobutton path="type" value="privato" label="Privato" onclick="add(this.value)"/>
					<form:radiobutton path="type" value="azienda" label="Azienda" onclick="add(this.value)"/>
					<form:errors path="type" cssClass="error" /></td>
			</tr>
<!-- 			Azienda -->
			<tr>
				<td>Partita IVA :</td>
				<td><form:input path="piva" class="azienda" disabled="true"/></td>
				<td><form:errors path="piva" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Codice Fiscale :</td>
				<td><form:input path="codiceFiscale" class="privato" disabled="true"/></td>
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