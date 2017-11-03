
package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMensaje.
 */
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {

  /** The user emisor. */
  private String userEmisor;

  /** The user receptor. */
  private String userReceptor;

  /** The msj. */
  private String msj;

  /**
   * Instantiates a new paquete mensaje.
   */
  public PaqueteMensaje() {
  }

  /**
   * Gets the mensaje.
   *
   * @return the msj
   */
  public String getMensaje() {
    return msj;
  }

  /**
   * Sets the user mensaje.
   *
   * @param mensaje the msj
   */
  public void setMensaje(final String mensaje) {
    this.msj = mensaje;
  }

  /**
   * Gets the user emisor.
   *
   * @return the user emisor
   */
  public String getUserEmisor() {
    return userEmisor;
  }

  /**
   * Sets the user emisor.
   *
   * @param idEmisor the new user emisor
   */
  public void setUserEmisor(final String idEmisor) {
    this.userEmisor = idEmisor;
  }

  /**
   * Gets the user receptor.
   *
   * @return the user receptor
   */
  public String getUserReceptor() {
    return userReceptor;
  }

  /**
   * Sets the user receptor.
   *
   * @param idReceptor the new user receptor
   */
  public void setUserReceptor(final String idReceptor) {
    this.userReceptor = idReceptor;
  }

  /* (non-Javadoc)
   * @see mensajeria.Paquete#clone()
   */
  @Override
public Object clone() {
    Object obj = null;
    obj = super.clone();
    return obj;
  }
}
