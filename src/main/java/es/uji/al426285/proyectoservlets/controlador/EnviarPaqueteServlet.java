package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;


@WebServlet(name = "EnviarPaqueteServlet", value = "/EnviarPaqueteServlet")
public class EnviarPaqueteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //en caso de salir/invalidar la sesion que lo redirija a la pagina principal y no pueda hacer nada mas
        if (session == null || session.getAttribute("identificador") == null) {
            response.sendRedirect("index.html"); // Redirige al inicio de sesión
            return;
        }

        //Redirigimos la solicitud para que rellene con sus datos
        RequestDispatcher vista = request.getRequestDispatcher("formularioEnvio.html");
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("identificador");
        String CPorigen = (String) request.getParameter("CPorigen");
        String CPdestino = (String) request.getParameter("CPdestino");
        double peso = Double.parseDouble(request.getParameter("peso"));
        JSONObject res = gestor.enviaPaquete(id, CPorigen, CPdestino, peso);
        long codPaquete = (long) res.get("codPaquete");
        String codCliente = (String) res.get("codCliente");
        request.setAttribute("codPaquete", codPaquete);
        request.setAttribute("codCliente", codCliente);
        RequestDispatcher vista = request.getRequestDispatcher("confirmacionEnvioPaquete.jsp");
        vista.forward(request, response);
    }
}