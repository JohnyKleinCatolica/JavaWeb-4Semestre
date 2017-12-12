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
import org.ftd.educational.catolica.prog4.daos.ClientDAO;
import org.ftd.educational.catolica.prog4.entities.Client;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "ClientControllerServletServlet", urlPatterns = {"/Client"}, initParams
        = {
            @WebInitParam(name = "do", value = "")})
public class ClientControllerServlet extends HttpServlet {

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
                nextAction = adicionarClient(request, response);
                break;
            case "buildAdicionar":
                nextAction = buildAdicionarClient(request, response);
                break;
            case "buildEditar":
                nextAction = buildEditarClient(request, response);
                break;
            case "editar":
                nextAction = editarClient(request, response);
                break;
            case "remover":
                nextAction = removerClient(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro controller: recebi obscuro do=" + action);
                nextAction = "signin.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String buildEditarClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Client/editarClient.jsp";

        String id = this.readParameter(request, "id");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClientDAO dao = new ClientDAO(factory);
        Client client = null;
        client = dao.findClient(Long.parseLong(id));

        request.setAttribute("fornecedor", client);

        return nextAction;
    }

    private String editarClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstclient";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClientDAO dao = new ClientDAO(factory);
        Client client = dao.findClient(Long.parseLong(id));

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");

        if (cpf != null && nome != null && id != null) {
            client.setName(nome);
            client.setCpf(cpf);
            try {
                dao.edit(client);
            } catch (Exception ex) {
                Logger.getLogger(ClientControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("fornecedor", client);

        return nextAction;
    }

    private String buildAdicionarClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Client/AddClientView.jsp";

        return nextAction;
    }

    private String adicionarClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstclient";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClientDAO dao = new ClientDAO(factory);
        Client client = new Client();

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");

        client.setName(nome);
        client.setCpf(cpf);

        dao.create(client);

        return nextAction;
    }

    private String removerClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstclient";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClientDAO dao = new ClientDAO(factory);

        try {
            dao.destroy(Long.parseLong(id));
        } catch (Exception ex) {
            Logger.getLogger(ClientControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
