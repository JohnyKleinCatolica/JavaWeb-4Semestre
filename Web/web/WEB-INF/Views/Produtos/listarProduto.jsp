<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="${app}">
        <meta name="author" content="Johny Klein">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">              
        <link rel="stylesheet" href="assets/styles/style.css">
        <title>${app}</title>
    </head>

    <body>

        <%@ include file="/WEB-INF/Views/menu.jsp" %>

        <div class="row"> <!-- Inicio Lista de Fornecedores -->
            <div class="col-xs-8 col-xs-offset-2">
                <table class="table table-hover table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th class="col-xs-1">Id</th>
                            <th class="col-xs-5">Nome</th>
                            <th class="col-xs-5">Preço</th>
                            <th class="col-xs-5">Cliente</th>
                            <th class="col-xs-5">Fornecedor</th>                            
                            <th class="col-xs-1 hidden">#</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${produto}">
                            <tr>
                                <td class="col-xs-1">${o.id}</td>
                                <td class="col-xs-5">${o.nome}</td>
                                <td class="col-xs-5">${o.preco}</td>
                                <td class="col-xs-5">${o.cliente}</td>
                                <td class="col-xs-5">${o.fornecedor}</td>
                                <td class="col-xs-1">
                                <td class="col-xs-6 glyphicon glyphicon-edit"><a href="Produto?do=buildEditar&id=${o.id}">Editar</a></td>
                                <td class="col-xs-6 glyphicon glyphicon-remove"><a href="Produto?do=remover&id=${o.id}">Remover</a></td>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>   
            </div>
        </div> <!-- Fim Lista de Fornecedores -->

        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <a class="btn btn-default" href="Fornecedor?do=buildAdicionar">Criar Fornecedor</a>

        <script type="text/javascript" src="assets/core/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="assets/core/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    </body>
</html>

