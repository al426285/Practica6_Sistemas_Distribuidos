package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;
import java.util.ArrayList;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;


@WebServlet(name = "ListarPaquetesServlet", value = "/ListarPaquetesServlet")
public class ListarPaquetesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos el gestor del context
        ServletContext context = getServletContext();
        GestorPaquetes gestor = (GestorPaquetes) context.getAttribute("gestor");

        //obtenemos los parametros que necesitamos
        HttpSession session = request.getSession();

        //en caso de salir/invalidar la sesion que lo redirija a la pagina principal y no pueda hacer nada mas
        if (session == null || session.getAttribute("identificador") == null) {
            response.sendRedirect("index.html"); // Redirige al inicio de sesión
            return;
        }

        String codcli = (String) session.getAttribute("identificador");

        //hacemos la operacion que corresponde con el gestor
        JSONArray array= gestor.listaPaquetesCliente(codcli);
        ArrayList<String> res=new ArrayList<>();
        for (Object obj:array.toArray()){

            res.add(obj.toString());
        }

        //lo guardamos para recuperarlo en el jsp
        request.setAttribute("resultado",res);

        //Redirigimos la solicitud al inicio
        RequestDispatcher vista = request.getRequestDispatcher("listadoPaquetesCliente.jsp");
        vista.forward(request, response);

    }


}