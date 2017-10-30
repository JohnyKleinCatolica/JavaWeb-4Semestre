<%-- 
    Document   : JSP
    Created on : 11/09/2017, 20:53:48
    Author     : johny.klein
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <li role="presentation" class="active"><a href="home.jsp">Home</a></li>
                        <li role="presentation"><a href="ajaxCidades.html">Cidades</a></li>
                        <li role="presentation"><a href="helloWorld.jsp">Testes</a></li>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="cadastroCliente.jsp">Cadastrar Cliente</a></li>
                                <li><a href="login.jsp">Logout</a></li>
                            </ul>
                     </ul>
                </div>
            </div>
        </div>       
        
        <%! 
            private String metodo(){
                return "Johny";
            }
        %>
        
        <%= "Teste" %>
        
        <br/>
        
        <%
            int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
            int mes = Integer.parseInt((new SimpleDateFormat("M")).format(new Date()));
            int ano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date()));
            
            out.println("<h1> Hoje é o dia: " + dia + "</h1>");
            
            if(mes==1){
                out.println("Hoje é " + dia + " de Janeiro de " + ano);
            } else if(mes==2){
                out.println("Hoje é " + dia + " de Fevereiro de " + ano);
            } else if(mes==3){
                out.println("Hoje é " + dia + " de Março de " + ano);
            } else if(mes==4){
                out.println("Hoje é " + dia + " de Abril de " + ano);
            } else if(mes==5){
                out.println("Hoje é " + dia + " de Maio de " + ano);
            } else if(mes==6){
                out.println("Hoje é " + dia + " de Junho de " + ano);
            } else if(mes==7){
                out.println("Hoje é " + dia + " de Julho de " + ano);
            } else if(mes==8){
                out.println("Hoje é " + dia + " de Agosto de " + ano);
            } else if(mes==9){
                out.println("Hoje é " + dia + " de Setembro de " + ano);
            } else if(mes==10){
                out.println("Hoje é " + dia + " de Outubro de " + ano);
            } else if(mes==11){
                out.println("Hoje é " + dia + " de Novembro de " + ano);
            } else {
                out.println("Hoje é " + dia + " de Dezembro de " + ano);
            }  
        %>
        
        <br/>
        
         <% out.println(this.metodo()); %>

        Cliente
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
