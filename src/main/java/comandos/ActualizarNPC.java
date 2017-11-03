package comandos;

import mensajeria.PaqueteNPC;

/**
 * The Class ActualizarNPC.
 */
public class ActualizarNPC extends ComandosEscucha {

  /* (non-Javadoc)
   * @see mensajeria.Comando#ejecutar()
   */
  @Override
  public void ejecutar() {
    PaqueteNPC paqueteNpc = (PaqueteNPC)
        getGson().fromJson(getCadenaLeida(), PaqueteNPC.class);

    getJuego().getNpcs().remove(paqueteNpc.getId());
    getJuego().getNpcs().put(paqueteNpc.getId(), paqueteNpc);

    if (getJuego().getPaqueteNpc().getId() == paqueteNpc.getId()) {
      getJuego().actualizarPaqueteNpc();
      getJuego().getEstadoJuego().actualizarNpc();
      getJuego().getCliente()
          .actualizarNPC(getJuego().getNpcs().get(paqueteNpc.getId()));

    }
  }
}
