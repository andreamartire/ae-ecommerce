<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>

<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%-- <%@ page pageEncoding="UTF-8" %> --%>

<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
<script src="resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
	function elimina(idCategoria) {
		$.ajax({
			url : 'eliminaCategoria.htm',
			type: "POST",
			data : ({
				id : idCategoria,
			}),
			success : function(res) {
				location.reload();
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
			}
		});
	}
	function aggiungi(idCategoria) {
		$.ajax({
			url : 'aggiungiCategoria.htm',
			type: "POST",
			data : ({
				parentId : idCategoria,
				nome : $('#'+idCategoria).val()
			}),
			success : function(res) {
				location.reload();
			}
		});
	}
	$(document).ready(function(){
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: creaListaCategorie,
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
		function creaListaCategorie(data) {
			$.each(data.categorie, function(key, categoria) {
				var html = 
					"<li onmouseover='$(\"#span"+categoria.id+"\").show()'" +
							"onmouseout='$(\"#span"+categoria.id+"\").hide()'>" +
					"<span>" +
						"<b>" + categoria.nome + "</b>" +
						"<span id='span"+categoria.id+"' style='display: none'>" +
						" - <a onclick='modifica("+categoria.id+")'>Modifica</a>" +
						" - <a onclick='elimina("+categoria.id+")'>Elimina</a>" +
						"</span>" +
					"</span>";
				html += 
					"<ul><li>" +
						"<a onclick=\"aggiungi("+categoria.id+")\">Aggiungi sottocategoria</a>: " +
						"<input id=\""+categoria.id+"\" type=\"text\" name=\"newcat\" />" +
					"</li>";
				if (categoria.children != "")
				{
					$.each(categoria.children, function(key, subcat) {
						html += 
							"<li onmouseover='$(\"#span"+subcat.id+"\").show()'" +
									"onmouseout='$(\"#span"+subcat.id+"\").hide()'>" +
							"<span>" +
								"<b>" + subcat.nome + "</b>" +
								"<span id='span"+subcat.id+"' style='display: none'>" +
								" - <a onclick='modifica("+subcat.id+")'>Modifica</a>" +
								" - <a onclick='elimina("+subcat.id+")'>Elimina</a>" +
								"</span>" +
							"</span>";
					});
				}
				html += "</ul>";
				html += "</li>";
				
				$("#listaCategorie").append(html);
			});
			$("#listaCategorie").treeview({
				animated: "fast",
				collapsed: true,
				unique: true,
				persist: "cookie",
				toggle: function() {
					window.console && console.log("%o was toggled", this);
				}
			});
		}
	});
</script>

<h4>Gestione Categorie</h4>

<p>
<a onclick="aggiungi(-1)">Aggiungi Categoria</a>: <input type="text" id="-1" />
</p>

<ul id="listaCategorie" class="treeview-gray">
	<!-- contenuto dinamico -->
</ul>

<!-- <ul type="circle"> -->
<%-- <c:forEach var="categoria" items="${categorie}"> --%>
<%-- 	<c:if test="${categoria.parent == null}"> --%>
<%-- 		<li id="${categoria.id}"> --%>
<%-- 			<c:out value="${categoria.nome}" /> --%>
<%-- 			<button onclick="mostraSottocat(${categoria.id})">+</button> --%>
<%-- 			<button onclick="nascondiSottocat(${categoria.id})">-</button> --%>
<%-- 			<a href="aggiungiCategoria?parentId=${categoria.id}">Aggiungi</a> -  --%>
<%-- 			<a onclick="modifica(${categoria.id})">Modifica</a> -  --%>
<%-- 			<a onclick="elimina(${categoria.id})">Elimina</a> --%>
<!-- 		</li> -->
<!-- 		<ul> -->
<%-- 		<c:forEach var="sottocat" items="${categoria.children}"> --%>
<%-- 			<li id="sottocat${categoria.id}" style="display: none;"> --%>
<%-- 				<c:out value="${sottocat.nome}" /> --%>
<%-- 				<a onclick="modifica(${sottocat.id})">Modifica</a> --%>
<%-- 				<a onclick="elimina(${sottocat.id})">Elimina</a> --%>
<!-- 			</li> -->
<%-- 		</c:forEach> --%>
<!-- 		</ul> -->
<%-- 	</c:if> --%>
<%-- </c:forEach> --%>
<!-- </ul> -->