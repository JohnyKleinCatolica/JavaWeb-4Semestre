/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jk.catolicasc.controller;

import com.mysql.jdbc.Util;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.entities.User;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "UserControllerServletServlet", urlPatterns = {"/User"}, initParams
        = {
            @WebInitParam(name = "do", value = "")})
public class UserControllerServlet extends HttpServlet {

    private static final long serialVersionUID = -1587237767624179860L;
    final String PERSISTENCE_UNIT_NAME = "persistenciaPU";

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = this.readParameter(request, "do");
        String nextAction;
        switch (action) {
            case "adicionar":
                nextAction = adicionarUser(request, response);
                break;
            case "buildAdicionar":
                nextAction = buildAdicionarUser(request, response);
                break;
            case "buildEditar":
                nextAction = buildEditarUser(request, response);
                break;
            case "editar":
                nextAction = editarUser(request, response);
                break;
            case "remover":
                nextAction = removerUser(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro controller: recebi obscuro do=" + action);
                nextAction = "signin.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String detalhesUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/views/ReadUserView.jsp";
        String id = this.readParameter(request, "id");

        return nextAction;
    }

    private String buildEditarUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/User/editarUser.jsp";

        String id = this.readParameter(request, "id");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        User user = null;
        user = dao.findUser(Long.parseLong(id));

        request.setAttribute("user", user);

        return nextAction;
    }

    private String editarUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstusers";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        User user = dao.findUser(Long.parseLong(id));

        String nome = request.getParameter("name");
        String login = request.getParameter("login");
        String passwd = request.getParameter("pswrd");

        if (nome != null && login != null && passwd != null && id != null) {
            user.setLogin(login);
            user.setName(nome);
            user.setPasswd(passwd);
            try {
                dao.edit(user);
            } catch (Exception ex) {
                Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("user", user);

        return nextAction;
    }

    private String buildAdicionarUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/User/AddUserView.jsp";

        return nextAction;
    }

    private String adicionarUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstusers";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        User user = new User();

        String nome = request.getParameter("name");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        //user.setId(serialVersionUID);
        user.setName(nome);
        user.setLogin(login);
        user.setPasswd(senha);

        dao.create(user);

        return nextAction;
    }

    private String removerUser(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstusers";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);

        try {
            dao.destroy(Long.parseLong(id));
        } catch (Exception ex) {
            Logger.getLogger(UserControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    }
}
