package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.json.simple.JSONObject;


@WebServlet(name = "ModificarPaqueteServlet", value = "/ModificarPaqueteServlet")
public class ModificarPaqueteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher("formularioModifica.html");
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
        long codPaquete = Long.parseLong(request.getParameter("codPaquete"));


        JSONObject res = gestor.modificaPaquete(id, codPaquete, CPorigen, CPdestino, peso);


        CPorigen = (String) res.get("CPorigen");
        CPdestino = (String) res.get("CPdestino");
        peso = Double.parseDouble(res.get("peso").toString()); //OJO!!!

        if (!res.isEmpty()) {
            request.setAttribute("exito", true);
        } else {
            request.setAttribute("exito", false);
        }

        String fecha =  (String) res.get("fechaEnvio");
        request.setAttribute("CPorigen", CPorigen);
        request.setAttribute("CPdestino", CPdestino);
        request.setAttribute("fechaEnvio", fecha);
        request.setAttribute("peso", peso);
        request.setAttribute("codPaquete", codPaquete);
        RequestDispatcher vista = request.getRequestDispatcher("confirmacionModificaPaquete.jsp");
        vista.forward(request, response);
    }
}