package mensajeria;

import java.io.Serializable;

public class PaqueteNPC extends Paquete implements Serializable, Cloneable {
	
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private int inteligencia;
	private int destreza;
	private String nombre;
	
	
	public PaqueteNPC (String nombre,int destreza,int inteligencia,int fuerza,int saludTope,int energiaTope) {
		this.saludTope = saludTope;
		this.energiaTope = energiaTope;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
		this.nombre = nombre;
	}


	public int getSaludTope() {
		return saludTope;
	}


	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}


	public int getEnergiaTope() {
		return energiaTope;
	}


	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}


	public int getFuerza() {
		return fuerza;
	}


	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}


	public int getDestreza() {
		return destreza;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
