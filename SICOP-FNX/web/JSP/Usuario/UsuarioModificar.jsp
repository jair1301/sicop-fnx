<%-- 
    Document   : UsuarioModificar
    Created on : 9/06/2014, 12:45:15 AM
    Author     : Enrique
--%>


<%@page import="com.sicopFnx.usuarios.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>modificar</h1>
         <%UsuarioBean bean = (UsuarioBean)request.getAttribute("UsuarioBean");%>
        <form action="<%=request.getContextPath()%>/UsuarioServlet?operacion=guardarUsuario" method="POST">
            nombre: <input value="<%=bean.getNombre()%>" type="text" name="nombreUsuario">
            apellido: <input value="<%=bean.getApellido()%>" type="text" name="apellidoUsuario">
            password:<input value="<%=bean.getPassword()%>" type="password" name="passwordUsuario">
            login:<input value="<%=bean.getLogin()%>" type="text" name="loginUsuario">
            <input type="hidden" name="usuarioId" value="<%=bean.getIdUsuario()%>">
            
            <input type="submit" value="guardar"> 
        </form>
    </body>
</html>
