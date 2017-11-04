package comandos;

import estados.Estado;
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

    getJuego().getNpcs().get(paqueteNpc.getId()).setPosX(paqueteNpc.getPosX());
    getJuego().getNpcs().get(paqueteNpc.getId()).setPosY(paqueteNpc.getPosY());
    Estado.setEstado(getJuego().getEstadoJuego());

    getJuego().getNpcs().get(paqueteNpc.getId())
        .setEstado(paqueteNpc.getEstado());

  }
}
