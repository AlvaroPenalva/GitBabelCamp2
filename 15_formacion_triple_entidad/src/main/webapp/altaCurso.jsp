<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="AltaCurso" method="POST">
		<h1>Datos personales</h1>
		<br>
		<p>Nombre de Curso</p>
		<input type="text" name="nombre">
		<p>Duración</p>
		<input type="number" name="duracion">
		<p>Precio</p>
		<input type="number" name="precio">
		<p>Fecha de inicio</p>
		<input type="date" name="fechaInicio")>
		<br>
		<input type="submit" value="altaCurso">
		</form>
	
</body>
</html>