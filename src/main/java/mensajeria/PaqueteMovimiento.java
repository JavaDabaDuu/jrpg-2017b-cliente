package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMovimiento.
 */
public class PaqueteMovimiento extends Paquete implements Serializable,
Cloneable {

  /** The id. */
  private int id;

  /** The pos X. */
  private float posX;

  /** The pos Y. */
  private float posY;

  /** The direccion. */
  private int direccion;

  /** The frame. */
  private int frame;

  /**
   * Instantiates a new paquete movimiento.
   */
  public PaqueteMovimiento() {
    setComando(Comando.MOVIMIENTO);
  }

  /**
   * Instantiates a new paquete movimiento.
   *
   * @param idPersonajeAux the id personaje
   */
  public PaqueteMovimiento(final int idPersonajeAux) {
    id = idPersonajeAux;
    setComando(Comando.MOVIMIENTO);
  }

  /**
   * Instantiates a new paquete movimiento.
   *
   * @param idPersonajeAux the id personaje
   * @param posXAux the pos X
   * @param posYAux the pos Y
   */
  public PaqueteMovimiento(final int idPersonajeAux,
  final float posXAux, final float posYAux) {
    this.id = idPersonajeAux;
    this.posX = posXAux;
    this.posY = posYAux;
    setComando(Comando.MOVIMIENTO);
  }

  /**
   * Gets the id personaje.
   *
   * @return the id personaje
   */
  public int getIdPersonaje() {
    return id;
  }

  /**
   * Sets the id personaje.
   *
   * @param idPersonajeAux the new id personaje
   */
  public void setIdPersonaje(final int idPersonajeAux) {
    this.id = idPersonajeAux;
  }

  /**
   * Gets the pos X.
   *
   * @return the pos X
   */
  public float getPosX() {
    return posX;
  }

  /**
   * Sets the pos X.
   *
   * @param posXAux the new pos X
   */
  public void setPosX(final float posXAux) {
    this.posX = posXAux;
  }

  /**
   * Gets the pos Y.
   *
   * @return the pos Y
   */
  public float getPosY() {
    return posY;
  }

  /**
   * Sets the pos Y.
   *
   * @param posYAux the new pos Y
   */
  public void setPosY(final float posYAux) {
    this.posY = posYAux;
  }

  /**
   * Gets the direccion.
   *
   * @return the direccion
   */
  public int getDireccion() {
    return direccion;
  }

  /**
   * Sets the direccion.
   *
   * @param direccionAux the new direccion
   */
  public void setDireccion(final int direccionAux) {
    this.direccion = direccionAux;
  }

  /**
   * Gets the frame.
   *
   * @return the frame
   */
  public int getFrame() {
    return frame;
  }

  /**
   * Sets the frame.
   *
   * @param frameAux the new frame
   */
  public void setFrame(final int frameAux) {
    this.frame = frameAux;
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

