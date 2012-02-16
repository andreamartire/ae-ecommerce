<script type="text/javascript">
	function login() {
		$.ajax({
			url : 'ajaxLogin.htm',
			type: "POST",
			data : ({
				username : $('#username').val(),
				password : $('#password').val(),
			}),
			success : function(res) {
				if (res == "noUser") {
					$('#message').html("<font color=red>Username non esistente</font>");
				} else if (res == "badPassword") {
					$('#message').html("<font color=red>Password non valida</font>");
				} else {
					location.reload();
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
		var type = session.getAttribute("data-type");
		if (user != null && user != "") {
			$('#loginForm').hide();
			$('#logoutButton').show();
			$('#message').html("Bentornato " + user);
			if (type == "admin") {
				$('#accountCliente').hide();
				$('#accountAdmin').show();
			} else {
				$('#accountCliente').show();
				$('#accountAdmin').hide();
			}
		} else {
			$('#logoutButton').hide();
			$('#loginForm').show();
			$('#message').html("Accedi o registrati");
		}
		var carrello = session.getAttribute("data-carrello");
		var html = "";
		if (carrello.elementiCarrello == null || carrello.elementiCarrello == "") {
			html += "<li>Nessun elemento nel carrello</li>";
		} else {
			$.each(carrello.elementiCarrello, function(key, e) {
				html += "<li>e.nome - e.prezzo</li>";
			});
		} 
		$('#carrello').append(html);
	}
	$(document).ready(startup);
</script>

<table>
	<tr>
		<td width="180"><div id="message"></div></td>
		<td align="right"><input id="logoutButton" type="button" value="Logout" onclick="logout()"></td>
	</tr>
</table>

<div id="session" data-user="${sessionScope.user}" data-type="${sessionScope.type}" data-carrello="${sessionScope.carrello}"></div>

<div id="accountCliente" style="display: none; padding: 5px">
	<a href="#">I miei ordini</a> <br/>
	<a href="account.htm">Il mio account</a> <br/>
</div>

<div id="accountAdmin" style="display: none; padding: 5px">
	<a href="gestioneUtenti.htm">Utenti</a> <br/>
	<a href="gestioneCategorie.htm">Categorie e Prodotti</a> <br/>
	<a href="#">Spedizioni e Pagamenti</a> <br/>
	<a href="gestioneFAQ.htm">F.A.Q.</a> <br/>
	<a href="gestioneCondizioni.htm">Condizioni</a> <br/>
	<a href="gestioneDoveSiamo.htm">DoveSiamo</a> <br/>
	<a href="gestioneContattaci.htm">Contattaci</a> <br/>
	<a href="gestioneInfo.htm">Banner</a> <br/>
</div>

<div id="loginForm">
	<table>
		<tr>
			<td><i>Username</i></td>
			<td><input id="username" type="text" name="username" /></td>
		</tr>
		<tr>
			<td><i>Password</i></td>
			<td><input id="password" type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input type="button" value="Login" onclick="login()"></td>
			<td><a href="registration.htm"><button>Registrati</button></a>
		</tr>
	</table>
</div>

<hr/>

<p>Il tuo carrello:</p>
<ul id="carrello" style="list-style-type: none; margin: 0; padding: 0">
	
</ul>
