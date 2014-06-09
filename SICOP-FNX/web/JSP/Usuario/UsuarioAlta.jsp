<%-- 
    Document   : UsuarioAlta
    Created on : 9/06/2014, 12:43:15 AM
    Author     : Enrique
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario Alta</title>
    </head>
    <body>
        <h1>alta!</h1>
        
        <form action="<%=request.getContextPath()%>/UsuarioServlet?operacion=altaUsuario" method="POST">
            nombre: <input type="text" name="nombreUsuario">
            apellido: <input type="text" name="apellidoUsuario">
            login:<input type="text" name="loginUsuario">
            password:<input type="password" name="passwordUsuario">
           
            <input type="submit" value="Guardar"> 
        </form>
    </body>
</html>
