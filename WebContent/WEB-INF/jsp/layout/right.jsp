<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="POST" commandName="user" action="login.htm">
	<table>
		<tr>
			<td>Username</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
			<td><a href="registration.htm"><button>Registrati</button></a>
		</tr>
	</table>
</form:form>

<hr/>

<p>Il tuo carrello:</p>
<ul style="list-style-type: none; margin: 0; padding: 0">
	<li>Nessun elemento nel carrello</li>
</ul>
