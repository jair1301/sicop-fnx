/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sicopFnx.usuarios.servlet;

import com.sicopFnx.usuarios.bean.UsuarioBean;
import com.sicopFnx.usuarios.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enrique
 */
public class UsuarioServlet2 extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String operacion = request.getParameter("operacion");

            //dispatcher 
            UsuarioDAO dos = new UsuarioDAO();
            UsuarioBean bean = new UsuarioBean();

            if (operacion == null || operacion.equals("consulta")) {

                List listaDeUsuarios = dos.consultaUsuario();
                request.setAttribute("usuariosLista", listaDeUsuarios);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/UsuarioConsultar.jsp");
                rd.forward(request, response);

            } else if (operacion.equals("altaUsuario")) {

                bean.setNombre(request.getParameter("nombreUsuario"));
                bean.setApellido(request.getParameter("apellidoUsuario"));
                bean.setPassword(request.getParameter("passwordUsuario"));
                bean.setLogin(request.getParameter("loginUsuario"));

                if (!dos.altaUsuario(bean)) {
                    request.setAttribute("msj2", "el usuario se ha registrado exitosamente");
                } else {
                    request.setAttribute("msj2", "el registro no se inserto");
                }
                List listaDeUsuarios = dos.consultaUsuario();
                request.setAttribute("usuariosLista", listaDeUsuarios);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Usuario/UsuarioConsultar.jsp");
                rd.forward(request, response);

            } //eliminar
            else if (operacion.equals("EliminarUsuario")) {
                int id = Integer.parseInt(request.getParameter("UsuarioId"));
                System.out.println("llego a elminnar");

                if (!dos.bajaUsuario(id)) {
                    request.setAttribute("msj2", "el usuario se ha registrado exitosamente");
                } else {
                    request.setAttribute("msj2", "el registro no se inserto");
                }
                List listaDeUsuarios = dos.consultaUsuario();
                request.setAttribute("usuariosLista", listaDeUsuarios);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Usuario/UsuarioConsultar.jsp");
                rd.forward(request, response);

            } else if (operacion.equals("modificarUsuario")) {

                int id = Integer.parseInt(request.getParameter("UsuarioId"));

                bean = dos.ConsultaUsuarioIndividual(id);
                request.setAttribute("UsuarioBean", bean);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/Usuario/UsuarioConsultar.jsp");
                rd.forward(request, response);

            }
            else if (operacion.equals("guardarUsuario")){
            
                int id = Integer.parseInt(request.getParameter("usuarioId"));

                bean.setIdUsuario(id);
                bean.setNombre(request.getParameter("nombreUsuario"));
                bean.setApellido(request.getParameter("apellidoUsuario"));
                bean.setPassword(request.getParameter("passwordUsuario"));
                bean.setLogin(request.getParameter("loginUsuario"));

                if (!dos.modificarUsuario(bean)) {
                    request.setAttribute("msj2", "el usuario se ha registrado exitosamente");
                } else {
                    request.setAttribute("msj2", "el registro no se inserto");
                }
                List listaDeUsuarios = dos.consultaUsuario();
                request.setAttribute("usuariosLista", listaDeUsuarios);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/UsuarioConsultar.jsp");
                rd.forward(request, response);
            }

        }
    }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
