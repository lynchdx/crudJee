package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearproducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script\n");
      out.write("            src=\"https://code.jquery.com/jquery-3.3.1.min.js\"\n");
      out.write("            integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("    <script type=\"text/javascript\" src=\"js/main.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"https://cdn.hipwallpaper.com/i/0/96/8fmL5G.jpg\">\n");
      out.write("        <h1>Nuevo Producto</h1>\n");
      out.write("\n");
      out.write("        <!--crearproducto es el nombre cambiado del contextpatch der productoServlet.java--> \n");
      out.write("        <form action=\"crearproducto\" enctype=\"multipart/form-data\" method=\"post\" name=\"formcrear\" id=\"form_crear\">\n");
      out.write("\n");
      out.write("            <!--tr = fila   td = columna-->\n");
      out.write("\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Nombre:</label></td>\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"txt_nombre\" id=\"txt_nombre\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Descripción:</label></td>\n");
      out.write("                    <td><textarea class=\"form-control\"  col=\"30\" rows=\"6\" name=\"txa_descripcion\" id=\"txa_descripcion\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Precio:</label></td>\n");
      out.write("                    <td><input  class=\"form-control\" type=\"text\" name=\"txt_precio\" id=\"txt_precio\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Categoría:</label></td>\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"categoria\" id=\"txt_categoria\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Detalles:</label></td>\n");
      out.write("                    <td><textarea class=\"form-control\" col=\"30\" rows=\"6\" name=\"txa_detalle\" id=\"txa_detalle\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Reviews</label></td>\n");
      out.write("                    <td><textarea class=\"form-control\" col=\"30\" rows=\"6\" name=\"txa_reviews\" id=\"txa_reviews\"></textarea></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <!--Carga un cbo con 20 índices-->\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Size:</label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select class=\"form-control\"  name=\"cbo_size\" id=\"cbo_size\">\n");
      out.write("                            <option Value=\"Seleccione un número\">Selccione un número</option>\n");
      out.write("                            ");
for (int i = 1; i < 21; i++) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( i);
      out.write('"');
      out.write('>');
      out.print( i);
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Color:</label></td>\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"txt_color\" id=\"txt_color\"></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"\">Imágenes:</label></td>\n");
      out.write("                    <td><input class=\"form-control\" type=\"file\" name=\"name[]\" id=\"file_archivo\" multiple></td>\n");
      out.write("                    <td><input type=\"submit\" class=\"btn btn-success\" value=\"Crear Producto\" id=\"btn_crear_producto\"></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </table>\n");
      out.write("                                \n");
      out.write("        </form> \n");
      out.write("\n");
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
