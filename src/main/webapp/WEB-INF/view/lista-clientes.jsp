<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de clientes</title>
	<!-- 
	 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
	 -->
</head>
<body>
	Vista de la lista de clientes
	<table>
		<tr>
		<th>Nombre</th>
		<th>Apellidos</th>
		<th>Email</th>
		</tr>
		<c:forEach var="clienteTemp" items="${clientes }">
			<tr>
				<td>${clienteTemp.nombre }</td>
				<td>${clienteTemp.apellidos }</td>
				<td>${clienteTemp.email}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="Agregar_Cliente" onClick="window.location.href='muestraFormularioAgregar'; return false;">
</body>
</html>