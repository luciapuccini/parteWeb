package nuevo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Personaje;
import logica.Controlador;

/**
 * Servlet implementation class Ataque
 */
@WebServlet("/Ataque")
public class Ataque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ataque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Controlador ctrl= new Controlador();
	 int personajeActivo, ptosAtaque1=0,ptosAtaque2=0, rta;
	 HttpSession session =request.getSession(true);
	 Personaje p1= (Personaje)session.getAttribute("Jugador1");
	 Personaje p2= (Personaje)session.getAttribute("Jugador2");
	 
	
		if(ptosAtaque1 != 0)
		{
		ptosAtaque1=Integer.parseInt(request.getParameter("puntos1"));
		}
		if(ptosAtaque2 != 0)
		{
		ptosAtaque2=Integer.parseInt(request.getParameter("puntos2"));
		}
		
		personajeActivo=Integer.parseInt(request.getParameter("personajeActivo").trim());
		
		
		if(personajeActivo == 1)
		{
		
			rta=p1.atacar(ptosAtaque1, p2, ctrl);
			if (rta==1)
			{
				System.out.println("fin del juego! ganador: "+p1.getNombre());
			}
			else
			{
				p1.setEnergiaPartida(p1.getEnergiaPartida()-ptosAtaque1);
				p2.setVidaPartida(p2.getVidaPartida()-ptosAtaque1);
				request.getSession().setAttribute("Jugador1", p1);
				request.getSession().setAttribute("Jugador2", p2);
			}
		}	
		else
		{
				if (personajeActivo == 2)
				
			{
				rta=p2.atacar(ptosAtaque2, p1, ctrl);
				if (rta==1)
				{
					System.out.println("fin del juego! ganador: "+p2.getNombre());
				}
				else
				{
					p2.setEnergiaPartida(p2.getEnergiaPartida()-ptosAtaque2);
					p1.setVidaPartida(p1.getVidaPartida()-ptosAtaque2);
					request.getSession().setAttribute("Jugador1", p1);
					request.getSession().setAttribute("Jugador2", p2);
				}
			}
		}
		
		
		
		request.getRequestDispatcher("Jugar.jsp").forward(request, response);
		
			
	}

}
