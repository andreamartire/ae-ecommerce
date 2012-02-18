<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function modifica(idModalitaPagamento) {
		$.ajax({
			url : 'modificaModalitaPagamento.htm',
			type: "POST",
			data : ({
				idModalitaPagamento : idModalitaPagamento,
				nome : $('#nomeModalitaPagamento'+idModalitaPagamento).val(),
				descrizione : $('#descrizioneModalitaPagamento'+idModalitaPagamento).val(),
				commissioni : $('#commissioniModalitaPagamento'+idModalitaPagamento).val()
			}),
			success : function(res) {
				alert("Modifiche salvate");
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
	}
	
	function elimina(idModalitaPagamento){
		if (confirm("Confermi eliminazione?")) {
			$.ajax({
				url : 'eliminaModalitaPagamento.htm',
				type: "POST",
				data : ({
					idModalitaPagamento : idModalitaPagamento
				}),
				success : function(res) {
					$('.ModalitaPagamento'+idModalitaPagamento).hide();
				},
				error: function (xhr, ajaxOptions, thrownError) {
					alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.requestText );
				}
			});
		}
	}
	
	function showAggiungi() {
		$('#aggiungiModalitaPagamento').fadeIn('slow');
	}
	
	function annulla() {
		$('#aggiungiModalitaPagamento').fadeOut('slow');
	}
	
	function aggiungi() {
		$.ajax({
			url : 'aggiungiModalitaPagamento.htm',
			type: "POST",
			data : ({
				nome : $('#nomeModalitaPagamento').val(),
				descrizione : $('#descrizioneModalitaPagamento').val(),
				commissioni : $('#commissioniModalitaPagamento').val()
			}),
			success : function(res) {
				location.reload();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}			
		});
		$('#nomeModalitaPagamento').val('');
		$('#descrizioneModalitaPagamento').val('');
		$('#commissioniModalitaPagamento').val('');
	}
</script>

<a href="home.htm">Home</a> > Gestione ModalitaPagamento
<hr></hr> 

<a onclick="showAggiungi()"><button>Aggiungi ModalitaPagamento</button></a>
<div style="display: none" id="aggiungiModalitaPagamento">
	<table style="width: 500px; padding: 5px">
		<tr>
			<td><b>Nome</b><input type="text" name="nome" id="nomeModalitaPagamento"/></td>
			<td><b>Commissioni</b><input type="number" name="commissioni" id="commissioniModalitaPagamento" style="width: 50px"/> Euro</td>
		</tr>
		<tr>
			<td colspan="2"><b>Descrizione</b></td>
		</tr>
		<tr>
			<td colspan="2" width="510">
				<textarea rows="4" cols="60" name="descrizione" id="descrizioneModalitaPagamento"></textarea>
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

<c:forEach var="ModalitaPagamento" items="${listaModalita}">
	<div class="ModalitaPagamento${ModalitaPagamento.id}">
		<table style="width: 500px; padding: 5px">
			<tr>
				<td><b>Nome</b><input type="text" name="nome" id="nomeModalitaPagamento${ModalitaPagamento.id}" value="${ModalitaPagamento.nome}" /></td>
				<td><b>Commissioni</b><input type="number" name="commissioni" id="commissioniModalitaPagamento${ModalitaPagamento.id}" style="width: 50px" value="${ModalitaPagamento.commissioni}" /> Euro</td>
			</tr>
			<tr>
				<td colspan="2"><b>Descrizione</b></td>
			</tr>
			<tr>
				<td colspan="2" width="510">
					<textarea rows="4" cols="59" name="descrizione" id="descrizioneModalitaPagamento${ModalitaPagamento.id}">${ModalitaPagamento.descrizione}</textarea>
				</td>
			</tr>
			<tr>
				<td> </td>
				<td align="right">
					<button onclick="modifica(${ModalitaPagamento.id})"><img src="resources/images/ok.png"/></button>
					<button onclick="elimina(${ModalitaPagamento.id})"><img src="resources/images/delete.png"/></button>
				</td>
			</tr>
		</table>
	</div>
	<hr class="ModalitaPagamento${ModalitaPagamento.id}"/>
</c:forEach>
