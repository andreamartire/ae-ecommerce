<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
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
				alert("Logout effettuato");
				location.reload();
			}
		});
	}
	function startup() {
		var session = document.getElementById("session")
		var user = session.getAttribute("data-user");
		if (user != null && user != "") {
			$('#loginForm').hide();
			$('#logoutButton').show();
			$('#message').html("Bentornato " + user);
		} else {
			$('#logoutButton').hide();
			$('#loginForm').show();
			$('#message').html("Accedi o registrati");
		}
	}
	$(document).ready(startup);
</script>

<table>
	<tr>
		<td width="180"><div id="message"></div></td>
		<td align="right"><input id="logoutButton" type="button" value="Logout" onclick="logout()"></td>
	</tr>
</table>

<div id="session" data-user="${sessionScope.user}" ></div>

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
<ul style="list-style-type: none; margin: 0; padding: 0">
	<li>Nessun elemento nel carrello</li>
</ul>
