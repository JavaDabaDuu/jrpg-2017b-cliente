package mensajeria;

import dominio.NonPlayableCharacter;

import java.io.Serializable;

public class PaqueteNPC extends Paquete implements Serializable, Cloneable {

  private NonPlayableCharacter npc;
  private int id;
  private String tipo;

  private int posX;
  private int posY;
  private boolean estadoBatalla;

  public PaqueteNPC() {
  }

  public PaqueteNPC(int id, String nombre, String tipo, int nivel, int dificultad,
      int posX, int posY) {
    this.npc = new NonPlayableCharacter(nombre, nivel, dificultad);
    this.id = id;
    this.tipo = tipo;
    this.posX = posX;
    this.posY = posY;
    this.estadoBatalla = false;
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

  public boolean estaEnRango(int posxNPC, int posyNPC, int posXPersonaje, int posYPersonaje) {
    return (Math.abs(Math.sqrt(Math.pow(posXPersonaje - posxNPC, 2)) 
        + Math.pow(posYPersonaje - posyNPC, 2)) < 10);
  }

public boolean isEstadoBatalla() {
	return estadoBatalla;
}

public void setEstadoBatalla(boolean estadoBatalla) {
	this.estadoBatalla = estadoBatalla;
}

public boolean getEstadoBatalla() {
	return this.estadoBatalla;
}

}
