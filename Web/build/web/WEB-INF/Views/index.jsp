<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home - Projeto Final 4 Semestre</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">              
        <link rel="stylesheet" href="assets/styles/style.css">
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="main.jsp">Home</a></li>
                        <li role="presentation"><a href="ajaxCidades.html">Cidades</a></li>
                        <li role="presentation"><a href="helloWorld.jsp">Testes</a></li>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">
                                    Olá, 
                                   ${username}
                                </a>  
                            </li>
                            <li><a href="login.jsp">Logout</a></li>

                        </ul>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="container">
                    <h1>Página Principal</h1>
                </div>
            </div>                    
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
