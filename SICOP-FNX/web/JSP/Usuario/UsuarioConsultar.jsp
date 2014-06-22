<%-- 
    Document   : UsuarioConsultar
    Created on : 9/06/2014, 12:45:02 AM
    Author     : Enrique
--%>


<%@page import="com.sicopFnx.usuarios.bean.UsuarioBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
 
      <%
       String msj= (String)request.getAttribute("msj2");
      
       %>
       <script >
           alert("<%=msj%>");
       </script>

       <%
       
        %>
        
    <body>
        <h1>Usuarios</h1>
        <% String context= request.getContextPath();
        List<UsuarioBean> usuariosLista=( List)request.getAttribute("usuariosLista");
        if(usuariosLista == null){
            %>
         no existen usuarios
            <%
        }else {
        %>
        si existen usuarios
        <a href="<%=context %>/JSP/Usuario/UsuarioAlta.jsp">dar De alta un usuario</a>
        
        
        <table><tr>
            <td>id:</td>
            <td>nombre:</td>
            <td>apellido:</td>
            <td>password:</td>
            <td>login:</td>
            <td>Eliminar:</td>
            
            </tr>
            <%
            for(UsuarioBean bean:usuariosLista){
            %>
            <tr>
                <td><%=bean.getIdUsuario() %></td>
                <td><%=bean.getNombre() %></td>
                <td><%=bean.getApellido() %></td>
                <td><%=bean.getPassword() %></td>
                <td><%=bean.getLogin() %></td>
                <td><a href = "<%=context%>/UsuarioServlet2?operacion=EliminarUsuario&UsuarioId=<%=bean.getIdUsuario() %>">ELIMINAR</a></td>
                <td><a href = "<%=context%>/UsuarioServlet2?operacion=modificarUsuario&UsuarioId=<%=bean.getIdUsuario() %>">MODIFICAR</a></td>
                
                
            </tr>
            <%
            }
            %>
        </table>
         <%
        }
        %>
      

    </body>
</html>
