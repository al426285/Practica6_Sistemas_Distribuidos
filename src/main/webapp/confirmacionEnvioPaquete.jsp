
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
<br/>
<img src="img/banner.jpg" alt="imagen de un paquete entregado" class="banner">

<h2>Enhorabuena,
    <%=request.getAttribute("codCliente")%>, has enviado el paquete con código:
    <%=request.getAttribute("codPaquete")%>
</h2>
<br>
<br>
<h3>
<a href="menuCliente.html">Volver al menu...</a></h3>
</body>
</html>