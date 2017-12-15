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
import org.ftd.educational.catolica.prog4.daos.FornecedorDAO;
import org.ftd.educational.catolica.prog4.daos.ProdutoDAO;
import org.ftd.educational.catolica.prog4.entities.Client;
import org.ftd.educational.catolica.prog4.entities.Fornecedor;
import org.ftd.educational.catolica.prog4.entities.Produto;

/**
 *
 * @author johny.klein
 */
@WebServlet(name = "ProdutoControllerServletServlet", urlPatterns = {"/Produto"}, initParams
        = {
            @WebInitParam(name = "do", value = "")})
public class ProdutoControllerServlet extends HttpServlet {

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
                nextAction = adicionarProduto(request, response);
                break;
            case "buildAdicionar":
                nextAction = buildAdicionarProduto(request, response);
                break;
            case "buildEditar":
                nextAction = buildEditarProduto(request, response);
                break;
            case "editar":
                nextAction = editarProduto(request, response);
                break;
            case "remover":
                nextAction = removerProduto(request, response);
                break;
            default:
                request.setAttribute("msg", "Erro controller: recebi obscuro do=" + action);
                nextAction = "signin.jsp";
        }

        request.getRequestDispatcher(nextAction).forward(request, response);
    }

    private String buildEditarProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Produtos/editarProduto.jsp";

        String id = this.readParameter(request, "id");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        Produto prod = null;
        prod = dao.findProduto(Long.parseLong(id));

        request.setAttribute("fornecedor", prod);

        return nextAction;
    }

    private String editarProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstprodutos";
        String idProd = request.getParameter("idProd");
        String idClient = request.getParameter("idClient");
        String idForn = request.getParameter("idForn");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        Produto produtoEntity = dao.findProduto(Long.parseLong(idProd));
        ClientDAO clientDao = new ClientDAO(factory);
        Client clientEntity = clientDao.findClient(Long.parseLong(idClient));
        FornecedorDAO fornDao = new FornecedorDAO(factory);
        Fornecedor fornecedorEntity = fornDao.findFornecedor(Long.parseLong(idForn));

        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String client = request.getParameter("client");
        String fornecedor = request.getParameter("fornecedor");

        if (nome != null && preco != null && client != null && fornecedor != null && idForn != null) {
            clientEntity.setName(client);
            produtoEntity.setCliente(clientEntity);
            fornecedorEntity.setNome(fornecedor);
            produtoEntity.setFornecedor(fornecedorEntity);
            produtoEntity.setNome(nome);
            produtoEntity.setPreco(Double.parseDouble(preco));
            try {
                dao.edit(produtoEntity);
            } catch (Exception ex) {
                Logger.getLogger(ProdutoControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("produto", produtoEntity);

        return nextAction;
    }

    private String buildAdicionarProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "/WEB-INF/Views/Produtos/AddProdutoView.jsp";

        return nextAction;
    }

    private String adicionarProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstproduto";

        String idClient = request.getParameter("idClient");
        String idFornecedor = request.getParameter("idFornecedor");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);
        Produto produtoEntity = new Produto();
        ClientDAO clientDao = new ClientDAO(factory);
        Client clientEntity = clientDao.findClient(Long.parseLong(idClient));
        FornecedorDAO fornDao = new FornecedorDAO(factory);
        Fornecedor fornecedorEntity = fornDao.findFornecedor(Long.parseLong(idFornecedor));

        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String client = request.getParameter("client");
        String fornecedor = request.getParameter("fornecedor");

        clientEntity.setName(client);
        produtoEntity.setCliente(clientEntity);
        fornecedorEntity.setNome(fornecedor);
        produtoEntity.setFornecedor(fornecedorEntity);
        produtoEntity.setNome(nome);
        produtoEntity.setPreco(Long.parseLong(preco));

        dao.create(produtoEntity);

        return nextAction;
    }

    private String removerProduto(HttpServletRequest request, HttpServletResponse response) {
        String nextAction = "Menu?do=lstproduto";
        String id = request.getParameter("id");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        ProdutoDAO dao = new ProdutoDAO(factory);

        try {
            dao.destroy(Long.parseLong(id));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
