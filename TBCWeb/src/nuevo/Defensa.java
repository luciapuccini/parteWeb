package nuevo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Personaje;
import logica.Controlador;

/**
 * Servlet implementation class Defensa
 */
@WebServlet("/Defensa")
public class Defensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Defensa() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 Controlador ctrl= new Controlador();
		 int personajeActivo, ptosDef1=0,ptosDef2=0;
		 
		 
			Personaje p1= (Personaje)request.getSession().getAttribute("Jugador1");
			Personaje p2= (Personaje)request.getSession().getAttribute("Jugador2");
			
			personajeActivo=Integer.parseInt(request.getParameter("personajeActivo"));
			
					
			
			if(ptosDef1 != 0)
			{ 
				ptosDef1=Integer.parseInt(request.getParameter("puntos1"));
			};
			if(ptosDef2 != 0)
				{
				ptosDef2=Integer.parseInt(request.getParameter("puntos2"));
				};
				
			if(personajeActivo ==1)
			{
				p1.defender(ptosDef1);
			}
			else
				if(personajeActivo ==2)
				{
					p2.defender(ptosDef2);
				}
			
			request.getRequestDispatcher("Jugar.jsp").forward(request, response);
			}
	

}
