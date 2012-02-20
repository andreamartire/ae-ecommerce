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
				descrizione : CKEDITOR.instances['editor'+idProdotto].getData(),
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
		replace('editor');
	}
	
	function annulla() {
		$('#aggiungiProdotto').fadeOut('slow');
	}
	
	function aggiungi() {
		$.ajax({
			url : 'aggiungiProdotto.htm',
			type: "POST",
			data : ({
				idCategoria :$('#idCategoria').html(),
				nome : $('#nomeProdotto').val(),
				prezzo : $('#prezzoProdotto').val(),
				descrizione : CKEDITOR.instances['editor'].getData(),
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
		$('#nomeProdotto').val('');
		$('#prezzoProdotto').val('');
		$('#editor').val('');
		$('#ivaProdotto').val('');
		$('#pesoProdotto').val('');
	}
	
	var editor;

	function replace( id )
	{
		if ( editor )
			editor.destroy();

		editor = CKEDITOR.replace( id,
			{
				toolbar :
				[
					{ name: 'document', items : [ 'Save','DocProps','Preview','-','Templates' ] },
					{ name: 'clipboard', items : [ 'Cut','Copy','Paste','-','Undo','Redo' ] },
					{ name: 'editing', items : [ 'Find','Replace','-','SelectAll'] },
					{ name: 'forms', items : [ 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button'] },
					{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
					'/',
					{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
					{ name: 'insert', items : [ 'Image','Flash','Table','HorizontalRule','SpecialChar'] },
					'/',
					{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Subscript','Superscript','-','RemoveFormat' ] },
					{ name: 'styles', items : [ 'Format','Font','FontSize','TextColor','BGColor' ] }
				]
			});
	}
</script>

<script type="text/javascript" src="resources/js/ckeditor/ckeditor.js"></script>

<a href="home.htm">Home</a> &gt; Gestione prodotti - Categoria: <b>${categoria.nome}</b>
<hr></hr> 

<div style="display: none" id="idCategoria">${categoria.id}</div>

<a onclick="showAggiungi()"><button>Aggiungi Prodotto</button></a>
<div style="display: none" id="aggiungiProdotto">
	<table style="width: 600px; padding: 5px">
		<tr>
			<td><b>Nome: </b><input type="text" name="nome" id="nomeProdotto"/></td>
			<td><b>Prezzo: </b><input type="number" name="prezzo" id="prezzoProdotto" style="width: 50px"/> Euro</td>
		</tr>
		<tr>
			<td><b>Peso: </b><input type="number" name="peso" id="pesoProdotto" style="width: 30px"> Kg</td>
			<td><b>IVA: </b><input type="number" name="iva" id="ivaProdotto" style="width: 30px"/>%</td>
		</tr>
		<tr>
			<td colspan="2"><b>Descrizione:</b></td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea id="editor" rows="4" cols="70" name="descrizione"></textarea>
			</td>
		</tr>
		<tr>
			<td> </td>
			<td align="right">
				<button onclick="aggiungi()"><img src="resources/images/ok.png"/></button>
				<button onclick="annulla()"><img src="resources/images/cancel.png"/></button>
			</td>
		</tr>
	</table>
</div>

<hr/>

<c:forEach var="prodotto" items="${prodotti}">
	<div class="prodotto${prodotto.id}">
		<table style="width: 600px; padding: 5px">
			<tr>
				<td><b>Nome</b><input type="text" name="nome" id="nomeProdotto${prodotto.id}" value="${prodotto.nome}" /></td>
				<td><b>Prezzo</b><input type="number" name="prezzo" id="prezzoProdotto${prodotto.id}" style="width: 50px" value="${prodotto.prezzoUnitario}" /> Euro</td>
			</tr>
			<tr>
				<td><b>Peso</b><input type="number" name="peso" id="pesoProdotto${prodotto.id}" style="width: 30px" value="${prodotto.pesoApprossimato}" /> Kg</td>
				<td><b>IVA</b><input type="number" name="iva" id="ivaProdotto${prodotto.id}" style="width: 30px" value="${prodotto.percentualeIVA}" />%</td>
			</tr>
			<tr>
				<td colspan="2"><b>Descrizione</b></td>
			</tr>
			<tr>
				<td colspan="2" width="600">
					<textarea rows="4" cols="70" name="descrizione" id="editor${prodotto.id}" onclick="replace('editor${prodotto.id}');">
						${prodotto.descrizione}
					</textarea>
				</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					<button onclick="modifica(${prodotto.id})"><img src="resources/images/ok.png"/></button>
					<button onclick="elimina(${prodotto.id})"><img src="resources/images/delete.png"/></button>
				</td>
			</tr>
		</table>
	</div>
	<hr class="prodotto${prodotto.id}"/>
</c:forEach>
