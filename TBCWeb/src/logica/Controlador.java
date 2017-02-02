package logica;

import datos.DataPersonaje;
import datos.Tabla;
import entidades.Personaje;
import utils.ApplicationException;

public class Controlador 
{

	Personaje p1;
	Personaje p2;
	
	public Personaje getP1() {
		return p1;
	}

	public void setP1(Personaje p1) {
		this.p1 = p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	//private datos.DataPersonaje dataPer;
	private DataPersonaje dataPer=new DataPersonaje();
	
	
	
	
	
	public Controlador()
	{
	};
	
	
	public Personaje dameUno()
	{
	
		Personaje p=this.getP1();
	
		
		return p;
	}
	public Personaje dameDos()
	{
		Personaje p=this.getP2();
		
		
		return p;
	}
	

	

	public void update(Personaje p) throws ApplicationException  
	{
		if( p1==p || p2==p )
		{
			Personaje perEnc=this.getPersonaje(p);
			
			perEnc.setNombre(p.getNombre());
			perEnc.setVida(p.getVida());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setPuntos(p.getPuntos());
			perEnc.setEvasion(p.getEvasion());
			
		}
		else
		{
			throw new ApplicationException("El Personaje no existe");
		}
		
		dataPer.update(p);
	};
	
	
	public void modifica(Personaje p) throws ApplicationException  
	{
		if( p1==p || p2==p )
		{
			Personaje perEnc=this.getPersonaje(p);
			
			perEnc.setNombre(p.getNombre());
			perEnc.setVida(p.getVida());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setPuntos(p.getPuntos());
			perEnc.setEvasion(p.getEvasion());
			
		}
		else
		{
			throw new ApplicationException("El Personaje no existe");
		}
		
		dataPer.Modifica(p);
	};
	
	public void delete(Personaje p){
		dataPer.delete(p);;
	};
	
	public Personaje getPersonaje(Personaje p)//no uso
	{
		/*
		 * Personaje perEnc=null;
		/*int i=Personajes.indexOf(p);
		if(i>=0){
			perEnc=Personajes.get(i);
		}
		return perEnc;*/
		return dataPer.getByNombre(p.getNombre());
	}

	
public Personaje buscaPersonaje(String nomb)

	{
		Personaje p;
		p=dataPer.getByNombre(nomb);
	
		return p;
	}


public void insertarPersonaje(Personaje pnew)throws ApplicationException
	{
		if(pnew.getNombre() != null) 
			if(pnew.getDefensa() != 0)
			{
			  if(pnew.getEnergia() != 0)
				{
				if(pnew.getEvasion() != 0)
				{
				  if(pnew.getVida() !=0)	
					{
					  {	dataPer.add(pnew);	}
											
					}		
				}	
				}
		    }
			
		};
}

	
	
	

