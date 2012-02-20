<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function checkPassword() {
	$(".error").html('');
	if( $('#confirmPassword').val().length < 8){
		$('#passwordError').html("<font style=\"color: red;\">Debole</font>");
		return;
	}
	if( $('#confirmPassword').val().length < 13){
		$('#passwordError').html("<font style=\"color: yellow;\">Media</font>");
		return;
	}
	if( $('#confirmPassword').val().length < 20){
		$('#passwordError').html("<font style=\"color: green;\">Forte</font>");
		return;
	}
}
function checkConfirmPassword() {
	$(".error").html('');
	if( $('#confirmPassword2').val() != $('#confirmPassword').val()){
		$('#confirmPasswordError').html("<font style=\"color: red;\">Non coincide</font>");
		return;
	}
	$('#confirmPasswordError').html("<font style=\"color: green;\">Coincide</font>");
	return;
}
</script>
<a href="home.htm">Home</a> &gt; <a href="account.htm">Gestione Account</a> &gt; Cambio Password
<hr></hr>
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
