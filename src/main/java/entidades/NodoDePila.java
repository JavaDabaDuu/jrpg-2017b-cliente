package entidades;

/**
 * Clase Nodo de Pila.
 */

public class NodoDePila {

  /** The x. */
  private int x;

  /** The y. */
  private int y;

  /** The ptr siguiente. */
  private NodoDePila ptrSiguiente;

 /**
  * Constructor de la clase Nodo de Pila.
  *
  * @param xAux valor de x donde esta el personaje
  * @param yAux valor de y donde esta el personaje
  */

  public NodoDePila(final int xAux, final int yAux) {
    this.x = xAux;
    this.y = yAux;
    ptrSiguiente = null;
  }

 /**
  * Pide el siguiente .
  *
  * @return devuelve un nodo de pila con el siguiente
  */

  public NodoDePila obtenerSiguiente() {
    return ptrSiguiente;
  }

 /**
  * Setea el siguiente.
  *
  * @param nodoAux nuevo nodo a setear
  */

  public void establecerSiguiente(final NodoDePila nodoAux) {
    ptrSiguiente = nodoAux;
  }

  /**
   * Pide el valor de X .
   *
   * @return devuelve el valor de X
   */

  public int obtenerX() {
    return x;
  }

  /**
   * Pide el valor de Y .
   *
   * @return devuelve el valor de Y
   */

  public int obtenerY() {
    return y;
  }

}
