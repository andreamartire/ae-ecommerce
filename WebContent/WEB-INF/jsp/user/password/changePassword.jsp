<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function checkPassword() {
	$(".error").html('');
	if( $('#confirmPassword').val().length < 8){
		$('#passwordError').html("<h5 style=\"color: red;\">Debole</h5>");
		return;
	}
	if( $('#confirmPassword').val().length < 13){
		$('#passwordError').html("<h5 style=\"color: yellow;\">Media</h5>");
		return;
	}
	if( $('#confirmPassword').val().length < 20){
		$('#passwordError').html("<h5 style=\"color: green;\">Forte</h5>");
		return;
	}
}
function checkConfirmPassword() {
	$(".error").html('');
	if( $('#confirmPassword2').val() != $('#confirmPassword').val()){
		$('#confirmPasswordError').html("<h5 style=\"color: red;\">Non coincide</h5>");
		return;
	}
	$('#confirmPasswordError').html("<h5 style=\"color: green;\">Coincide</h5>");
	return;
}
</script>
<a href="home.htm">Home</a> > <a href="account.htm">Gestione Account</a> > Cambio Password

<form:form method="POST" commandName="info">
	<table>
		<tr>
			<td>Old Password </td>
			<td><form:input path="password" type="password" /></td>
			
		</tr>
		<tr>
			<td>New Password </td>
			<td><form:input path="confirmPassword" type="password" onkeyup="checkPassword()"/></td>
			<td><div id="passwordError"></div></td>
		</tr>
		<tr>
			<td>New Password </td>
			<td><input id="confirmPassword2" type="password" onkeyup="checkConfirmPassword()"/></td>
			<td><div id="confirmPasswordError"></div></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
