<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function Redirection() {  
		var session = document.getElementById("session")
		var user = session.getAttribute("data-user");
		window.location="storicoOrdini.htm?user="+user; 
	}

	window.setInterval(putDots, 1000);
	
	function putDots() {
		$('#dots').append(".");
	}
	
	$(document).ready(function () {
		setTimeout('Redirection()', 5000);  
	});
</script>

<div id="session" 
	data-user="${sessionScope.user}">
</div>

<div style="margin: auto; text-align: center; font-size: 14pt">
	<p>L'ordine appena effettuato e' stato registrato.</p>
	<p>Stai per essere reinderizzato alla pagina "I miei ordini"<span id="dots"></span></p>
</div>

