package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteFinalizarBatalla.
 */
public class PaqueteFinalizarBatalla extends Paquete implements Serializable,
Cloneable {

/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;

/** The id. */
private int id;

  /** The id enemigo. */
  private int idEnemigo;

  /** The ganador batalla. */
  private int ganadorBatalla;

  /**
   * Instantiates a new paquete finalizar batalla.
   */
  public PaqueteFinalizarBatalla() {
    setComando(Comando.FINALIZARBATALLA);
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
   * Sets the id.
   *
   * @param idAux the new id
   */
  public void setId(final int idAux) {
    this.id = idAux;
  }

  /**
   * Gets the id enemigo.
   *
   * @return the id enemigo
   */
  public int getIdEnemigo() {
    return idEnemigo;
  }

  /**
   * Sets the id enemigo.
   *
   * @param idEnemigoAux the new id enemigo
   */
  public void setIdEnemigo(final int idEnemigoAux) {
    this.idEnemigo = idEnemigoAux;
  }

  /**
   * Gets the ganador batalla.
   *
   * @return the ganador batalla
   */
  public int getGanadorBatalla() {
    return ganadorBatalla;
  }

  /**
   * Sets the ganador batalla.
   *
   * @param ganadorBatallaAux the new ganador batalla
   */
  public void setGanadorBatalla(final int ganadorBatallaAux) {
    this.ganadorBatalla = ganadorBatallaAux;
  }
}
