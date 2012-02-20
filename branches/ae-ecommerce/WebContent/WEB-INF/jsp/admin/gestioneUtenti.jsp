<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<script type="text/javascript">
	function modifica(idUtente) {
		location.href="gestioneUtente.htm?id="+idUtente;
	}
	
	function elimina(id){
		if (confirm("Confermi eliminazione?"))
			location.href = "eliminaUtente.htm?id=" + id;
	}

	function salva(idordine, userid) {
		$('#stato'+idordine).val();
		$.ajax({
			url : "modificaStatoOrdine.htm",
			type: "POST",
			data : ({
				ordineId : idordine,
				stato : $('#stato'+idordine).val()
			}),
			success : function(res) {
				alert("Stato dell'ordine #"+idordine+" modificato");
				$('.class'+userid).remove();
			}		
		});
	}
	
	function storicoOrdini(userid) {
		if($('.class'+userid).size() != 0) {
			$('.class'+userid).remove();
		} else {
			$.getJSON('storicoOrdiniJSON.htm', {userId : userid}, function(data) {
				var ordini = data.ordini;
				var html = "";
				if (ordini == "") {
					html += "<tr><td colspan=4>Nessun elemento nel ordini</td></tr>";
				} else {
					html += 
						'<tr id="alt" class="class'+userid+'">' +
							'<td colspan="4">' +
								'<table id="ordiniTable" style="width: 550px">' +
									'<tbody>';
					$.each(ordini, function(key, o) {
						html += 		'<tr>' +
											'<td>'+ o.id +'</td>' +
											'<td>'+ o.data +'</td>' +
											'<td>'+ o.tot +'</td>' +
											'<td>'+ o.sped +'</td>' +
											'<td>'+
												'<select id="stato'+o.id+'">';
						switch (o.stato) {
						    case 'aperto':
	        					html += 			'<option selected="selected">aperto</option>' +
													'<option>in lavorazione</option>' +
													'<option>spedito</option>' +
													'<option>chiuso</option>';
						        break;
						    case 'in lavorazione':
	        					html += 			'<option>aperto</option>' +
													'<option selected="selected">in lavorazione</option>' +
													'<option>spedito</option>' +
													'<option>chiuso</option>';
						        break;
						    case 'spedito':
	        					html += 			'<option>aperto</option>' +
													'<option>in lavorazione</option>' +
													'<option selected="selected">spedito</option>' +
													'<option>chiuso</option>';
						        break;
						    case 'chiuso':
	        					html += 			'<option>aperto</option>' +
													'<option>in lavorazione</option>' +
													'<option>spedito</option>' +
													'<option selected="selected">chiuso</option>';
						        break;
						    default:
	        					html += 			'<option>aperto</option>' +
													'<option>in lavorazione</option>' +
													'<option>spedito</option>' +
													'<option>chiuso</option>';
						}
						html +=					'</select>' +
											'</td>' +
											'<td><button onclick="salva('+o.id+','+userid+')">Salva</button></td>' +
										'</tr>';
					});
					html += 		'</tbody>' +
								'</table>' +
							'</td>' +
						'</tr>';
				} 
				$('#'+userid).after(html);
			});
		}
	}
</script>
<a href="home.htm">Home</a> &gt; Gestione Utenti & Ordini
<hr></hr>
<table id="ordiniTable">
	<tr>
		<th>Username</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr id="${user.id}">
			<td width="400"><c:out value="${user.username}" /></td>
			<td><a onclick='storicoOrdini(${user.id})'>Ordini</a></td>
			<td><a onclick='modifica(${user.id})'><img src='resources/images/edit.png'/></a></td>
			<td><a onclick='elimina(${user.id})'><img src='resources/images/delete.png'/></a></td>
		</tr>
	</c:forEach>
</table>