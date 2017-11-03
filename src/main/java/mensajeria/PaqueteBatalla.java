package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteBatalla.
 */
public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {

  /** The id. */
  private int id;

  /** The id enemigo. */
  private int idEnemigo;

  /** The mi turno. */
  private boolean miTurno;

  /**
   * Instantiates a new paquete batalla.
   */
  public PaqueteBatalla() {
    setComando(Comando.BATALLA);
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
   * Checks if is mi turno.
   *
   * @return true, if is mi turno
   */
  public boolean isMiTurno() {
    return miTurno;
  }

  /**
   * Sets the mi turno.
   *
   * @param miTurnoAux the new mi turno
   */
  public void setMiTurno(final boolean miTurnoAux) {
    this.miTurno = miTurnoAux;
  }
}
