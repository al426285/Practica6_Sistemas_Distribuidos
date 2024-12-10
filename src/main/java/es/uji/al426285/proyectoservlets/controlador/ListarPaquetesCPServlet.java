package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;
import java.util.ArrayList;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import org.json.simple.JSONArray;


@WebServlet(name = "ListarPaquetesCPServlet", value = "/ListarPaquetesCPServlet")
public class ListarPaquetesCPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos el gestor del context
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");

        //obtenemos los parametros que necesitamos
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("identificador");

        //hacemos la operacion que corresponde con el gestor
        JSONArray array = gestor.listaPaquetesCP(id);
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
