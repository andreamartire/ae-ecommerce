<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
<script src="resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">	
	function elimina(idProdotto){
		if (confirm("Confermi eliminazione dalla Vetrina?")) {
			$.ajax({
				url : 'eliminaProdottoVetrina.htm',
				type: "POST",
				data : ({
					idProdotto : idProdotto
				}),
				success : function(res) {
					$('.prodotto'+idProdotto).hide();
				},
				error: function (xhr, ajaxOptions, thrownError) {
					alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.requestText );
				}
			});
		}
	}
	
	function showAggiungi() {
		$('#aggiungiProdotto').fadeIn('slow');
	}
	
	function annullaAggiungi() {
		$('#aggiungiProdotto').fadeOut('slow');
	}
	
	function aggiungi() {
		$.ajax({
			url : 'aggiungiProdottoVetrina.htm',
			type: "POST",
			data : ({
				idProdotto :$('#idProdotto').html()
			}),
			success : function(res) {
				location.reload();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
		annullaAggiungi();
	}
	
	function refreshTree() {
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
	
	function load(jsonProdotti, idCategoria) {
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: function(categorie) {	
				html = "<span id='insLiProdotti" + idCategoria + "'><ul id='insUlProdotti" + idCategoria + "'>";
				$.each(jsonProdotti.prodotti, function(key, prod) {
					html += "<li><span>"+prod.nome+"</span></li>";
				});
				$('#prodotti'+idCategoria).html(html);
// 				$('#prodotti'+idCategoria).html("<span class=\"folder\">Subfolder 2.1</span>"+
// 									"	<ul id=\"folder21\">"+
// 									"		<li><span class=\"file\">File 2.1.1</span></li>"+
// 									"		<li><span class=\"file\">File 2.1.2</span></li>"+
// 									"	</ul>");

				refreshTree();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
	}
	
	function listProdotti(idCategoria) {
		$.ajax({
			url : 'listProdotti.htm',
			type: "GET",
			data : ({
				idCategoria : idCategoria
			}),
			dataType: 'json',
			success: function (jsonProdotti) {
				load(jsonProdotti, idCategoria);
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
	}
	
	function creaListaCategorie(data) {
		$.each(data.categorie, function(key, categoria) {
				// categoria
			var html = 
				"<li id='li"+categoria.id+"'" +
					"onmouseover='$(\"#span"+categoria.id+"\").show()'" +
					"onmouseout='$(\"#span"+categoria.id+"\").hide()'>" +
					"<span>" +
						"<b id='nome"+categoria.id+"'>" + categoria.nome + "</b>" +
					"</span>" +
					"<a onclick='listProdotti("+categoria.id+")'>prodotti</a>";
			html += "<ul><li id='prodotti"+categoria.id+"'></li>";
			if (categoria.children != "") {
				$.each(categoria.children, function(key, subcat) {
						// sotto categoria
					html +=
						"<li id='li"+subcat.id+"'" +
								"onmouseover='$(\"#span"+subcat.id+"\").show()'" +
								"onmouseout='$(\"#span"+subcat.id+"\").hide()'>" +
							"<span>" +
								"<b id='nome"+subcat.id+"'>" + subcat.nome + "</b>" +
							"</span>" +
							" <a onclick='listProdotti("+subcat.id+")'>prodotti</a>";
					html += "<ul><li id='prodotti"+subcat.id+"'></li>";
					if (subcat.children != "") {
						$.each(subcat.children, function(key, subsubcat) {
								// sotto sotto categoria
							html += 
								"<li id='li"+subsubcat.id+"'" +
										"onmouseover='$(\"#span"+subsubcat.id+"\").show()'" +
										"onmouseout='$(\"#span"+subsubcat.id+"\").hide()'>" +
									"<span>" +
										"<b id='nome"+subsubcat.id+"'>" + subsubcat.nome + "</b>" +
									"</span>" +
									"<ul id='prodotti"+subsubcat.id+"'>" +
										"<li>" +
											"<a onclick='listProdotti("+subsubcat.id+")'>Elenca prodotti</a>" +
											"<ul><li id='prodotti"+subsubcat.id+"'></li></ul>" +
										"</li>" +
									"</ul>" +
								"</li>";
						});
					}
					html += "</ul>";
							// fine sotto sotto categoria
					html += 
						"</li>";
						// fine sotto categoria
				});
			} 
			html += "</ul>" +
				"</li>";
				// fine categoria
			
			$("#listaCategorie").append(html);
		});
	}
	
	$(document).ready(function(){
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: function(data) {
				creaListaCategorie(data);
				refreshTree();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
	});
</script>

<a href="home.htm">Home</a> &gt; Gestione Vetrina
<hr></hr> 

<a onclick="showAggiungi()"><button>Aggiungi Prodotto</button></a>
<div style="display: none" id="aggiungiProdotto">

<ul id="listaCategorie" class="treeview-gray">
	<!-- contenuto dinamico -->
</ul>
	
</div>

<hr/>
Prodotti in Vetrina
<hr></hr> 

<c:forEach var="prodotto" items="${prodottiVetrina}">
	<div class="prodotto${prodotto.id}">
		<table style="width: 600px; padding: 5px">
			<tr>
				<td><b>Nome</b><input type="text" name="nome" id="nomeProdotto${prodotto.id}" value="${prodotto.nome}" /></td>
				<td><b>Prezzo</b><input type="number" name="prezzo" id="prezzoProdotto${prodotto.id}" style="width: 50px" value="${prodotto.prezzoUnitario}" /> Euro</td>
			</tr>
			<tr>
				<td colspan="2"><b>Descrizione</b></td>
				<td colspan="2" width="600">
					<textarea rows="4" cols="70" name="descrizione" id="descrizioneProdotto${prodotto.id}">${prodotto.descrizione}</textarea>
				</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					<button onclick="elimina(${prodotto.id})"><img src="resources/images/delete.png"/></button>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>
