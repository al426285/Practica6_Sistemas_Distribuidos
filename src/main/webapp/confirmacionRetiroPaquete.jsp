<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
    <link rel="stylesheet" href="estilos.css">

</head>
<body>
<img src="img/banner.jpg" alt="imagen de un paquete entregado" class="banner">

<br/>
<% boolean exito = Boolean.parseBoolean(request.getAttribute("exito").toString());
    if (exito) {%>
<h1>Enhorabuena, <%=request.getAttribute("codCliente")%>
</h1>
<h2>Has retirado el siguiente paquete:</h2>
<table>
    <div class="lista">
        <ul>
            <li>codPaquete:  <%=request.getAttribute("codPaquete")%>
            </li>
            <li>CPOrigen:  <%=request.getAttribute("CPorigen")%>
            </li>
            <li>CPDestino: <%=request.getAttribute("CPdestino")%>
            </li>
            <li>FechaEnvio:  <%=request.getAttribute("fechaEnvio")%>
            </li>
            <li>peso:  <%=request.getAttribute("peso")%>
            </li>
        </ul>
    </div>
</table>
<%} else {%><h2>
    Lo lamentamos, <%=request.getAttribute("codCliente")%>, no hemos podido retirar
    el  <%=request.getAttribute("codPaquete")%>
</h2>
<% }
%>

<br>
<br>
<h3>
    <a href="menuCliente.html">Volver al menu...</a></h3>
</body>
</html>
