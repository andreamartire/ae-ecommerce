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
Inserisci il tuo indirizzo

<form method="POST" onsubmit="return checkFields()">
	<table>
		<tr>
			<td>Via :</td>
			<td><input id="via" type="text"/></td>
		</tr>
		<tr>
			<td>Numero :</td>
			<td><input id="numero" type="text"/></td>
		</tr>
		<tr>
			<td>Citta' :</td>
			<td><input id="citta" type="text"/></td>
		</tr>
		<tr>
			<td>Provincia :</td>
			<td><input id="provincia" type="text"/></td>
		</tr>
		<tr>
			<td>CAP :</td>
			<td><input id="cap" type="text"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
<a href="home.htm"><button>Back</button></a>
