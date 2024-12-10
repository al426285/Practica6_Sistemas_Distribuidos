<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="ServletDeBienvenida" method="POST">
    <table>
        <tr><th> Nombre</th> <td><input type="text" name="nombre"></td></tr>
        <tr><th> Apellidos</th> <td><input type="text" name="apellidos"></td></tr>
        <tr><td colspan="2"><input type="submit" value="nombre"></td></tr>

    </table>
</form>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>