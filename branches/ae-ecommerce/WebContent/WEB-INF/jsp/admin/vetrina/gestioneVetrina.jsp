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
	
	function creaListaCategorie(list) {
		$.each(list.categorie, function(key, categoria) {
			var html = 
				"<li>" +
					"<span>" +
						"<b>" + categoria.nome + "</b>" +
					"</span>";
			if (categoria.children == "") {
				html += "<ul class='prodotti' id='"+categoria.id+"'></ul>";
			} else {
				html += 
					"<ul>";
				$.each(categoria.children, function(key, subcat) {
					html +=
						"<li>" +
							"<span>" +
								"<b>" + subcat.nome + "</b>" +
							"</span>";
					if (subcat.children == "") {
						html += "<ul class='prodotti' id='"+subcat.id+"'></ul>";
					} else {
						html += 
							"<ul>";
						$.each(subcat.children, function(key, subsubcat) {
							html += 
								"<li>" +
									"<span>" +
										"<b>" + subsubcat.nome + "</b>" +
									"</span>" +
									"<ul class='prodotti' id='"+subsubcat.id+"'></ul>" +
								"</li>";
						});
						html += 
							"</ul>";
					}
					html += 
						"</li>";
				});
				html += 
					"</ul>";
			} 
			html += 
				"</li>";
			
			$("#listaCategorie").append(html);
		});
		
		var count = 0;
		var size = $('.prodotti').size();
		if (size == 0)
			refreshTree();
		
		$('.prodotti').each(function(index) {
			var id = $(this).attr("id");
			$.ajax({
				url : 'listProdotti.htm',
				type: "GET",
				data : ({
					idCategoria : id
				}),
				dataType: 'json',
				success: function (jsonProdotti) {
					if (jsonProdotti.prodotti != "") {
						var html = "";
						$.each(jsonProdotti.prodotti, function(key, prod) {
							html += "<li>" +
										"<span>"+prod.nome+"</span>" +
										"<button onclick='aggiungiProdotto(" + prod.id + ")'>" +
											"<img src='resources/images/add.png'/>" +
										"</button>" +
									"</li>";
						});
						$('#'+id).append(html);
					} else {
						$('#'+id).remove();
					}
					count = count +1;
					if (count == size)
						refreshTree();
				},
				error: function (xhr, ajaxOptions, thrownError) {
					alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
				}
			});
		});
	}
	
	$(document).ready(function(){
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: function(data) {
				creaListaCategorie(data);
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
