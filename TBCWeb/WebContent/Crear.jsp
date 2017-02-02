<%@page import="nuevo.Jugador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea personaje nuevo</title>
</head>
<body>
<p style= "font-size:20px;" >  
	
	<!--aca agarra los datos de la sesion del crear.html y los guarda en la BD-->
	
Jugador: <%= ((Jugador)session.getAttribute("personajeNuevo")).getNombre() %> 
</p>

</body>
</html>