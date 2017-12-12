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
import org.ftd.educational.catolica.prog4.daos.FornecedorDAO;
import org.ftd.educational.catolica.prog4.entities.Fornecedor;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "FornecedorControllerServletServlet", urlPatterns = {"/Fornecedor"}, initParams
        = {
            @WebInitParam(name = "do", value = "")})
public class FornecedorControllerServlet extends HttpServlet {

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
                nextAction = adicionarFornecedor(request, response);
                break;
            case "buildAdicionar":
                nextAction = buildAdicionarFornecedor(request, response);
                break;
            case "buildEditar":
                nextAction = buildEditarFornecedor(request, response);
                break;
            case "editar":
                nextAction = editarFornecedor(request, response);
                break;
            case "remover":
                nextAction = removerFornecedor(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro controller: recebi obscuro do=" + action);
                nextAction = "signin.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String buildEditarFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Fornecedor/editarFornecedor.jsp";

        String id = this.readParameter(request, "id");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);
        Fornecedor forn = null;
        forn = dao.findFornecedor(Long.parseLong(id));

        request.setAttribute("fornecedor", forn);

        return nextAction;
    }

    private String editarFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstfornecedor";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);
        Fornecedor forn = dao.findFornecedor(Long.parseLong(id));

        String cnpj = request.getParameter("cnpj");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String nome = request.getParameter("nome");

        if (cnpj != null && idade != 0 && nome != null && id != null) {
            forn.setIdade(idade);
            forn.setNome(nome);
            forn.setCnpj(cnpj);
            try {
                dao.edit(forn);
            } catch (Exception ex) {
                Logger.getLogger(FornecedorControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("fornecedor", forn);

        return nextAction;
    }

    private String buildAdicionarFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Fornecedor/AddFornecedorView.jsp";

        return nextAction;
    }

    private String adicionarFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstfornecedor";

        String PERSISTENCE_UNIT_NAME = "persistenciaPU";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);
        Fornecedor forn = new Fornecedor();

        String cnpj = request.getParameter("cnpj");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String nome = request.getParameter("nome");

        forn.setCnpj(cnpj);
        forn.setIdade(idade);
        forn.setNome(nome);
        
        dao.create(forn);

        return nextAction;
    }

    private String removerFornecedor(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstfornecedor";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        FornecedorDAO dao = new FornecedorDAO(factory);

        try {
            dao.destroy(Long.parseLong(id));
        } catch (Exception ex) {
            Logger.getLogger(FornecedorControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
