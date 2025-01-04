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
import java.util.logging.Logger;


@WebServlet(name = "SalirServlet", value = "/SalirServlet")
public class SalirServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ServletAcceso.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos el gestor del context
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");
        //hacemos la operacion que corresponde con el gestor
        gestor.guardaDatos();

        HttpSession session = request.getSession();

        //en caso de salir/invalidar la sesion que lo redirija a la pagina principal y no pueda hacer nada mas
        if (session == null || session.getAttribute("identificador") == null) {
            response.sendRedirect("index.html"); // Redirige al inicio de sesión
            return;
        }

        String id= (String) session.getAttribute("identificador");
//        logger.info("ID--> "+id);
        request.setAttribute("id",id);

        //Redirigimos la solicitud al inicio
        RequestDispatcher vista = request.getRequestDispatcher("Bienvenida.jsp");
        vista.forward(request, response);

        if (session != null) {
            session.invalidate();  // Destruye la sesión, borrando todos los atributos
        }
    }
}