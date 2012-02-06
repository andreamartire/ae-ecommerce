<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	function login() {
		$.ajax({
			url : 'ajaxLogin.htm',
			type: "POST",
			data : ({
				username : $('#username').val(),
				password : $('#password').val()
			}),
			success : function(res) {
				if (res == "noUser") {
					$('#message').html("<font color=red>Username non esistente</font>");
				} else if (res == "badPassword") {
					$('#message').html("<font color=red>Password non valida</font>");
				} else {
					$('#loginForm').hide('fast');
					$('#message').html(res);
				}
			}
		});
	}
</script>

<div id="message"></div>

<div id="loginForm">
	<table>
		<tr>
			<td>Username</td>
			<td><input id="username" type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password</td>
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
