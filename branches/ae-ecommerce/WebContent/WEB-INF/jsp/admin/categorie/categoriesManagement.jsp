<link rel="stylesheet" href="resources/css/jquery.treeview.css" />
	
<script src="resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
	function load(jsonProdotti, idCategoria) {
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: function(categorie) {
				$("#listaCategorie").empty();
				
				creaListaCategorie(categorie);
				
				var html = 
					"<li><span>" +
						"<a href='gestioneProdotti.htm?idCategoria="+idCategoria+"'><b>Gestione prodotti</b></a>" +
					"</span></li>";
				$.each(jsonProdotti.prodotti, function(key, prod) {
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

	function elimina(idCategoria) {
		if (confirm("Confermi eliminazione?")) {
			$.ajax({
				url : 'eliminaCategoria.htm',
				type: "POST",
				data : ({
					id : idCategoria,
				}),
				success : function(res) {
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
					$('#'+idCategoria).val("");
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
						" - <a onclick='modifica("+categoria.id+")'><img src='resources/images/edit.png'/></a>" +
						" - <a onclick='elimina("+categoria.id+")'><img src='resources/images/delete.png'/></a>" +
						"</span>" +
					"</span>";
			html += "<ul id='prodotti"+categoria.id+"'>" +
						"<li>" +
							"Aggiungi sottocategoria: " +
							"<input id='"+categoria.id+"'type='text' style='width: 150px' />" +
							"<a onclick='aggiungi("+categoria.id+")'><img src='resources/images/add.png'/></a>";
			if (categoria.children == "") {
				html += 	" - <a onclick='listProdotti("+categoria.id+")'>Elenca prodotti</a>" +
						"</li>";
			} else {
				$.each(categoria.children, function(key, subcat) {
						// sotto categoria
					html += 
						"</li>" +
						"<li id='li"+subcat.id+"'" +
								"onmouseover='$(\"#span"+subcat.id+"\").show()'" +
								"onmouseout='$(\"#span"+subcat.id+"\").hide()'>" +
							"<span>" +
								"<b id='nome"+subcat.id+"'>" + subcat.nome + "</b>" +
								"<span id='span"+subcat.id+"' style='display: none'>" +
								" - <a onclick='modifica("+subcat.id+")'><img src='resources/images/edit.png'/></a>" +
								" - <a onclick='elimina("+subcat.id+")'><img src='resources/images/delete.png'/></a>" +
								"</span>" +
							"</span>";
					html += "<ul id='prodotti"+subcat.id+"'>" +
								"<li>" +
									"Aggiungi sottocategoria: " +
									"<input id='"+subcat.id+"'type='text' style='width: 150px' />" +
									"<a onclick='aggiungi("+subcat.id+")'><img src='resources/images/add.png'/></a>";
					if (subcat.children == "") {
						html += 	" - <a onclick='listProdotti("+subcat.id+")'>Elenca prodotti</a>" +
								"</li>";
					} else {
						$.each(subcat.children, function(key, subsubcat) {
								// sotto sotto categoria
							html += 
								"</li>" +
								"<li id='li"+subsubcat.id+"'" +
										"onmouseover='$(\"#span"+subsubcat.id+"\").show()'" +
										"onmouseout='$(\"#span"+subsubcat.id+"\").hide()'>" +
									"<span>" +
										"<b id='nome"+subsubcat.id+"'>" + subsubcat.nome + "</b>" +
										"<span id='span"+subsubcat.id+"' style='display: none'>" +
										" - <a onclick='modifica("+subsubcat.id+")'><img src='resources/images/edit.png'/></a>" +
										" - <a onclick='elimina("+subsubcat.id+")'><img src='resources/images/delete.png'/></a>" +
										"</span>" +
									"</span>" +
									"<ul id='prodotti"+subsubcat.id+"'>" +
										"<li>" +
											"<a onclick='listProdotti("+subsubcat.id+")'>Elenca prodotti</a>" +
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

<a href="home.htm">Home</a> > Gestione Categorie
<hr></hr>

<ul id="listaCategorie" class="treeview-gray">
	<li>
		Aggingi Categoria: 
		<input type="text" style="width: 150px" id="-1" /> 
		<a  onclick='aggiungi(-1)'><img src="resources/images/add.png" /></a>
	</li>
	<!-- contenuto dinamico -->
</ul>
