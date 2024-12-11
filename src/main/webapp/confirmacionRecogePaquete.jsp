<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
</head>
<body>
<br/>
<h3>
    <% boolean exito = Boolean.parseBoolean(request.getParameter("exito"));
        if (exito) {%>
    <h2> Enhorabuena,
        <%=request.getAttribute("codCliente")%>, has recogido el paquete con código:
        <%=request.getAttribute("codPaquete")%>
    </h2>
    <% } else {%>
    <h2>Lo sentimos, el paquete  <%=request.getAttribute("codPaquete")%> no ha podido ser recogido correctamente </h2>
    <% }
    %>
</h3>
<br>
<br>
<a href="ServletAcceso">Inicio</a>
</body>
</html>