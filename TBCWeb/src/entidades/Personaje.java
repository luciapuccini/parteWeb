package entidades;

import java.io.Serializable;
import java.util.Random;

import datos.DataPersonaje;
import logica.Controlador;
import utils.ApplicationException;

@SuppressWarnings("serial")
public class Personaje implements Serializable
	{
//-----------Attributes--------------//
	 int energia;
	 int evasion;
	 int vida;
	 int defensa;
	 int puntos;
	 String nombre;
	 int energiaOriginal;
	 int vidaOriginal;
	 int vidaPartida;
	 public int getVidaPartida() {
		return vidaPartida;
	}
	public void setVidaPartida(int vidaPartida) {
		this.vidaPartida = vidaPartida;
	}
	public int getEnergiaPartida() {
		return energiaPartida;
	}
	public void setEnergiaPartida(int energiaPartida) {
		this.energiaPartida = energiaPartida;
	}

	int energiaPartida;
	 Controlador ctrl;
//----------getters y setters----------------------//
	 public  Controlador getCtrl() {
			return ctrl;
		}
		public  void setCtrl(Controlador c) {
			this.ctrl = c;
		}
	 
	public  int getEnergia() {
		return energia;
	}
	public  void setEnergia(int energia) {
		this.energia = energia;
	}
	public  int getEvasion() {
		return evasion;
	}
	public  void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public  int getVida() {
		return vida;
	}
	public  void setVida(int vida) {
		this.vida = vida;
	}
	public  int getDefensa() {
		return defensa;
	}
	public  void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public  int getPuntos() {
		return puntos;
	}
	public  void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public int getEnergiaOriginal() {
		return energiaOriginal;
	}
	public void setEnergiaOriginal(int energiaOriginal) {
		this.energiaOriginal = energiaOriginal;
	}
	public int getVidaOriginal() {
		return vidaOriginal;
	}
	public void setVidaOriginal(int vidaOriginal) {
		this.vidaOriginal = vidaOriginal;
	}
	
	
	
	
	public void recibirAtaque(int valorAtaque)
	{
		Random numAleatorio= new Random();
		
	
		if ((numAleatorio.nextInt()*100) < this.getEvasion())
		{
			System.out.println( "ATAQUE Ok, vida:"+this.getVida());
			this.setVida(this.getVida()-valorAtaque);
		
			
			if(this.getVida() <= 0)
			{ 
				System.out.println( this.getNombre() +"perdio");
				
			}
		}
		else
		{
			System.out.println( "evadio el ataque");
		}
	};
	public int atacar(int valorAtaque,Personaje pAtacado,Controlador c)
	{
		if(valorAtaque <= energia)
	{
		this.setEnergia(this.getEnergia()-valorAtaque);
		pAtacado.recibirAtaque(valorAtaque);
		if (pAtacado.getVida()<=0)
		
		{
			setCtrl(c);
			this.Actualizacion(c);
			return 1;
		}
	//	return 1; --> este el original
	}else
	{System.out.println( "no tiene suficiente energia");}
		return 0;
	};
	
	public int defender(int defensa)
	{
		if(defensa <= energia)
		{
			int energiaARecuperar = energiaOriginal * defensa / 100 ;
		
		int vidaARecuperar = vidaOriginal * defensa / 250 ;
		
		if(this.getEnergia() + energiaARecuperar < energiaOriginal)
		{this.setEnergia(this.getEnergia() + energiaARecuperar);}
		if(this.getVida() + vidaARecuperar<vidaOriginal)
		{this.setVida(this.getVida() + vidaARecuperar);}
		return 1;
		}else
		{
			{System.out.println( "no tiene suficiente energia");}
			return 0;
		}
	};
	
	DataPersonaje data = new DataPersonaje();

	
	public void Actualizacion(Controlador c)
	{
		setCtrl(c);
		this.puntos=puntos+10;
	System.out.println("llega " +puntos);
	try {
		ctrl.update(this);
		System.exit(0);
	} catch (ApplicationException e) {
		
		e.printStackTrace();
	}
	}
	
	}//fin personaje
