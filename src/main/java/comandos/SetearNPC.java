package comandos;

import mensajeria.PaqueteDeNPCS;

/**
 * The Class SetearNPC.
 */
public class SetearNPC extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaqueteDeNPCS paquete = (PaqueteDeNPCS) getGson()
        .fromJson(getCadenaLeida(),  PaqueteDeNPCS.class);
    getJuego().setNpcs(paquete.getNpcs());

  }

}
