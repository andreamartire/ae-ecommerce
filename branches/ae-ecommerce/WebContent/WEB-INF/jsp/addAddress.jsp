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
</script>
<hr/> <p>Debug info = {userId=${userId}}</p> <hr/>
Inserisci il tuo indirizzo

<form:form method="POST" commandName="indirizzo">
	<table>
		<tr>
			<td>Via :</td>
			<td><form:input path="via" type="text"/></td>
		</tr>
		<tr>
			<td>Numero :</td>
			<td><form:input path="numero" type="text"/></td>
		</tr>
		<tr>
			<td>Citta' :</td>
			<td><form:input path="citta" type="text"/></td>
		</tr>
		<tr>
			<td>Provincia :</td>
			<td><form:input path="provincia" type="text"/></td>
		</tr>
		<tr>
			<td>CAP :</td>
			<td><form:input path="cap" type="text"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
<a href="home.htm"><button>Back</button></a>
