<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Clientes</title>
</head>
<body>

	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
		<td><form:hidden path="id" /></td>
		<table>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Apellidos</td>
				<td><form:input path="apellidos" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Insertar"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>