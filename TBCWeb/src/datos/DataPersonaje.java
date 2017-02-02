package datos;


import java.sql.*;



import entidades.*;
import utils.ApplicationException;

public class DataPersonaje {
	
	public ResultSet getQuery(String _query)
	{
		Statement state = null;
		ResultSet resultado = null;
		
		try{
		 
			try {
				state = (Statement) MyDataAccess.getInstancia().getConn().createStatement();
			} catch (ApplicationException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultado = state.executeQuery(_query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		return resultado;
	}
	
	public void setQuery(String _query)

	{
		Statement state = null;
		
		try{			
			try {
				state=(Statement) MyDataAccess.getInstancia().getConn().createStatement();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state.execute(_query);

         } catch (SQLException e){
            e.printStackTrace();
       }
	}

	public DataPersonaje(){
		
	}
	
	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=MyDataAccess.getInstancia().getConn().prepareStatement("INSERT INTO personajes VALUES (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1,p.getNombre());
			stmt.setInt(2,p.getEnergia());
			stmt.setInt(3,p.getVida());
			stmt.setInt(4,p.getDefensa());
			stmt.setInt(5,p.getEvasion());
			stmt.setInt(6,p.getPuntos());
			int retorno = stmt.executeUpdate();      
			 if (retorno>0)
			 {
		           System.out.println("Insertado correctamente");
			 }

			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setNombre(rs.getString(1)); //--duda--
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo un problema al intentar conectarse a la base de datos");
			e.printStackTrace();
			
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				MyDataAccess.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Hubo un problema al intentar conectarse a la base de datos");
				e.printStackTrace();
			}
		}
		
	}
	
	public void update(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= MyDataAccess.getInstancia().getConn().prepareStatement(
					"update Personajes set  nombre=?, puntos_totales=?"+
					" where nombre=?");
			
			stmt.setString(1,p.getNombre());
			stmt.setInt(2,p.getPuntos());
			stmt.setString(3,p.getNombre());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo un problema al intentar conectarse a la base de datos");
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				MyDataAccess.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Hubo un problema al intentar conectarse a la base de datos");
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = MyDataAccess.getInstancia().getConn().prepareStatement(
					"delete from Personajes where nombre=?");
			stmt.setString(1, p.getNombre());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo un problema al intentar conectarse a la base de datos");
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				MyDataAccess.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Hubo un problema al intentar conectarse a la base de datos");
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
		public /*static*/ Personaje getByNombre(String per)//busqueda!!!
		{
			Personaje p=null;
			
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				
						
				Class.forName("com.mysql.jdbc.Connection");
				
				 try {
					stmt = MyDataAccess.getInstancia().getConn().prepareStatement("SELECT nombre, vida, puntos_totales,energia,defensa,evasion "
					 		+ "FROM personajes WHERE nombre=?");
				 	} catch (ApplicationException e) 
				 	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				 	}
						
				stmt.setString(1, per);
				
				rs= stmt.executeQuery();
				if(rs!=null && rs.next())// no me cierra
				{
					p=new Personaje();
					p.setVida(rs.getInt("vida"));
					p.setDefensa(rs.getInt("defensa"));
					p.setPuntos(rs.getInt("puntos_totales"));
					p.setEvasion(rs.getInt("evasion"));
					p.setEnergia(rs.getInt("energia"));
					p.setNombre(rs.getString("nombre"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("hubo un problema al conectar con la bd..");
				e.printStackTrace();
			} catch(ClassNotFoundException e)
				{
				System.out.println(e);
				}
			
			
			
			return p;

		}
		public void Modifica(Personaje p){
			PreparedStatement stmt=null;
			
			try {
				stmt= MyDataAccess.getInstancia().getConn().prepareStatement(
						"update Personajes set  nombre=?,energia=?,vida=?,defensa=?,evasion=?, puntos_totales=?"+
						" where nombre=?");
				
				stmt.setString(1,p.getNombre());
				stmt.setInt(2,p.getEnergia());
				stmt.setInt(3,p.getVida());
				stmt.setInt(4,p.getDefensa());
				stmt.setInt(5, p.getEvasion());
				stmt.setInt(6,p.getPuntos());
				stmt.setString(7,p.getNombre());
				
				stmt.execute();
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Hubo un problema al intentar conectarse a la base de datos");
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(stmt!=null)stmt.close();
					MyDataAccess.getInstancia().releaseConn();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Hubo un problema al intentar conectarse a la base de datos");
					e.printStackTrace();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
	}