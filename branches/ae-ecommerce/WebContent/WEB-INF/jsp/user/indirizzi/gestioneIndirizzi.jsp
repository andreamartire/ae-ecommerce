<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>

<a href="home.htm">Home</a> > <a href="account.htm">Gestione Account</a> > Gestione Indirizzi

<form:form method="post" commandName="indirizzi">
	<table>
		<c:forEach items="${indirizzi}" var="i" >
			<tr><td colspan="2"><hr></hr></td></tr>
			<tr><td>Via</td><td><input type="text" name="via" value="${i.via}" /></td></tr>
			<tr><td>Numero</td><td><input type="text" name="via" value="${i.numero}" /></td></tr>
			<tr><td>Citta</td><td><input type="text" name="via" value="${i.citta}" /></td></tr>
			<tr><td>Provincia</td><td><input type="text" name="via" value="${i.provincia}" /></td></tr>
			<tr><td>CAP</td><td><input type="text" name="via" value="${i.cap}" /></td></tr>
		</c:forEach>
		<tr><td colspan="2"><input type="submit" value="Salva Modifiche"></td></tr>
   </table>
</form:form>

<a href="aggiungiIndirizzo.htm"><button>Aggiungi Indirizzo</button></a>
