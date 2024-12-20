package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;
import java.util.logging.Logger;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.json.simple.JSONObject;


@WebServlet(name = "RetirarPaqueteServlet", value = "/RetirarPaqueteServlet")
public class RetirarPaqueteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher("formularioRetiro.html");
        vista.forward(request, response);
    }

    private static final Logger logger = Logger.getLogger(ServletAcceso.class.getName());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("identificador");
        long codPaquete = Long.parseLong(request.getParameter("codPaquete"));
        JSONObject res = gestor.retiraPaquete(id, codPaquete);
       // logger.info("Retirando--> "+codPaquete+" y es el -->"+res);


        if (!res.isEmpty()) {
            String fecha =  (String) res.get("fechaEnvio");
            String CPorigen = (String) res.get("CPOrigen");
            String CPdestino = (String) res.get("CPDestino");
            double peso = Double.parseDouble(res.get("peso").toString()); //OJO!!!
            request.setAttribute("exito", true);
            request.setAttribute("CPorigen", CPorigen);
            request.setAttribute("CPdestino", CPdestino);
            request.setAttribute("fechaEnvio", fecha);
            request.setAttribute("peso", peso);
        } else {
            request.setAttribute("exito", false);
        }
        request.setAttribute("codPaquete", codPaquete);

        request.setAttribute("codCliente", id);
        RequestDispatcher vista = request.getRequestDispatcher("confirmacionRetiroPaquete.jsp");
        vista.forward(request, response);
    }
}