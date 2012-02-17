<script type="text/javascript">
	function login() {
		$.ajax({
			url : 'ajaxLogin.htm',
			type: "POST",
			dataType: 'json',
			data : ({
				username : $('#username').val(),
				password : $('#password').val(),
			}),
			success : function(res) {
				if (res.name == "noUser") {
					$('#message').html("<font color=red>Username non esistente</font>");
				} else if (res.name == "badPassword") {
					$('#message').html("<font color=red>Password non valida</font>");
				} else {
					$('#loginDiv').hide();
					$('#logoutButton').show();
					$('#message').html("Bentornato " + res.name);
					if (res.type == "admin") {
						$('#accountCliente').hide();
						$('#accountAdmin').show();
					} else {
						$('#accountCliente').show();
						$('#accountAdmin').hide();
					}
				}
			}
		});
	}
	function logout() {
		$.ajax({
			url : 'logout.htm',
			success : function(res) {
				location.replace('home.htm');
			}
		});
	}	
	
	function startup() {
		var session = document.getElementById("session")
		var user = session.getAttribute("data-user");
		var name = session.getAttribute("data-name");
		var type = session.getAttribute("data-type");
		if (user != null && user != "") {
			$('#loginDiv').hide();
			$('#logoutButton').show();
			$('#message').html("Bentornato " + name);
			if (type == "admin") {
				$('#accountCliente').hide();
				$('#accountAdmin').show();
			} else {
				$('#accountCliente').show();
				$('#accountAdmin').hide();
			}
		} else {
			$('#logoutButton').hide();
			$('#loginDiv').show();
			$('#message').html("Accedi o registrati");
		}
// 		var carrello = session.getAttribute("data-carrello");
// 		var html = "";
// 		if (carrello.elementiCarrello == null || carrello.elementiCarrello == "") {
// 			html += "<li>Nessun elemento nel carrello</li>";
// 		} else {
// 			$.each(carrello.elementiCarrello, function(key, e) {
// 				html += "<li>e.nome - e.prezzo</li>";
// 			});
// 		} 
// 		$('#carrello').append(html);
		

		$('#loginForm').submit(function(e) {
			e.preventDefault();
			login();
		});
		
		$('#username').focusin(function () {
			if ($('#username').val() == "username")
				$('#username').val("");
		});

		$('#password').focusin(function () {
			if ($('#password').val() == "password")
				$('#password').val("");
		});
	}
	$(document).ready(startup);
</script>


<div id="message"></div>

<div id="session" 
	data-user="${sessionScope.user}" 
	data-name="${sessionScope.name}" 
	data-type="${sessionScope.type}" 
	data-carrello="${sessionScope.carrello}">
</div>

<div style="width: 180px;">
	<div id="accountCliente" style="display: none; padding: 5px">
		<a href="#">I miei ordini</a> <br/>
		<a href="account.htm">Il mio account</a> <br/>
		<a id="logoutButton" onclick="logout()">Logout</a>
	</div>
	
	<div id="accountAdmin" style="display: none; padding: 5px">
		<a href="gestioneUtenti.htm">Utenti</a> <br/>
		<a href="gestioneCategorie.htm">Categorie e Prodotti</a> <br/>
		<a href="gestioneTipoSpedizione.htm">Tipo Spedizione</a> <br/>
		<a href="gestioneModalitaPagamento.htm">Modalita' Pagamento</a> <br/>
		<a href="#">Vetrina</a> <br/>
		<a href="#">Offerte</a> <br/>
		<a href="gestioneFAQ.htm">F.A.Q.</a> <br/>
		<a href="gestioneCondizioni.htm">Condizioni</a> <br/>
		<a href="gestioneDoveSiamo.htm">DoveSiamo</a> <br/>
		<a href="gestioneContattaci.htm">Contattaci</a> <br/>
		<a href="gestioneInfo.htm">Banner</a> <br/>
		<a href="" id="logoutButton" onclick="logout()">Logout</a>
	</div>
	
	<div id="loginDiv">
	<form id="loginForm">
		<table>
			<tr>
				<td><input id="username" style="width: 150px" type="text" name="username" value="username" /></td>
			</tr>
			<tr>
				<td><input id="password" style="width: 150px" type="password" name="password" value="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	
	<p>Se non sei gia' registrato: <a href="registration.htm">Registrati</a></p>
	</div>
</div>
<hr/>

<p>Il tuo carrello:</p>
<ul id="carrello" style="list-style-type: none; margin: 0; padding: 0">
	
</ul>
