<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript"></script>
<a href="home.htm">Home</a> > <a href="gestioneUtenti.htm">Gestione Utenti</a> > Gestione Utente ${userManaged}
<hr></hr>
<table>
	<tr>
		<td><a href="modificaUtente.htm?id=${id}">Gestione Anagrafica</a></td>
	</tr>
	<tr>
		<td><a href="gestioneIndirizziAdmin.htm?id=${id}">Gestione Indirizzi</a></td>
	</tr>
	<tr>
		<td><a href="gestioneRecapitiAdmin.htm?id=${id}">Gestione Recapiti</a></td>
	</tr>
</table>