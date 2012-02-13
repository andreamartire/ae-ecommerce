<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
<script src="resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
	function listProdotti(idCategoria) {
		$.ajax({
			url : 'listProdotti.htm',
			type: "GET",
			data : ({
				idCategoria : idCategoria
			}),
			dataType: 'json',
			success: function (data) {
				var html = "<li><span><a href='gestioneProdotti.htm?idCategoria="+idCategoria+"'>Gestione prodotti</a></span></li>";
				$.each(data.prodotti, function(key, prod) {
					html += "<li><span>"+prod.nome+"</span></li>";
				});
				$('#prodotti'+idCategoria).append(html);
				refreshTree();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
	}

	function elimina(idCategoria) {
		if (confirm("Confermi eliminazione?")) {
			$.ajax({
				url : 'eliminaCategoria.htm',
				type: "POST",
				data : ({
					id : idCategoria,
				}),
				success : function(res) {
// 					location.reload();
					$('#li'+idCategoria).hide();
				}
			});
		}
	}
	function modifica(idCategoria) {
		var name = prompt("Inserisci il nuovo nome", $('#nome'+idCategoria).text());
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
// 					location.reload();
					$('#nome'+idCategoria).text(name);
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
					// categoria
				var html = 
					"<li id='li"+categoria.id+"'" +
						"onmouseover='$(\"#span"+categoria.id+"\").show()'" +
						"onmouseout='$(\"#span"+categoria.id+"\").hide()'>" +
						"<span>" +
							"<b id='nome"+categoria.id+"'>" + categoria.nome + "</b>" +
							"<span id='span"+categoria.id+"' style='display: none'>" +
							" - <a onclick='modifica("+categoria.id+")'>Modifica</a>" +
							" - <a onclick='elimina("+categoria.id+")'>Elimina</a>" +
							"</span>" +
						"</span>";
				html += "<ul id='prodotti"+categoria.id+"'>" +
							"<li>" +
								"<a onclick='aggiungi("+categoria.id+")'>Aggiungi sottocategoria</a>: " +
								"<input id='"+categoria.id+"'type='text' style='width: 150px' /> - ";
				if (categoria.children == "") {
					html += 	"<a onclick='listProdotti("+categoria.id+")'>Elenca prodotti</a>" +
							"</li>";
				} else {
					$.each(categoria.children, function(key, subcat) {
							// sotto categoria
						html += 
							"</li>" +
							"<li onmouseover='$(\"#span"+subcat.id+"\").show()'" +
									"onmouseout='$(\"#span"+subcat.id+"\").hide()'>" +
								"<span>" +
									"<b id='nome"+subcat.id+"'>" + subcat.nome + "</b>" +
									"<span id='span"+subcat.id+"' style='display: none'>" +
									" - <a onclick='modifica("+subcat.id+")'>Modifica</a>" +
									" - <a onclick='elimina("+subcat.id+")'>Elimina</a>" +
									"</span>" +
								"</span>";
								// sotto sotto categoria
						html += "<ul>" +
									"<li>" +
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
											"<b id='nome"+subsubcat.id+"'>" + subsubcat.nome + "</b>" +
											"<span id='span"+subsubcat.id+"' style='display: none'>" +
											" - <a onclick='modifica("+subsubcat.id+")'>Modifica</a>" +
											" - <a onclick='elimina("+subsubcat.id+")'>Elimina</a>" +
											"</span>" +
										"</span>" +
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
			refreshTree();
		}
	});
</script>

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
