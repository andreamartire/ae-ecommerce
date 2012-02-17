<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function elimina(id){
	if (confirm("Confermi eliminazione?"))
		location.href = "eliminaRecapitoAdmin.htm?idRecapito=" + id;
}
</script>
<a href="home.htm">Home</a> > <a href="gestioneUtenti.htm">Gestione Utenti</a> > <a href="gestioneUtente.htm?id=${userdb.id}">Gestione Utente ${userManaged}</a> > Gestione Recapiti
<hr></hr>

<form:form method="post" commandName="userdb">
	<table>
		<c:forEach items="${userdb.recapiti}" var="i" varStatus="row">
			<tr><td>Tipo</td><td><form:input path="recapiti[${row.index}].tipo" /></td></tr>
			<tr><td>Valore</td><td><form:input path="recapiti[${row.index}].valore" /></td></tr>
			<tr><td><input type="button" value="Elimina" onclick="elimina(${i.id})"></input></td></tr>
			<tr><td colspan="2"><hr></hr></td></tr>
		</c:forEach>
		<tr><td colspan="2"><input type="submit" value="Salva Modifiche"></td></tr>
   </table>
</form:form>

<a href="aggiungiRecapitoAdmin.htm"><button>Aggiungi Recapito</button></a>