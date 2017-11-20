/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jk.catolicasc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "MenuMain", urlPatterns = {"/MenuMain"}, initParams = {
    @WebInitParam(name = "do", value = "")})

public class MenuMainServlet extends HttpServlet {

    private static final long serialVersionUID = -1587237767624179860L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = this.readParameter(request, "do");
        String nextAction;

        switch (action) {
            case "lstmodel":
                nextAction = listarUsers(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro ao logar." + action);
                nextAction = "login.jsp";
        }        
         request.getRequestDispatcher(nextAction).forward(request, response);
    }
    
    private String listarUsers (HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/views/UsersView.jsp";

        //request.setAttribute("userName", (String) request.getSession().getAttribute("username"));
        
        return nextAction;
    }    

    private String readParameter(HttpServletRequest req, String parameterName) {
        return readParameter(req, parameterName, "");
    }

    private String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
    }
}
