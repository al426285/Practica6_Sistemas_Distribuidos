<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de paquetes</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<img src="img/banner.jpg" alt="imagen de un paquete entregado" class="banner">

<h2>Lista de paquetes enviados</h2>
<br/>
<table>
    <div class="lista">
        <%
            ArrayList<String> res = (ArrayList<String>) request.getAttribute("resultado");
            if (res != null) {
        %>
        <ul>
            <% for (String paq : res) { %>
            <li><%= paq %>
            </li>
            <% } %>
        </ul>
        <% } else { %>
        <h2>No se encontraron paquetes.</h2>
        <% } %>
    </div>
</table>

<h3>
    <a href="menuMensajero.html">Volver al menu...</a></h3>
</body>
</html>