<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function modifica(idProdotto) {
		$.ajax({
			url : 'modificaProdotto.htm',
			type: "POST",
			data : ({
				idCategoria : $('#idCategoria').html(),
				idProdotto : idProdotto,
				nome : $('#nomeProdotto'+idProdotto).val(),
				prezzo : $('#prezzoProdotto'+idProdotto).val(),
				descrizione : CKEDITOR.instances['editor'].getData(),
				iva : $('#ivaProdotto'+idProdotto).val(),
				peso : $('#pesoProdotto'+idProdotto).val()
			}),
			success : function(res) {
				alert("Modifiche salvate");
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
	}
</script>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="resources/js/ckeditor/mytoolbar.js"></script>

<style type="text/css">
.cke_contents {
	height: 300px !important;
	width: 800px !important;
}
</style>

<a href="home.htm">Home</a> &gt; Gestione prodotti - Prodotto: <b>${prodotto.nome}</b>
<hr></hr> 

<div class="prodotto${prodotto.id}">
	<table style="padding: 5px">
		<tr>
			<td><b>Nome: </b><input type="text" name="nome" id="nomeProdotto${prodotto.id}" value="${prodotto.nome}" /></td>
			<td><b>Prezzo: </b><input type="number" name="prezzo" id="prezzoProdotto${prodotto.id}" style="width: 50px" value="${prodotto.prezzoUnitario}" /> Euro</td>
		</tr>
		<tr>
			<td><b>Peso: </b><input type="number" name="peso" id="pesoProdotto${prodotto.id}" style="width: 30px" value="${prodotto.pesoApprossimato}" /> Kg</td>
			<td><b>IVA: </b><input type="number" name="iva" id="ivaProdotto${prodotto.id}" style="width: 30px" value="${prodotto.percentualeIVA}" />%</td>
		</tr>
		<tr>
			<td colspan="2"><b>Descrizione:</b></td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea rows="4" cols="70" name="descrizione" id="editor">
					${prodotto.descrizione}
				</textarea>
			</td>
		</tr>
		<tr>
			<td> </td>
			<td align="right">
				<button onclick="modifica(${prodotto.id})"><img src="resources/images/ok.png"/></button>
			</td>
		</tr>
	</table>
</div>
<hr class="prodotto${prodotto.id}"/>
