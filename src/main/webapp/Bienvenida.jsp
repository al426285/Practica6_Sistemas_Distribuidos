<%--
  Created by IntelliJ IDEA.
  User: hayta
  Date: 03/12/2024
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hasta pronto</title>
    <style>
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
<h2> Hasta luego <%=request.getAttribute("id")%>
</h2>
<h2>
    Te estaremos esperando
</h2>
<a style="font-size: 18px" href="ServletAcceso">Inicio</a>

</body>
</html>
