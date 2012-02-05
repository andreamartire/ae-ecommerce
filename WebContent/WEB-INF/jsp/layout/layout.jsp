<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css" />

</head>
<body>
	<table style="border: 1px solid black">  
		<tr>
	        <td style="border-bottom: 1px solid black;" colspan="2" height="30" align="center">
	         	<tiles:insertAttribute name="header" />
	        </td>
	    </tr>
	    <tr>
	        <td style="border-right: 1px solid black; background-color: #D8D8D8;" height="450" valign="top" width="170">
	        	<tiles:insertAttribute name="navigation" />
	        </td>
	        <td valign="top" width="730">
	        	<tiles:insertAttribute name="body" />
	        </td>
	    </tr>
	    <tr>
	        <td align="center" style="border-top: 1px solid black;" colspan="2" height="60">
	        	<tiles:insertAttribute name="footer" />
	        </td>
	    </tr>
	</table>
</body>
</html>
