<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>

<a href="home.htm">Home</a> > Gestione F.A.Q.
<hr></hr>
<form:form method="POST" commandName="document">
	<table>
		<tr>
			<td><form:textarea class="ckeditor" id="editor" name="editor" path="faq" type="text" cols="60" rows="15"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
