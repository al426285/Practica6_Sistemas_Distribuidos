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


@WebServlet(name = "ModificarPaqueteServlet", value = "/ModificarPaqueteServlet")
public class ModificarPaqueteServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ServletAcceso.class.getName());

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
//        logger.info("Por aqui modificar, cliente--> "+id);
        String CPorigen = (String) request.getParameter("CPorigen");
        String CPdestino = (String) request.getParameter("CPdestino");
        double peso = Double.parseDouble(request.getParameter("peso"));
        long codPaquete = Long.parseLong(request.getParameter("codPaquete"));


        JSONObject res = gestor.modificaPaquete(id, codPaquete, CPorigen, CPdestino, peso);

//        logger.info("Por aqui modificar, resultado para--> "+codPaquete+CPorigen+CPdestino+peso);
//        logger.info("Resultado final-->"+res);

        CPorigen = (String) res.get("CPOrigen");
        CPdestino = (String) res.get("CPDestino");
        try {
            peso = Double.parseDouble(res.get("peso").toString()); //OJO!!!
        } catch (NullPointerException e) {
            peso=0;
        }

        if (!res.isEmpty()) {
            request.setAttribute("exito", true);
            String fecha =  (String) res.get("fechaEnvio");
            request.setAttribute("CPorigen", CPorigen);
            request.setAttribute("CPdestino", CPdestino);
            request.setAttribute("fechaEnvio", fecha);
            request.setAttribute("peso", peso);
        } else {
            request.setAttribute("exito", false);
        }
        request.setAttribute("codPaquete", codPaquete);
        request.setAttribute("codCliente", id);

        RequestDispatcher vista = request.getRequestDispatcher("confirmacionModificaPaquete.jsp");
        vista.forward(request, response);
    }
}