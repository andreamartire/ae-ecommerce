<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
	function elimina(idCategoria) {
		$.ajax({
			url : 'eliminaCategoria.htm',
			type: "POST",
			data : ({
				id : idCategoria,
			}),
			success : function(res) {
				$("#"+idCategoria).hide();
			}
		});
	}
	function modifica(idCategoria) {
		$.ajax({
			url : 'modificaCategoria.htm',
			type: "POST",
			data : ({
				id : idCategoria,
			}),
			success : function(res) {
				alert("modifica " + idCategoria);
// 				$("#"+idCategoria).hide();
			}
		});
	}
	function aggiungi() {
// 		$.ajax({
// 			url : 'addCategoria.htm',
// 			type: "POST",
// 			data : ({
// 				nome : idCategoria,
// 			}),
// 			success : function(res) {
// 				alert("modifica " + idCategoria);
// // 				$("#"+idCategoria).hide();
// 			}
// 		});
	}
</script>

<p>Elenco Categorie</p>

<input id="aggiungiCategoria" type="button" value="Aggiungi Categoria" onclick="aggiungi()"/>

<div id="aggiungiCategoria" style="display: null">
	
</div>

<table cellpadding=3>
	<tr>
	
		<th>Nome</th>
		<th>Descrizione<th>
	</tr>
	<c:forEach var="categoria" items="${categorie}">
		<c:if test="categoria.parent==null">
			<tr id="${categoria.id}">
				<td><c:out value="${categoria.nome}" /></td>
				<td><c:out value="${categoria.descrizione}" /></td>
				<td><input type="button" value="Aggiungi" onclick="aggiungi()"></td>
				<td><input type="button" value="Modifica" onclick="modifica(${categoria.id})"></td>
				<td><input type="button" value="Elimina" onclick="elimina(${categoria.id})"></td>
			</tr>
		</c:if>
	</c:forEach>
</table>