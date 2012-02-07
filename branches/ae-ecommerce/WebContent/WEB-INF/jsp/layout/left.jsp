<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$.ajax({
		url : 'listCategorie',
		type: "GET",
		success : function(list) {
			alert(list);
		}
	});
})
</script>

<script type="text/javascript">
	//Nested Side Bar Menu (Mar 20th, 09)
	//By Dynamic Drive: http://www.dynamicdrive.com/style/

	var menuids = [ "sidebarmenu1" ] //Enter id(s) of each Side Bar Menu's main UL, separated by commas

	function initsidebarmenu() {
		for ( var i = 0; i < menuids.length; i++) {
			var ultags = document.getElementById(menuids[i])
					.getElementsByTagName("ul")
			for ( var t = 0; t < ultags.length; t++) {
				ultags[t].parentNode.getElementsByTagName("a")[0].className += " subfolderstyle"
				if (ultags[t].parentNode.parentNode.id == menuids[i]) //if this is a first level submenu
					ultags[t].style.left = ultags[t].parentNode.offsetWidth
							+ "px" //dynamically position first level submenus to be width of main menu item
				else
					//else if this is a sub level submenu (ul)
					ultags[t].style.left = ultags[t - 1]
							.getElementsByTagName("a")[0].offsetWidth
							+ "px" //position menu to the right of menu item that activated it
				ultags[t].parentNode.onmouseover = function() {
					this.getElementsByTagName("ul")[0].style.display = "block"
				}
				ultags[t].parentNode.onmouseout = function() {
					this.getElementsByTagName("ul")[0].style.display = "none"
				}
			}
			for ( var t = ultags.length - 1; t > -1; t--) { //loop through all sub menus again, and use "display:none" to hide menus (to prevent possible page scrollbars
				ultags[t].style.visibility = "visible"
				ultags[t].style.display = "none"
			}
		}
	}

	if (window.addEventListener)
		window.addEventListener("load", initsidebarmenu, false)
	else if (window.attachEvent)
		window.attachEvent("onload", initsidebarmenu)
</script>


<!-- qua andrebbe creato tutto dinamicamente dalla tabella categoria -->

<div class="sidebarmenu">
	<ul id="sidebarmenu1">
		<li><a href="#">Hardware</a>
			<ul>
				<li><a href="#">Cpu</a>
					<ul>
						<li><a href="#">Intel</a></li>
						<li><a href="#">Amd</a></li>
					</ul>
				</li>
				<li><a href="#">Alimentatori</a></li>
				<li><a href="#">Schede grafiche</a></li>
				<li><a href="#">Motherboard</a></li>
			</ul>
		</li>
		<li><a href="#">Periferiche</a>
			<ul>
				<li><a href="#">Stampanti</a></li>
				<li><a href="#">Monitor</a>
					<ul>
						<li><a href="#">LCD</a></li>
						<li><a href="#">LED</a></li>
						<li><a href="#">OLED</a></li>
						<li><a href="#">Professionali</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="#">Software</a>
			<ul>
				<li><a href="#">Antivirus</a></li>
				<li><a href="#">Sistemi Operativi</a></li>
				<li><a href="#">Manageriali</a></li>
				<li><a href="#">Grafica</a></li>
			</ul>
		</li>
		<li><a href="#">Servizi</a></li>
		<li><a href="#">Last Minute</a></li>
	</ul>
</div>
