|<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">              
        <link rel="stylesheet" href="assets/styles/style.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="home.jsp">Home</a></li>
                        <li role="presentation"><a href="ajaxCidades.html">Cidades</a></li>
                        <li role="presentation"><a href="helloWorld.jsp">Testes</a></li>
                     </ul>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-12 col-md-7 col-md-offset-5">
                        <h1>Bem Vindo!</h1>
                    </div>
                    <div class="col-xs-12">
                        <form id="frmsignin" name="frmsignin" method="POST" action="signin">
                            <b>Usuario:</b> 
                            <input  class="form-control" type="text" id="user" name="user">
                            <b>Senha</b>: 
                            <input  class="form-control" type="password" id="password" name="password">
                            
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>     
                </div>
                <div class="col-xs-12">
                     Não possui uma conta? Crie seu <a href="cadastroCliente.jsp">cadastro</a>.
                </div>                  
            </div>
        </div>        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
    </body>
</html>
