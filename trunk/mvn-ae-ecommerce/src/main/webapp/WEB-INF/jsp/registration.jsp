<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

Insert your data

<form:form method="POST" commandName="user">
	<table>
		<tr>
			<td>User Name :</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form:form>
<a href="home.htm"><button>Back</button></a>
</body>
</html>