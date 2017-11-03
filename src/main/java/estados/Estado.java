
package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Estado.
 */
public abstract class Estado {

  /** The estado actual. */
  private static Estado estadoActual = null;

  /** The estado offline. */
  // Tipo de estados
  private static int estadoOffline = 0;

  /** The estado juego. */
  private static int estadoJuego = 1;

  /** The estado batalla. */
  private static int estadoBatalla = 2;

  /** The estado batalla NPC. */
  private static int estadoBatallaNPC = 3;

  /** The juego. */
  private Juego juego;

  /**
   * Instantiates a new estado.
   *
   * @param juegoAux the juego
   */
  public Estado(final Juego juegoAux) {
    this.setJuego(juegoAux);
  }

  /**
   * Actualizar.
   */
  public abstract void actualizar();

  /**
   * Graficar.
   *
   * @param g the g
   */
  public abstract void graficar(Graphics g);

  /**
   * Sets the estado.
   *
   * @param estadoAux the new estado
   */
  public static void setEstado(final Estado estadoAux) {
    estadoActual = estadoAux;
  }

  /**
   * Gets the estado.
   *
   * @return the estado
   */
  public static Estado getEstado() {
    return estadoActual;
  }

  /**
   * Es estado de juego.
   *
   * @return true, if successful
   */
  public abstract boolean esEstadoDeJuego();

/**
 * Gets the estado batalla.
 *
 * @return the estado batalla
 */
public static int getEstadoBatalla() {
  return estadoBatalla;
}

/**
 * Sets the estado batalla.
 *
 * @param estadoBatallaAux the new estado batalla
 */
public static void setEstadoBatalla(final int estadoBatallaAux) {
  Estado.estadoBatalla = estadoBatallaAux;
}

/**
 * Gets the estado batalla NPC.
 *
 * @return the estado batalla NPC
 */
public static int getEstadoBatallaNPC() {
  return estadoBatallaNPC;
}

/**
 * Sets the estado batalla NPC.
 *
 * @param estadoBatallaNPCAux the new estado batalla NPC
 */
public static void setEstadoBatallaNPC(final int estadoBatallaNPCAux) {
  Estado.estadoBatallaNPC = estadoBatallaNPCAux;
}

/**
 * Gets the estado juego.
 *
 * @return the estado juego
 */
public static int getEstadoJuego() {
  return estadoJuego;
}

/**
 * Sets the estado juego.
 *
 * @param estadoJuegoAux the new estado juego
 */
public static void setEstadoJuego(final int estadoJuegoAux) {
  Estado.estadoJuego = estadoJuegoAux;
}

/**
 * Gets the estado offline.
 *
 * @return the estado offline
 */
public static int getEstadoOffline() {
  return estadoOffline;
}

/**
 * Sets the estado offline.
 *
 * @param estadoOfflineAux the new estado offline
 */
public static void setEstadoOffline(final int estadoOfflineAux) {
  Estado.estadoOffline = estadoOfflineAux;
}

/**
 * Gets the juego.
 *
 * @return the juego
 */
public Juego getJuego() {
   return juego;
}

/**
 * Sets the juego.
 *
 * @param juegoAux the new juego
 */
public void setJuego(final Juego juegoAux) {
  this.juego = juegoAux;
}
}
