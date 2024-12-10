<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmación</title>
</head>
<body>
<br/>
<% boolean exito = Boolean.parseBoolean(request.getParameter("exito"));
    if(exito){%>
<h2>Enhorabuena, <%=request.getAttribute("codCliente")%> </h2>
<h3>Has modificado correctamente el siguiente paquete (nuevos valores):</h3>
<ul>
    <li>codPaquete:  <%=request.getAttribute("codPaquete")%> </li>
    <li>CPOrigen:  <%=request.getAttribute("CPorigen")%> </li>
    <li>CPDestino: <%=request.getAttribute("CPdestino")%>  </li>
    <li>FechaEnvio:  <%=request.getAttribute("fechaEnvio")%> </li>
    <li>peso:  <%=request.getAttribute("peso")%> </li>
</ul>
<%}
else{%>
Lo lamentamos, <%=request.getAttribute("codCliente")%>, no se ha podido modificar el paquete <%=request.getAttribute("codPaquete")%>
<% }
%>

</h3>
<br>
<br>
<a href="ServletAcceso">Inicio</a>
</body>
</html>
