package nuevo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Tabla;
import entidades.Personaje;
import logica.Controlador;

/**
 * Servlet implementation class Servlett
 */
@WebServlet("/start.jr")
public class Servlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println("LLEGA AL SERVLET");
		
			

			Controlador ctrl = new Controlador();
		Personaje p1= new Personaje();
		p1.setNombre(request.getParameter("Personaje1"));
		Personaje p2= new Personaje();
		p2.setNombre(request.getParameter("Personaje2"));
		p1=ctrl.getPersonaje(p1);
		p2=ctrl.getPersonaje(p2);
		
		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		HttpSession session =request.getSession(true);
		session.setAttribute("jugador1", p1); 
		session.setAttribute("jugador2", p1); 
		request.getRequestDispatcher("Crear.jsp").forward(request, response);
		
	
		
		
		
		
		
		}
	}


