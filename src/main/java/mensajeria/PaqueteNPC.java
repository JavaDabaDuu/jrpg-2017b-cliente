package mensajeria;

import dominio.NonPlayableCharacter;
import estados.Estado;

import java.io.Serializable;

public class PaqueteNPC extends Paquete implements Serializable, Cloneable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private NonPlayableCharacter npc;
  private int id;
  private String tipo;

  private int posX;
  private int posY;
  private int estado;

  public PaqueteNPC() {
  }

  public PaqueteNPC(int id, String nombre, String tipo, int nivel, int dificultad,
      int posX, int posY) {
    this.npc = new NonPlayableCharacter(nombre, nivel, dificultad);
    this.id = id;
    this.tipo = tipo;
    this.posX = posX;
    this.posY = posY;
    this.estado = Estado.estadoJuego;
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

  public NonPlayableCharacter getNpc() {
    return this.npc;
  }

  public void setNpc(NonPlayableCharacter npc) {
    this.npc = npc;
  }

  public boolean estaEnRango(int xNPC, int yNPC, int xc, int yc) {
	  double distancia = Math.sqrt(Math.pow(xNPC - xc, 2) + Math.pow(yNPC - yc, 2) );
   if(distancia < 10){
	   return true;
   }
   else {
	   return false;
   }
  }

public int getEstado() {
	return this.estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}

public void setPosX(float x) {
	this.posX = (int)(x);
}

public void setPosY(float y) {
	this.posY = (int)(y);
}

}
