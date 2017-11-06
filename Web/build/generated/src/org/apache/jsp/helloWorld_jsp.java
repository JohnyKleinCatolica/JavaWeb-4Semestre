package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class helloWorld_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
            private String metodo(){
                return "Johny";
            }
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">              \n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/styles/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-12\">\n");
      out.write("                    <ul class=\"nav nav-tabs\">\n");
      out.write("                        <li role=\"presentation\" class=\"active\"><a href=\"views/main.jsp\">Home</a></li>\n");
      out.write("                        <li role=\"presentation\"><a href=\"ajaxCidades.html\">Cidades</a></li>\n");
      out.write("                        <li role=\"presentation\"><a href=\"helloWorld.jsp\">Testes</a></li>\n");
      out.write("                            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                <li><a href=\"cadastroCliente.jsp\">Cadastrar Cliente</a></li>\n");
      out.write("                                <li><a href=\"login.jsp\">Logout</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                     </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>       \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.print( "Teste" );
      out.write("\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("         ");
 out.println(this.metodo()); 
      out.write("\n");
      out.write("\n");
      out.write("        Cliente\n");
      out.write("        \n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
