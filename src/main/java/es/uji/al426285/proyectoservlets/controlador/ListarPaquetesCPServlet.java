package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//mensajero

@WebServlet(name = "ListarPaquetesCPServlet", value = "/ListarPaquetesCPServlet")
public class ListarPaquetesCPServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ServletAcceso.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //en caso de salir/invalidar la sesion que lo redirija a la pagina principal y no pueda hacer nada mas
        if (session == null || session.getAttribute("identificador") == null) {
            response.sendRedirect("index.html"); // Redirige al inicio de sesión
            return;
        }
        //Lanzamos el fromulario para que inserte el cp de donde quiere recoger el paquete
        RequestDispatcher vista = request.getRequestDispatcher("formularioListaCP.html");
        vista.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos el gestor del context
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");

        //obtenemos los parametros que necesitamos
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("identificador");

        String cpDestino=request.getParameter("codPostal");
        //hacemos la operacion que corresponde con el gestor
        JSONArray array = gestor.listaPaquetesCP(cpDestino);
//        logger.info("GESTOR----> "+gestor.toString());
//        logger.info("array----> "+array.toString());
        ArrayList<String> res = new ArrayList<>();
        for (Object obj : array) {
            res.add(obj.toString());
        }
        //lo guardamos para recuperarlo en el jsp
        request.setAttribute("resultado", res);
        //Redirigimos la solicitud al inicio
        RequestDispatcher vista = request.getRequestDispatcher("listadoPaquetesCP.jsp");
        vista.forward(request, response);
    }
}
