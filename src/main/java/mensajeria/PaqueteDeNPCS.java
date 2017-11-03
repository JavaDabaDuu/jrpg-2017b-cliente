package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

import mensajeria.Paquete;
import mensajeria.PaqueteNPC;

/**
 * The Class PaqueteDeNPCS.
 */
public class PaqueteDeNPCS extends Paquete implements Serializable, Cloneable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The npcs. */
  private HashMap<Integer, PaqueteNPC> npcs;

  /**
   * Instantiates a new paquete de NPCS.
   */
  public PaqueteDeNPCS() {
    npcs = new HashMap<Integer, PaqueteNPC>();
  }

  /**
   * Instantiates a new paquete de NPCS.
   *
   * @param npcsAux the npcs
   */
  public PaqueteDeNPCS(final HashMap<Integer, PaqueteNPC> npcsAux) {
    this.npcs = npcsAux;
  }

  /**
   * Gets the npcs.
   *
   * @return the npcs
   */
  public HashMap<Integer, PaqueteNPC> getNpcs() {
    return npcs;
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
