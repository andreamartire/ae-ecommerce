<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<!-- style="border-bottom: 0px solid black;" -->

</head>
<body>
	<table style="border: 0px solid black;" cellspacing="5">  
		<tr>
	        <td style="border: 0px solid black;" width="900" colspan="3">
	         	<tiles:insertAttribute name="header" />
	        </td>
	    </tr>
	    <tr>
	        <td style="border: 0px solid black; background-color: #D8D8D8;" height="600" width="130" valign="top">
	        	<tiles:insertAttribute name="left" />
	        </td>
	        <td style="border: 0px solid black;" valign="top">
	        	<tiles:insertAttribute name="body" />
	        </td>
	        <td style="border: 0px solid black; background-color: #D8D8D8; padding: 5px;"  width="230" valign="top">
	        	<tiles:insertAttribute name="right" />
	        </td>
	    </tr>
	    <tr>
	        <td style="border: 0px solid black;" height="60" colspan="3" align="center">
	        	<tiles:insertAttribute name="footer" />
	        </td>
	    </tr>
	</table>
</body>
</html>
