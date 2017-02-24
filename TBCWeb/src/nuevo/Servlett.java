package nuevo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Personaje;
import logica.Controlador;

/**
 * Servlet implementation class Servlett
 */
@WebServlet("/Servlett")
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
		
	
		
		Controlador ctrl = new Controlador();
		Personaje p1= new Personaje();
		Personaje p2= new Personaje();
		
		p1.setNombre(request.getParameter("Jugador1"));
		
		p2.setNombre(request.getParameter("Jugador2"));
		
		p1=ctrl.getPersonaje(p1);
		p2=ctrl.getPersonaje(p2);
		p1.setVidaPartida(p1.getVidaOriginal());
		p1.setEnergiaPartida(p1.getEnergiaOriginal());
		p2.setVidaPartida(p2.getVidaOriginal());
		p2.setEnergiaPartida(p2.getEnergiaOriginal());
		
		//if (p1== null){System.out.println("nop, esta null");}
		//else{
		
	
		HttpSession session =request.getSession(true);
		session.setAttribute("Jugador1", p1); 
		session.setAttribute("Jugador2", p2); 
		request.getRequestDispatcher("Jugar.jsp").forward(request, response);
		
		
		
		
		
		
		
		}
	}


