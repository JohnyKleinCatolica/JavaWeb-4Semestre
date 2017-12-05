<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <!-- HEAD -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="${app}">
        <meta name="author" content="Fábio Tavares Dippold">

        <link rel="icon" href="assets/icons/qb-icon.png">
        <title>${app}</title>

        <!-- Bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
    </head><!-- /HEAD -->

    <!-- DIV MODAL SAIR -->
    <div class="modal fade" id="sair-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalLabel">Ação: SAIR</h4>
                </div>
                <div class="modal-body">Deseja sair do sistema?</div>
                <div class="modal-footer">
                    <button id="btnSair" type="button" class="btn btn-primary" onclick="javascript:$('#formSair').submit();">Sim</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                </div>
            </div>
        </div>
    </div><!-- /DIV MODAL SAIR-->    

    <body>
        <!-- MAIN CONTAINER -->   
        <div id="main" class="container-fluid"> 

            <!-- SIMPLE MENU BAR -->            

            <!-- /SIMPLE MENU BAR -->

            <!-- DIV-LIST -->
            <div id="list" class="row">
                <!-- SIMPLE GRID... -->
                <div class="table-responsive col-md-12">
                    <!-- TABLE -->
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <!-- DATAGRID-LINES -->
                        <tbody>
                            <c:forEach var="o" items="${users}">
                                <tr>
                                    <td>
                                        <!-- DESCRIÇÃO PRINCIPAL -->
                                        <a class="btn btn-warning btn-xs" href="mvccustomer?do=update&id=${o.id}" title="ATUALIZAR">
                                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                        <a class="btn btn-success btn-xs" href="mvccustomer?do=read&id=${o.id}" title="VISUALIZAR/APAGAR">
                                            <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
                                        &nbsp;&nbsp;
                                        <c:if test="${showColumnId == true}">
                                            <span class="label label-info">${o.id}</span>&nbsp;
                                        </c:if>    
                                        ${o.name}
                                        <!-- /DESCRIÇÃO PRINCIPAL -->
                                    </td>
                                </tr>
                            </c:forEach>                        
                        </tbody><!-- /DATAGRID-LINES -->

                    </table><!-- /TABLE -->
                </div>
                <BR>
            </div><!-- /DIV-LIST -->

            <!-- FORM TO SIGNOUT -->
            <form id="formSair" name="formSair" method="POST" action="mvc?class=LogOutModel"></form> 
            <!-- /FORM TO SIGNOUT -->            

        </div><!--/MAIN CONTAINER -->

        <!-- CORE JAVASCRIPT LYBRARIES -->
        <script type="text/javascript" src="assets/core/jquery-2.1.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script>
                        $(document).ready(function () {

                        });
        </script>
        <!-- /CORE JAVASCRIPT LYBRARIES -->
    </body>
</html>
