package mensajeria;

import dominio.NonPlayableCharacter;
import estados.Estado;

import java.io.Serializable;

/**
 * The Class PaqueteNPC.
 */
public class PaqueteNPC extends Paquete implements Serializable, Cloneable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

/** The npc. */
private NonPlayableCharacter npc;

  /** The id. */
  private int id;

  /** The tipo. */
  private String tipo;

  /** The pos X. */
  private int posX;

  /** The pos Y. */
  private int posY;

  /** The estado. */
  private int estado;

  /** Dificultad del NPC*/
  private int dificultad;

  
  /**
   * Instantiates a new paquete NPC.
   */
  public PaqueteNPC() {
  }

  /**
   * Instantiates a new paquete NPC.
   *
   * @param idAux the id
   * @param nombreAux the nombre
   * @param tipoAux the tipo
   * @param nivelAux the nivel
   * @param dificultadAux the dificultad
   * @param posXAux the pos X
   * @param posYAux the pos Y
   */
  public PaqueteNPC(final int idAux, final String nombreAux,
  final String tipoAux, final int nivelAux, final int dificultadAux,
  final int posXAux, final int posYAux) {
    this.npc = new NonPlayableCharacter(nombreAux, nivelAux, dificultadAux);
    this.id = idAux;
    this.tipo = tipoAux;
    this.posX = posXAux;
    this.posY = posYAux;
    this.estado = Estado.getEstadoJuego();
    this.dificultad = dificultadAux;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Gets the nombre.
   *
   * @return the nombre
   */
  public String getNombre() {
    return this.npc.getNombre();
  }

  /**
   * Gets the tipo.
   *
   * @return the tipo
   */
  public String getTipo() {
    return this.tipo;
  }

  /**
   * Gets the pos X.
   *
   * @return the pos X
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Gets the pos Y.
   *
   * @return the pos Y
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Gets the npc.
   *
   * @return the npc
   */
  public NonPlayableCharacter getNpc() {
    return this.npc;
  }

  /**
   * Sets the npc.
   *
   * @param npcAux the new npc
   */
  public void setNpc(final NonPlayableCharacter npcAux) {
    this.npc = npcAux;
  }

  /**
   * Esta en rango.
   *
   * @param xNPC the x NPC
   * @param yNPC the y NPC
   * @param xc the xc
   * @param yc the yc
   * @return true, if successful
   */
  public boolean estaEnRango(
  final int xNPC, final int yNPC, final int xc, final int yc) {
    double distancia = Math.sqrt(Math.pow(xNPC - xc, 2)
        + Math.pow(yNPC - yc, 2));
    return distancia < 10;
    /*
     if (distancia < 10)
     {
     return true;
     }
     else
     {
       return false;
     }
    */
   }

/**
 * Gets the estado.
 *
 * @return the estado
 */
public int getEstado() {
  return this.estado;
}

/**
 * Sets the estado.
 *
 * @param estadoAux the new estado
 */
public void setEstado(final int estadoAux) {
  this.estado = estadoAux;
}

/**
 * Sets the pos X.
 *
 * @param x the new pos X
 */
public void setPosX(final float x) {
  this.posX = (int) (x);
}

/**
 * Sets the pos Y.
 *
 * @param y the new pos Y
 */
public void setPosY(final float y) {
  this.posY = (int) (y);
}

/**
 * Se obtiene la dificultad del NPC
 */
public int getDificultad() {
	return this.dificultad;
}


}
