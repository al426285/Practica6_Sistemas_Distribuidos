package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.json.simple.JSONObject;

//mensajero

@WebServlet(name = "RecogerPaquetesServlet", value = "/RecogerPaquetesServlet")
public class RecogerPaquetesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher("formularioRecoge.html");
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("identificador");
        long codPaquete = Long.parseLong(request.getParameter("codPaquete"));
        JSONObject res = gestor.recogePaquete(codPaquete, id);
        if (!res.isEmpty()) {
            request.setAttribute("exito", true);
        } else {
            request.setAttribute("exito", false);
        }
        request.setAttribute("codPaquete", codPaquete);
        request.setAttribute("codMensajero", id);
        RequestDispatcher vista = request.getRequestDispatcher("confirmacionRecogePaquete.jsp");
        vista.forward(request, response);
    }
}