package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class PaqueteDePersonajes.
 */
public class PaqueteDePersonajes extends Paquete implements Serializable,
Cloneable {

  /** The personajes. */
  private Map<Integer, PaquetePersonaje> personajes;

  /**
   * Instantiates a new paquete de personajes.
   */
  public PaqueteDePersonajes() {

  }

  /**
   * Instantiates a new paquete de personajes.
   *
   * @param personajesAux the personajes
   */
  public PaqueteDePersonajes(
  final Map<Integer, PaquetePersonaje> personajesAux) {
    this.personajes = personajesAux;
  }

  /**
   * Gets the personajes.
   *
   * @return the personajes
   */
  public Map<Integer, PaquetePersonaje> getPersonajes() {
    return personajes;
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
