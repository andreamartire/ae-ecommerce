<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<script type="text/javascript">
	/* $(document).ready(function () {
		$.ajax({
			url: 'listCategorie.htm',
			dataType: 'json',
			success: creaMenuCategorie,
			error: function (xhr, ajaxOptions, thrownError) {
				alert(thrownError + "\n\n" + ajaxOptions + "\n\n" + xhr.responseText );
			}
		});
	// 	$.getJSON('listCategorie.htm', creaMenuCategorie);
	});
	
	function creaMenuCategorie(data) {
		$.each(data.categorie, function(key, categoria) {
			var html = "<li><a href=\"#\">"+categoria.nome+"</a>";
			if (categoria.children != "")
			{
				html += "<ul id=\""+categoria.nome+"\">";
				$.each(categoria.children, function(key, subcat) {
					html += "<li><a href=\"#\">"+subcat.nome+"</a></li>";
				});
				html += "</ul>";
			}
			html += "</li>";
			
			$("#sidebarmenu1").append(html);
		});
		initsidebarmenu();
	} */
	
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
</script>

<div class="sidebarmenu">
	<ul id="sidebarmenu1">
		<!-- contenuto caricato da jquery -->
	</ul>
</div>
