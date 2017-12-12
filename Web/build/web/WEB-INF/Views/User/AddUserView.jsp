<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">              
        <link rel="stylesheet" href="assets/styles/style.css">
        <title>Cadastro Usuário</title>
    </head>
    <body>         
        
        <%@ include file="/WEB-INF/Views/menu.jsp" %>
        
        <div class="container"> <!-- Inicio Form Cadastrar -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-12 col-md-8 col-md-offset-4">
                        <h1>Cadastro de Usuário</h1>
                    </div>
                    <div class="col-xs-12">
                        <form name="frmCadUser" method="POST" action="User?do=adicionar">
                            <b>Nome:</b> 
                            <input  class="form-control" type="text" id="name" name="name">
                            <input  class="form-control hidden" type="text" id="id" name="id">
                            <b>Login:</b> 
                            <input  class="form-control" id="login" name="login">
                            <b>Senha:</b> 
                            <input class="form-control" type="password" id="senha" name="senha">  
                            
                            <button type="reset" class="btn btn-default">Resetar</button>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>
                </div>
            </div> <!-- Fim Form Editar -->
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
