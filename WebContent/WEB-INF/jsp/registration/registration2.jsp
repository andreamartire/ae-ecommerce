<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Flusso Registrazione Stato 2

<form method="POST">
	<input type="hidden" name="_flowExecutionId" value="<c:out value="${flowExecutionId}"/>" /> 
	<input type="hidden" name="_eventId" value="submit" />
	<input id="submit" type="submit">
</form>