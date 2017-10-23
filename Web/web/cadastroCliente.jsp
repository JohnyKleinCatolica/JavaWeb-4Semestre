<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">              
        <link rel="stylesheet" href="assets/styles/style.css">
        <title>Cadastro Cliente</title>
    </head>
    <body>  
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-xs-12 col-md-8 col-md-offset-4">
                        <h1>Cadastro de Cliente</h1>
                    </div>
                    <div class="col-xs-12">
                        <form action="show">
                            <b>Nome:</b> <input type="text" id="nameInput" name="nameInput"> <br/>
                            <b>Id</b>: <input type="text" id="idInput" name="idInput"> <br/>
                            <b>Data de Nascimento:</b> <input type="date" id="dtNascInput" name="dtNascInput"> <br/>
                            <b>Email:</b> <input type="email" id="loginInput" name="loginInput"> <br/>
                            <b>Senha:</b> <input type="password" id="pswrdSenha" name="pswrdSenha"> <br/>                           
                            <button type="reset" class="btn btn-default">Resetar</button>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
