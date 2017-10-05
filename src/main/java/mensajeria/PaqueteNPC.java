package mensajeria;

import java.io.Serializable;

import dominio.NonPlayableCharacter;

public class PaqueteNPC extends Paquete implements Serializable, Cloneable {

	private NonPlayableCharacter npc;
	private int id;
	private String tipo;

	private int posX;
	private int posY;
	
	public PaqueteNPC() {
		
	}

	public PaqueteNPC(int id, String nombre, String tipo, int nivel, int dificultad, int posX, int posY) {
		this.npc = new NonPlayableCharacter(nombre, nivel, dificultad);
		this.id = id;
		this.tipo = tipo;
		this.posX = posX;
		this.posY = posY;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.npc.getNombre();
	}

	public String getTipo() {
		return this.tipo;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
