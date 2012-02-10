<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function elimina(id){
	if (confirm("Confermi eliminazione?"))
		location.href = "eliminaIndirizzo.htm?id=" + id;
}
</script>
<a href="home.htm">Home</a> > <a href="account.htm">Gestione Account</a> > Gestione Indirizzi

<form:form method="post" commandName="userdb">
	<table>
		<c:forEach items="${userdb.indirizzi}" var="i" varStatus="row">
			<tr><td colspan="2"><hr></hr></td></tr>
			<tr><td>Via</td><td><form:input path="indirizzi[${row.index}].via" /></td></tr>
			<tr><td>Numero</td><td><form:input path="indirizzi[${row.index}].numero" /></td></tr>
			<tr><td>Citta</td><td><form:input path="indirizzi[${row.index}].citta" /></td></tr>
			<tr><td>Provincia</td><td><form:input path="indirizzi[${row.index}].provincia" /></td></tr>
			<tr><td>CAP</td><td><form:input path="indirizzi[${row.index}].cap" /></td></tr>
			<tr><td><input type="button" value="Elimina" onclick="elimina(${i.id})"></input></td></tr>
		</c:forEach>
		<tr><td colspan="2"><input type="submit" value="Salva Modifiche"></td></tr>
   </table>
</form:form>

<a href="aggiungiIndirizzo.htm"><button>Aggiungi Indirizzo</button></a>
