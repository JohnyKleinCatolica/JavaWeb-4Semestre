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
    </head>
    <body>
        
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
            
    </body>
</html>
