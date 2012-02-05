<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
Login

<form:form method="POST" commandName="user" action="login.htm">
	<table>
		<tr>
			<td>User Name :</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>

<a href="registration.htm">Registration</a>
