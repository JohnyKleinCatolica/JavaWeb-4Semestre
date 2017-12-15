/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jk.catolicasc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftd.educational.catolica.prog4.daos.ClientDAO;
import org.ftd.educational.catolica.prog4.daos.FornecedorDAO;
import org.ftd.educational.catolica.prog4.daos.ProdutoDAO;
import org.ftd.educational.catolica.prog4.daos.UserDAO;
import org.ftd.educational.catolica.prog4.entities.Client;
import org.ftd.educational.catolica.prog4.entities.Fornecedor;
import org.ftd.educational.catolica.prog4.entities.Produto;
import org.ftd.educational.catolica.prog4.entities.User;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "Menu", urlPatterns = {"/Menu"}, initParams = {
    @WebInitParam(name = "do", value = "")})

public class MenuServlet extends HttpServlet {

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
            case "home":
                nextAction = "/WEB-INF/Views/index.jsp";
                break;
            case "lstusers":
                nextAction = listarUsers(request, response);
                break;
            case "lstfornecedor":
                nextAction = listarFornecedor(request, response);
                break;
            case "lstclient":
                nextAction = listarClient(request, response);
                break;
            case "lstprodutos":
                nextAction = listarProduto(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro na controller: " + action);
                nextAction = "login.jsp";
        }
        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String listarUsers(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/User/listarUsers.jsp";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO dao = new UserDAO(factory);
        List<User> lst = dao.findUserEntities();

        request.setAttribute("users", lst);

        return nextAction;
    }

    private String listarFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Fornecedor/listarFornecedor.jsp";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);
        List<Fornecedor> lst = dao.findFornecedorEntities();

        request.setAttribute("fornecedor", lst);

        return nextAction;
    }

    private String listarClient(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Client/listarClient.jsp";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ClientDAO dao = new ClientDAO(factory);
        List<Client> lst = dao.findClientEntities();

        request.setAttribute("client", lst);

        return nextAction;
    }

    private String listarProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Produtos/listarProduto.jsp";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        List<Produto> lst = dao.findProdutoEntities();

        request.setAttribute("produto", lst);

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
