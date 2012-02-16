<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<a href="home.htm">Home</a> > Gestione Pagina Contattaci
<hr></hr>
<form:form method="POST" commandName="document">
	<table>
		<tr>
			<td><form:textarea path="contattaci" type="text" cols="60" rows="15"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
