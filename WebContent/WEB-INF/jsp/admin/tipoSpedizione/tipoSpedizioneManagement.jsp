<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function modifica(idTipoSpedizione) {
		$.ajax({
			url : 'modificaTipoSpedizione.htm',
			type: "POST",
			data : ({
				idTipoSpedizione : idTipoSpedizione,
				nome : $('#nomeTipoSpedizione'+idTipoSpedizione).val(),
				descrizione : $('#descrizioneTipoSpedizione'+idTipoSpedizione).val(),
				prezzoBase : $('#prezzoBaseTipoSpedizione'+idTipoSpedizione).val()
			}),
			success : function(res) {
				alert("Modifiche salvate");
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
	}
	
	function elimina(idTipoSpedizione){
		if (confirm("Confermi eliminazione?")) {
			$.ajax({
				url : 'eliminaTipoSpedizione.htm',
				type: "POST",
				data : ({
					idTipoSpedizione : idTipoSpedizione
				}),
				success : function(res) {
					$('.TipoSpedizione'+idTipoSpedizione).hide();
				},
				error: function (xhr, ajaxOptions, thrownError) {
					alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.requestText );
				}
			});
		}
	}
	
	function showAggiungi() {
		$('#aggiungiTipoSpedizione').fadeIn('slow');
	}
	
	function annulla() {
		$('#aggiungiTipoSpedizione').fadeOut('slow');
	}
	
	function aggiungi() {
		$.ajax({
			url : 'aggiungiTipoSpedizione.htm',
			type: "POST",
			data : ({
				nome : $('#nomeTipoSpedizione').val(),
				descrizione : $('#descrizioneTipoSpedizione').val(),
				prezzoBase : $('#prezzoBaseTipoSpedizione').val()
			}),
			success : function(res) {
				location.reload();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
		$('#nomeTipoSpedizione').val('');
		$('#descrizioneTipoSpedizione').val('');
		$('#prezzoBaseTipoSpedizione').val('');
	}
</script>

<a href="home.htm">Home</a> &gt; Gestione TipoSpedizione
<hr></hr> 

<a onclick="showAggiungi()"><button>Aggiungi TipoSpedizione</button></a>
<div style="display: none" id="aggiungiTipoSpedizione">
	<table style="width: 500px; padding: 5px">
		<tr>
			<td><b>Nome</b><input type="text" name="nome" id="nomeTipoSpedizione"/></td>
			<td><b>PrezzoBase</b><input type="number" name="prezzoBase" id="prezzoBaseTipoSpedizione" style="width: 50px"/> Euro</td>
		</tr>
		<tr>
			<td colspan="2"><b>Descrizione</b></td>
		</tr>
		<tr>
			<td colspan="2" width="510">
				<textarea rows="4" cols="60" name="descrizione" id="descrizioneTipoSpedizione"></textarea>
			</td>
		</tr>
		<tr>
			<td> </td>
			<td align="right">
				<button onclick="aggiungi()"><img src="resources/images/add.png"/></button>
				<button onclick="annulla()"><img src="resources/images/cancel.png"/></button>
			</td>
		</tr>
	</table>
</div>

<hr/>

<c:forEach var="TipoSpedizione" items="${spedizioni}">
	<div class="TipoSpedizione${TipoSpedizione.id}">
		<table style="width: 500px; padding: 5px">
			<tr>
				<td><b>Nome</b><input type="text" name="nome" id="nomeTipoSpedizione${TipoSpedizione.id}" value="${TipoSpedizione.nome}" /></td>
				<td><b>PrezzoBase</b><input type="number" name="prezzoBase" id="prezzoBaseTipoSpedizione${TipoSpedizione.id}" style="width: 50px" value="${TipoSpedizione.prezzoBase}" /> Euro</td>
			</tr>
			<tr>
				<td colspan="2"><b>Descrizione</b></td>
			</tr>
			<tr>
				<td colspan="2" width="510">
					<textarea rows="4" cols="59" name="descrizione" id="descrizioneTipoSpedizione${TipoSpedizione.id}">${TipoSpedizione.descrizione}</textarea>
				</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					<button onclick="modifica(${TipoSpedizione.id})"><img src="resources/images/ok.png"/></button>
					<button onclick="elimina(${TipoSpedizione.id})"><img src="resources/images/delete.png"/></button>
				</td>
			</tr>
		</table>
	</div>
	<hr class="TipoSpedizione${TipoSpedizione.id}"/>
</c:forEach>
