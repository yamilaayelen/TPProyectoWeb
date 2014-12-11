<%@page import="java.util.List"%>
<%@page import="com.javarevolutions.jsps.servlets.vo.VOLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function guardar(){
	var forma = document.getElementById("formaUsuarios");
	forma.accion= "adminUsuarios.servlet";
	var accion = document.getElementById("accion");
	accion.value = "guardar";
	forma.submit();	
}
function actualizar(){
	var forma = document.getElementById("formaUsuarios");
	forma.accion= "adminUsuarios.servlet";
	var accion = document.getElementById("accion");
	accion.value = "actualizar";
	forma.submit();	
}
function borrar(){
	var forma = document.getElementById("formaUsuarios");
	forma.accion= "adminUsuarios.servlet";
	var accion = document.getElementById("accion");
	accion.value = "borrar";
	forma.submit();	
}
function carga()
{
	document.getElementById("usuario").focus(); //pone el cursor ahi apenas arranca
}
</script>


</head>
<body>
<form action="" method="post" id=formaUsuarios>

<input type="hidden" name="accion" id="accion">

<p> Bienvenido al sistema JSP y Servlets: </p>
<%
((VOLogin)session.getAttribute("usuarioLogueado")).getNombre();
%>

<table>
<tr>
<td><input type="text" name="usuario" id="usuario">Usuario</td>
</tr>
<tr>
<td><input type="password" name="password" id="password">Password</td>
</tr>
<tr>
<td><input type="text" name="nombre" id="nombre">Nombre</td>
</tr>
<tr>
<td><input type="text" name="edad" id="edad">Edad</td>
</tr>
<tr>
<td><input type="button" value="GUARDAR" onclick="guardar()">
<input type="button" value="ACTUALIZAR" onclick="actualiar()">
<input type="submit" value="ELIMINAR" onclick="borrar()"></td>
</tr>
</table>

<table>
<tr>
<th>Usuario</th><th>Nombre</th><th>Edad</th>
</tr>
<%
List<VOLogin> lista = (List<VOLogin>)session.getAttribute("listausuario");
for (VOLogin obj: lista){
%>	
	<tr>
	<td><%= obj.getUsuario() %></td>
	<td><%= obj.getNombre() %></td>
	<td><%= obj.getEdad() %></td>
	</tr>
<%
}
%>

</table>

</form>

</body onload="carga()";>
</html>