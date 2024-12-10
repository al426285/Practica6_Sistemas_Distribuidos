
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
</head>
<body>
<br/>
<h3>Enhorabuena,
    <%=request.getAttribute("codCliente")%>, has enviado el paquete con código:
    <%=request.getAttribute("codPaquete")%>
</h3>
<br>
<br>
<a href="ServletAcceso">Inicio</a>
</body>
</html>