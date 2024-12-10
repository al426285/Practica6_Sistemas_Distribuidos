package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;


@WebServlet(name = "ServletAcceso", value = "/ServletAcceso")
public class ServletAcceso extends HttpServlet {
    //aqui hacemos esto al principio para que todos compartan el mismo gestor
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        GestorPaquetes gestorPaquetes=new GestorPaquetes();
        context.setAttribute("gestor", gestorPaquetes);
        // si no funciona, guardar el id aqui
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");//tipo de respuesta

        //guardamos el identificador
        String id = (String) request.getAttribute("identificador");
        HttpSession session = request.getSession();
        session.setAttribute("identificador", id);

        String tipo=request.getParameter("tipo");//miramos el tipo {cliente o mensajero}
        if (tipo.equals("cliente")){
            RequestDispatcher vista= request.getRequestDispatcher("menuCliente.html");
            vista.forward(request,response);
        }
        else{
        RequestDispatcher vista= request.getRequestDispatcher("menuMensajero.html"); //Redirige la solicitud a una vista JSP:
        vista.forward(request,response);
        }
    }
}