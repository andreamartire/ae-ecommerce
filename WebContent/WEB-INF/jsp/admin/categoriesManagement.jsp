<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>

<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%-- <%@ page pageEncoding="UTF-8" %> --%>

<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
<script src="resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
	function elimina(idCategoria) {
		if (confirm("Confermi eliminazione?")) {
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
	}
	function modifica(idCategoria, nome) {
		var name = prompt("Inserisci il nuovo nome", nome);
		if (name!=null && name!="")
		{
			$.ajax({
				url : 'modificaCategoria.htm',
				type: "POST",
				data : ({
					id : idCategoria,
					nome : name
				}),
				success : function(res) {
					location.reload();
				}
			});
		}
	}

	function aggiungi(idCategoria) {
		if ($('#'+idCategoria).val() != "") {
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
						" - <a onclick='modifica("+categoria.id+",\""+categoria.nome+"\")'>Modifica</a>" +
						" - <a onclick='elimina("+categoria.id+")'>Elimina</a>" +
						"</span>" +
					"</span>";
				html += 
					"<ul><li>" +
						"<a onclick='aggiungi("+categoria.id+")'>Aggiungi</a>: " +
						"<input id='"+categoria.id+"'type='text' style='width: 150px' />" +
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
								" - <a onclick='modifica("+subcat.id+","+subcat.nome+")'>Modifica</a>" +
								" - <a onclick='elimina("+subcat.id+")'>Elimina</a>" +
								"</span>" +
							"</span>";
						html += 
							"<ul><li>" +
							"<a onclick='aggiungi("+subcat.id+")'>Aggiungi</a>: " +
							"<input id='"+subcat.id+"'type='text' style='width: 150px' />" +
							"</li>";
						if (subcat.children != "")
						{
							$.each(subcat.children, function(key, subsubcat) {
								html += 
									"<li onmouseover='$(\"#span"+subsubcat.id+"\").show()'" +
											"onmouseout='$(\"#span"+subsubcat.id+"\").hide()'>" +
									"<span>" +
										"<b>" + subsubcat.nome + "</b>" +
										"<span id='span"+subsubcat.id+"' style='display: none'>" +
										" - <a onclick='modifica("+subsubcat.id+","+subsubcat.nome+")'>Modifica</a>" +
										" - <a onclick='elimina("+subsubcat.id+")'>Elimina</a>" +
										"</span>" +
									"</span>";
							});
						}
						html += "</ul>";
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

<div id="popupDialog" title="Input a new widget name" style="display: none">
	<p>
		<label for="widgetName">Please input a new widget name:</label> 
		<input type="text" id="widgetName" />
	</p>
</div>

<h4>Gestione Categorie</h4>

<p>
<a onclick='$("#add").fadeIn();'>Aggiungi Categoria</a><br/>
<span id="add" style="display: none">
	<input type="text" style="width: 150px" id="-1" /> 
	<a onclick='aggiungi(-1); $("#add").hide(); $("#-1").val("")'>Add</a>
</span>	
</p>

<ul id="listaCategorie" class="treeview-gray">
	<!-- contenuto dinamico -->
</ul>
