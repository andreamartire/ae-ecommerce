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
	
	function aggiungiProdotto(idProd) {
		$.ajax({
			url : 'aggiungiProdottoVetrina.htm',
			type: "POST",
			data : ({
				idProdotto : idProd
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
				Object.size = function(obj) {
				    var size = 0, key;
				    for (key in obj) {
				        if (obj.hasOwnProperty(key)) size++;
				    }
				    return size;
				};

				// Get the size of an object
				var size = Object.size(jsonProdotti.prodotti);
				if(size > 0){
					html = "<span id='spanProdotti" + idCategoria + "'>" +
								"Prodotti" + 
							"</span>" +
							"<ul id='ulProdotti" + idCategoria + "'>";
					$.each(jsonProdotti.prodotti, function(key, prod) {
						html += "<li><span>"+prod.nome+"</span>" +
									"<button onclick='aggiungiProdotto(" + prod.id + ")'>" +
										"<img src=\"resources/images/add.png\"/>" +
									"</button>" +
								"</li>";
					});
					html += "</ul>";
					$('#prodotti'+idCategoria).html(html);
	
					refreshTree();
				}
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
				"<li id='li"+categoria.id+"'>" +
					"<span>" +
						"<b id='nome"+categoria.id+"'>" + categoria.nome + "</b>" +
					"</span>";
			html += "<ul>" + 
						"<li id='prodotti"+categoria.id+"'></li>";
			if (categoria.children != "") {
				$.each(categoria.children, function(key, subcat) {
					// sotto categoria
					html +=
						"<li id='li"+subcat.id+"'>" +
							"<span>" +
								"<b id='nome"+subcat.id+"'>" + subcat.nome + "</b>" +
							"</span>" +
							"<ul>" +
								"<li id='prodotti"+subcat.id+"'></li>";
					if (subcat.children != "") {
						$.each(subcat.children, function(key, subsubcat) {
							// sotto sotto categoria
							html += 
								"<li id='li"+subsubcat.id+"'>" +
									"<span>" +
										"<b id='nome"+subsubcat.id+"'>" + subsubcat.nome + "</b>" +
									"</span>" +
									"<ul>" +
										"<li id='prodotti"+subsubcat.id+"'></li>" +
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
	function creaListaProdotti(data) {
		$.each(data.categorie, function(key, categoria) {
			listProdotti(categoria.id);
			if (categoria.children != "") {
				$.each(categoria.children, function(key, subcat) {
					listProdotti(subcat.id);
					if (subcat.children != "") {
						$.each(subcat.children, function(key, subsubcat) {
							listProdotti(subsubcat.id);
						});
					}
				});
			} 
		});
	}
	
	$(document).ready(function(){
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: function(data) {
				creaListaCategorie(data);
				creaListaProdotti(data);
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
				<td style="width: 50%;"><b>Nome</b></td><td>${prodotto.nome}</td>
			</tr>
			<tr>
				<td><b>Prezzo</b></td><td>${prodotto.prezzoUnitario} euro</td>
			</tr>
			<tr>
				<td><b>Descrizione</b></td>
				<td>${prodotto.descrizione}</td><td> </td>
				<td align="right">
					<button onclick="elimina(${prodotto.id})"><img src="resources/images/delete.png"/></button>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>
