<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/js/ckeditor/mytoolbar.js"></script>

<a href="home.htm">Home</a> &gt; Gestione Condizioni
<hr></hr>
<form:form method="POST" commandName="document">
	<table>
		<tr>
			<td><form:textarea class="ckeditor" id="editor" name="editor" path="conditions" type="text" cols="80" rows="30"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Salva"></td>
		</tr>
	</table>
</form:form>
