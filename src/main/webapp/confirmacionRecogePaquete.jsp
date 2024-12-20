<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
    <style>
        h2{
            text-align: center;
        }
    </style>
</head>
<body>

    <% boolean exito = Boolean.parseBoolean(request.getAttribute("exito").toString());
        if (exito) {%>
    <h2> Enhorabuena,
        <%=request.getAttribute("codMensajero")%>, has recogido el paquete con código
        <%=request.getAttribute("codPaquete")%>
    </h2>
    <% } else {%>
    <h2>Lo sentimos, el paquete  <%=request.getAttribute("codPaquete")%> no ha podido ser recogido correctamente </h2>
    <% }
    %>

<br>
<br>
<a href="menuMensajero.html">Volver al menu...</a>
</body>
</html>