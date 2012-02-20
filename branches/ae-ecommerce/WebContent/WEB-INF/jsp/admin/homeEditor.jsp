<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/js/ckeditor/mytoolbar.js"></script>

<style type="text/css">
.cke_contents {
	height: 400px !important;
	width: 800px !important;
}
</style>

<a href="home.htm">Home</a> &gt; Gestione Home.
<hr></hr>
<form:form method="POST" commandName="document">
	<table>
		<tr>
			<td><form:textarea class="ckeditor" id="editor" name="editor" path="home" type="text" cols="60" rows="30"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input style="font-size: 14pt; font-weight: bold;" type="submit" value="Salva Modifiche"></td>
		</tr>
	</table>
</form:form>
