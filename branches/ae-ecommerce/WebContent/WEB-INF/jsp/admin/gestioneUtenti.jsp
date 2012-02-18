<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
	function modifica(idUtente) {
		location.href="gestioneUtente.htm?id="+idUtente;
	}
	function elimina(id){
		if (confirm("Confermi eliminazione?"))
			location.href = "eliminaUtente.htm?id=" + id;
	}
</script>
<a href="home.htm">Home</a> &gt; Gestione Utenti
<hr></hr>
<table style="padding: 3px">
	<tr>
		<th>Username</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr id="${user.id}">
			<td><c:out value="${user.username}" /></td>
			<td><a onclick='modifica(${user.id})'><img src='resources/images/edit.png'/></a></td>
			<td><a onclick='elimina(${user.id})'><img src='resources/images/delete.png'/></a></td>
		</tr>
	</c:forEach>
</table>