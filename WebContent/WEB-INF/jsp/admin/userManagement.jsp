<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
	function modifica(idUtente) {
		location.href="modificaUtente.htm?id="+idUtente;
	}
	function elimina(id){
		if (confirm("Confermi eliminazione?"))
			location.href = "eliminaUtente.htm?id=" + id;
	}
</script>
<a href="home.htm">Home</a> > Gestione Utenti

<table cellpadding=3>
	<tr>
		<th>Username</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr id="${user.id}">
			<td><c:out value="${user.username}" /></td>
			<td><input type="button" value="Modifica" onclick="modifica(${user.id})"></td>
			<td><input type="button" value="Elimina" onclick="elimina(${user.id})"></td>
		</tr>
	</c:forEach>
</table>