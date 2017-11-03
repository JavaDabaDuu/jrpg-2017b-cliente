package comandos;

import juego.Juego;
import mensajeria.Comando;

/**
 * The Class ComandosEscucha.
 */
public abstract class ComandosEscucha extends Comando {

  /** The juego. */
  private Juego juego;

  /**
   * Sets the juego.
   *
   * @param juegoAux the new juego
   */
  public void setJuego(final Juego juegoAux) {
    this.juego = juegoAux;
  }

/**
 * Gets the juego.
 *
 * @return the juego
 */
public Juego getJuego() {
  return juego;
}

}
