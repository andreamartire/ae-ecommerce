<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p>Aggiungi una categoria</p>

<form:form method="post" action="aggiungiCategoria">
	<table>
	<tr>
		<td><form:label path="nome">Nome</form:label></td>
		<td><form:input path="nome" /></td> 
	</tr>
	<tr>
		<td><form:label path="descrizione">Descrizione</form:label></td>
		<td>	
			<form:input path="descrizione" />
			<input type="hidden" name="parentId" value="${parentId}" />
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Aggiungi"/></td>
	</tr>
</table>	
	
</form:form>