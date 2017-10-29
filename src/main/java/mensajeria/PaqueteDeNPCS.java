package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

import mensajeria.Paquete;
import mensajeria.PaqueteNPC;

public class PaqueteDeNPCS extends Paquete implements Serializable, Cloneable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private HashMap<Integer, PaqueteNPC> npcs;

  public PaqueteDeNPCS() {
    npcs = new HashMap<Integer, PaqueteNPC>();
  }

  public PaqueteDeNPCS(HashMap<Integer, PaqueteNPC> npcs) {
    this.npcs = npcs;
  }

  public HashMap<Integer, PaqueteNPC> getNpcs() {
    return npcs;
  }

  @Override
public Object clone() {
    Object obj = null;
    obj = super.clone();
    return obj;
  }
}
