
package mundo;

/**
 * The Class Nodo.
 */
public class Nodo {

  /** The x. */
  private int x;

  /** The y. */
  private int y;

  /** The indice. */
  private int indice;

  /** The cantidad de adyacentes. */
  private int cantidadDeAdyacentes;

  /** The nodos adyacentes. */
  private Nodo[] nodosAdyacentes;

  /** The Constant CANT_NODOS. */
  private static final int CANT_NODOS = 8;

  /**
   * Instantiates a new nodo.
   *
   * @param indiceAux the indice
   * @param xAux the x
   * @param yAux the y
   */
  public Nodo(final int indiceAux, final int xAux, final int yAux) {
    this.x = xAux;
    this.y = yAux;
    this.indice = indiceAux;
    cantidadDeAdyacentes = 0;
    nodosAdyacentes = new Nodo[CANT_NODOS];
  }

  /**
   * Obtener X.
   *
   * @return the int
   */
  public int obtenerX() {
    return x;
  }

  /**
   * Obtener Y.
   *
   * @return the int
   */
  public int obtenerY() {
    return y;
  }

  /**
   * Obtener indice.
   *
   * @return the int
   */
  public int obtenerIndice() {
    return indice;
  }

  /**
   * Obtener nodos adyacentes.
   *
   * @return the nodo[]
   */
  public Nodo[] obtenerNodosAdyacentes() {
    return nodosAdyacentes;
  }

  /**
   * Agregar adyacente.
   *
   * @param nodo the nodo
   */
  public void agregarAdyacente(final Nodo nodo) {
    nodosAdyacentes[cantidadDeAdyacentes++] = nodo;
  }

  /**
   * Obtener cantidad de adyacentes.
   *
   * @return the int
   */
  public int obtenerCantidadDeAdyacentes() {
    return cantidadDeAdyacentes;
  }
}
