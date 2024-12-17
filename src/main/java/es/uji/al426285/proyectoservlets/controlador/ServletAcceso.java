package es.uji.al426285.proyectoservlets.controlador;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import es.uji.al426285.proyectoservlets.modelo.GestorPaquetes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;


@WebServlet(name = "ServletAcceso", value = "/ServletAcceso")
public class ServletAcceso extends HttpServlet {
    //aqui hacemos esto al principio para que todos compartan el mismo gestor
    private static final Logger logger = Logger.getLogger(ServletAcceso.class.getName());

    @Override
    public void init() throws ServletException {
        logger.info("EJECUTANDO INIT DE SERVLETACCESO");
        ServletContext context = getServletContext();
        GestorPaquetes gestorPaquetes = (GestorPaquetes) context.getAttribute("gestor");
        if (gestorPaquetes == null) {
            gestorPaquetes = new GestorPaquetes(); // Crear uno nuevo si es null
            context.setAttribute("gestor", gestorPaquetes);
            logger.info("Mapa recien creado---> "+gestorPaquetes.toString());
        }

//        logger.info("Entrando en el método init");
//        System.out.println("init ejecutado...");

//        System.out.println("Gestor-->"+gestorPaquetes.toString());
        // si no funciona, guardar el id aqui

    }
    //private AtomicInteger intentos=new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");//tipo de respuest
        logger.info("EJECUTANDO DOGET DE SERVLETACCESO");
        ServletContext context = getServletContext();
        GestorPaquetes gestorPaquetes = (GestorPaquetes) context.getAttribute("gestor");
        if (gestorPaquetes == null) {
            gestorPaquetes = new GestorPaquetes(); // Crear uno nuevo si es null
            context.setAttribute("gestor", gestorPaquetes);
            logger.info("Mapa recien creado---> "+gestorPaquetes.toString());
        }

        logger.info("Entrando en el método doGet");
        //guardamos el identificador
        String id = (String) request.getParameter("codId");
        HttpSession session = request.getSession(true);//parametro true
        //session.removeAttribute("identificador");
        session.setAttribute("identificador", id);

        String tipo=request.getParameter("tipo");//miramos el tipo {cliente o mensajero}
        if ("codCliente".equals(tipo)){
            RequestDispatcher vista= request.getRequestDispatcher("menuCliente.html");
            vista.forward(request,response);
        }
        else if ("codMensajero".equals(tipo)){
        RequestDispatcher vista= request.getRequestDispatcher("menuMensajero.html"); //Redirige la solicitud a una vista JSP:
        vista.forward(request,response);
        }
        else{
            RequestDispatcher vista= request.getRequestDispatcher("index.html"); //Redirige la solicitud a una vista JSP:
            vista.forward(request,response);
        }
    }
}