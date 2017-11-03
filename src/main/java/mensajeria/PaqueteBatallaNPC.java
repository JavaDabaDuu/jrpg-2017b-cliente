package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteBatallaNPC.
 */
public class PaqueteBatallaNPC extends Paquete implements Serializable,
Cloneable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
  * The id.
  */
  private int id;

  /**
  * The id enemigo.
  */
  private int idEnemigo;

  /**
  * The mi turno.
  */
  private boolean miTurno;

  /**
  * Instantiates a new paquete batalla NPC.
  */
  public PaqueteBatallaNPC() {
    setComando(Comando.BATALLANPC);
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
  * @param idAux
  *            the new id
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
  * @param idEnemigoParam
  *            the new id enemigo
  */
  public void setIdEnemigo(final int idEnemigoParam) {
    this.idEnemigo = idEnemigoParam;
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
