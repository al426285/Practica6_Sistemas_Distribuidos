<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de paquetes</title>
</head>
<body>
<h3>Lista de paquetes enviados</h3>
<br/>
        <p>
                <%
                    ArrayList<String> res = (ArrayList<String>) request.getAttribute("resultado");
                    if (res != null) {
                %>
                <ul>
                    <% for (String paq : res) { %>
                    <br> <li><%= paq %></li>
                    <% } %>
                </ul>
                <% } else { %>
                <p>No se encontraron paquetes.</p>
                <% } %>

        </p>


<a href="ServletAcceso">Inicio</a>
</body>
</html>