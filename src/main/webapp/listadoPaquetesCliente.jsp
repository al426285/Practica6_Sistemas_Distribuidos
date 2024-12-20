<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de paquetes</title>
    <style>
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Lista de paquetes enviados</h2>
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

<br>
<a href="menuCliente.html">Volver al menu...</a>
</body>
</html>