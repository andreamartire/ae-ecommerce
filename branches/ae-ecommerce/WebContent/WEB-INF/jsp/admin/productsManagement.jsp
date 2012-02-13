<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function modifica(idProdotto) {
		alert("modifica " + idProdotto);
// 		location.href="gestioneUtente.htm?id="+idUtente;
	}
	
	function elimina(idProdotto){
		if (confirm("Confermi eliminazione?")) {
			$.ajax({
				url : 'eliminaProdotto.htm',
				type: "POST",
				data : ({
					idCategoria : $('#idCategoria').html(),
					idProdotto : idProdotto
				}),
				success : function(res) {
					$('#prodotto'+idProdotto).hide();
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
	
	function aggiungi(nomeProdotto) {
		$.ajax({
			url : 'aggiungiProdotto.htm',
			type: "POST",
			data : ({
				idCategoria :$('#idCategoria').html(),
				nome : $('#nomeProdotto').val(),
				prezzo : $('#prezzoProdotto').val(),
				descrizione : $('#descrizioneProdotto').val(),
				iva : $('#ivaProdotto').val(),
				peso : $('#pesoProdotto').val()
			}),
			success : function(res) {
				location.reload();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
	}
</script>

<h3>Gestione prodotti - Categoria: <b>${categoria.nome}</b></h3>

<div style="display: none" id="idCategoria">${categoria.id}</div>

<a onclick="showAggiungi()">Aggiungi Prodotto</a>
<div style="display: none" id="aggiungiProdotto">
	<table style="padding: 3px">
		<tr>
			<td><label for="nome">Nome</label> <input type="text" name="nome" id="nomeProdotto"/></td>
			<td><label for="prezzo">Prezzo</label> <input type="number" name="prezzo" id="prezzoProdotto"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<label for="descrizione">Descrizione</label> 
				<textarea rows="4" cols="40" name="descrizione" id="descrizioneProdotto"></textarea>
			</td>
		</tr>
		<tr>
			<td><label for="peso">Peso</label> <input type="number" name="peso" id="pesoProdotto"/></td>
			<td><label for="iva">IVA</label> <input type="number" name="iva" id="ivaProdotto"/></td>
		</tr>
		<tr>
			<td>
				<input type="button" value="Aggiungi" onclick="aggiungi()"/>
			</td>
			<td></td>
		</tr>
	</table>
</div>

<hr/>

<table style="padding: 3px">
	<c:forEach var="prodotto" items="${prodotti}">
		<tr id="prodotto${prodotto.id}">
			<td><c:out value="${prodotto.nome}" /></td>
			<td><input type="button" value="Modifica" onclick="modifica(${prodotto.id})"></td>
			<td><input type="button" value="Elimina" onclick="elimina(${prodotto.id})"></td>
		</tr>
	</c:forEach>
</table>