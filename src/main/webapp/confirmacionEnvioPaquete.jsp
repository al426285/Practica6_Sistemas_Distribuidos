
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
</head>
<body>
<br/>
<h2>Enhorabuena,
    <%=request.getAttribute("codCliente")%>, has enviado el paquete con código:
    <%=request.getAttribute("codPaquete")%>
</h2>
<br>
<br>
<a href="menuCliente.html">Volver al menu...</a>
</body>
</html>