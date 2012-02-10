<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
	function elimina(idUtente) {
		$.ajax({
			url : 'eliminaUtente.htm',
			type: "POST",
			data : ({
				id : idUtente,
			}),
			success : function(res) {
				$("#"+idUtente).hide();
			}
		});
	}
</script>

<table cellpadding=3>
	<tr>
		<th>Username</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr id="${user.id}">
			<td><c:out value="${user.username}" /></td>
			<td><input type="button" value="Elimina" onclick="elimina(${user.id})">
		</tr>
	</c:forEach>
</table>