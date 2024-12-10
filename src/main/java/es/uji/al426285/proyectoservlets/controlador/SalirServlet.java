package es.uji.al426285.proyectoservlets.controlador;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "SalirServlet", value = "/SalirServlet")
public class SalirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos el gestor del context
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");
        //hacemos la operacion que corresponde con el gestor
        gestor.guardaDatos();

        String id = (String) request.getAttribute("identificador");
        HttpSession session = request.getSession();
        session.setAttribute("identificador", id);

        //Redirigimos la solicitud al inicio
        RequestDispatcher vista = request.getRequestDispatcher("index.html");
        vista.forward(request, response);
    }
}