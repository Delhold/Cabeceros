import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//Anotacion en el cual vamos a poner la key
//para enlazar al servlet
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        //Seteo el tipo de contendido que va a devolver
        // el servidor (setContenttype): va a devolver
        //un texto html
        response.setContentType("text/html");
        //Defino una varuable de tipo PrintWriter
        //para mostrar contenido en pantalla
        PrintWriter out = response.getWriter();
        //Con esto vamos a tener una respuesta de tipo Get o de tipo post
        String metodo = request.getMethod();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.printf("<meta charset=\"utf-8\">");
        out.printf("<title> Hola Mundo </title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Obteniendo cabeceros</h1>");
        out.print("El metodo que se utilizo es "+metodo);
        String uri=request.getRequestURI();
        out.print("<br>");
        out.print("La uri es "+uri);
        //Vamos a imprimir todos los cabeceros
        //que utiliza mi aplicacion
        out.print("<br>");
        //Organiza en forma de Lista
        Enumeration cabeceros=request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabeceros=(String)cabeceros.nextElement();
            out.print("<b>"+nombreCabeceros+"</b>");
            out.print(request.getHeader(nombreCabeceros));
            out.print("<br>");


        }
        out.print("</body>");

        out.print("</html>");
    }
}
