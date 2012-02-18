<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/js/ckeditor/mytoolbar.js"></script>

<a href="home.htm">Home</a> &gt; Gestione Pagina Contattaci
<hr></hr>
<form:form method="POST" commandName="document">
	<table>
		<tr>
			<td><form:textarea class="ckeditor" id="editor" name="editor" path="contattaci" type="text" cols="60" rows="15"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
